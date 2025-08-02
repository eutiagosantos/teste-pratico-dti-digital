import React, { useState } from "react";
import { Calendar, Dog, PawPrint, Award, AlertTriangle, Loader } from "lucide-react";
import "./App.css";

export default function PetshopCalculatorImproved() {
  const [formData, setFormData] = useState({
    date: "",
    smallDogs: "",
    largeDogs: "",
  });
  const [result, setResult] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleInputChange = (field, value) => {
    setFormData((prev) => ({
      ...prev,
      [field]: value,
    }));
  };

  const handleSubmit = async () => {
    setIsLoading(true);
    setResult(null);
    setError(null);

    if (!formData.date) {
      setError("Por favor, selecione uma data.");
      setIsLoading(false);
      return;
    }

    if (!formData.smallDogs && !formData.largeDogs) {
      setError("Por favor, informe a quantidade de pelo menos um tipo de cão.");
      setIsLoading(false);
      return;
    }

    await new Promise(resolve => setTimeout(resolve, 1000));

    try {
      const formattedDate = formData.date;

      const requestBody = {
        date: formattedDate,
        smallDog: parseInt(formData.smallDogs || "0"),
        bigDog: parseInt(formData.largeDogs || "0"),
      };

      console.log("Enviando dados para o backend:", requestBody);

      const response = await fetch("http://localhost:8080/petshop", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(requestBody),
      });

      console.log("Status da resposta:", response.status);

      if (!response.ok) {
        const errorText = await response.text();
        console.error("Erro da resposta:", errorText);
        throw new Error(`Erro do servidor (${response.status}): ${errorText || 'Verifique se o backend está rodando.'}`);
      }

      const data = await response.json();
      console.log("Dados recebidos do backend:", data);

      if (data.error || data.erro) {
        throw new Error(data.error || data.erro || "Erro retornado pelo servidor");
      }

      if (!data.name || data.totalPrice === undefined) {
        throw new Error("Resposta do servidor está incompleta. Verifique a estrutura de dados.");
      }

      const price = typeof data.totalPrice === 'number' ? data.totalPrice : parseFloat(data.totalPrice);

      if (isNaN(price)) {
        throw new Error("Preço retornado pelo servidor é inválido.");
      }

      const formattedPrice = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
      }).format(price);

      setResult({
        petshopName: data.name,
        totalPrice: formattedPrice,
      });

    } catch (err) {
      console.error("Erro na requisição:", err);

      if (err instanceof TypeError && err.message.includes('fetch')) {
        setError("Não foi possível conectar ao servidor. Verifique se o backend está rodando na porta 8080.");
      } else if (err instanceof Error) {
        setError(err.message);
      } else {
        setError("Ocorreu um erro inesperado. Verifique o console para mais detalhes.");
      }
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="petshop-container">
      <div className="petshop-card">

        <div className="petshop-header">
          <h1 className="petshop-title">Calculadora de Petshops</h1>
          <p className="petshop-subtitle">
            Encontre o melhor custo-benefício para o banho dos seus cães.
          </p>
        </div>

        <div className="petshop-form">

          <div className="input-group">
            <label className="input-label">
              Data do Banho
            </label>
            <div className="input-container">
              <Calendar className="input-icon input-icon-small" />
              <input
                type="date"
                value={formData.date}
                onChange={(e) => handleInputChange("date", e.target.value)}
                required
              />
            </div>
          </div>

          <div className="input-group-grid">
            <div className="input-group">
              <label className="input-label">
                Cães Pequenos
              </label>
              <div className="input-container">
                <Dog className="input-icon input-icon-small" />
                <input
                  type="number"
                  min="0"
                  placeholder="Quantidade"
                  value={formData.smallDogs}
                  onChange={(e) => handleInputChange("smallDogs", e.target.value)}
                />
              </div>
            </div>

            <div className="input-group">
              <label className="input-label">
                Cães Grandes
              </label>
              <div className="input-container">
                <Dog className="input-icon input-icon-large" />
                <input
                  type="number"
                  min="0"
                  placeholder="Quantidade"
                  value={formData.largeDogs}
                  onChange={(e) => handleInputChange("largeDogs", e.target.value)}
                />
              </div>
            </div>
          </div>

          <button
            onClick={handleSubmit}
            disabled={isLoading}
            className="petshop-button"
          >
            {isLoading ? (
              <>
                <Loader className="spinner" size={20} />
                <span>Calculando...</span>
              </>
            ) : (
              <>
                <PawPrint size={20} />
                <span>Encontrar Melhor Preço!</span>
              </>
            )}
          </button>
        </div>

        <div className="results-area">
          {error && (
            <div className="error-message">
              <div className="error-content">
                <AlertTriangle className="error-icon" />
                <div>
                  <p className="error-title">Ocorreu um erro</p>
                  <p className="error-text">{error}</p>
                </div>
              </div>
            </div>
          )}

          {result && !isLoading && (
            <div className="success-result">
              <h3 className="success-title">Melhor Opção Encontrada:</h3>
              <div className="success-card">
                <Award className="success-icon" />
                <p className="success-petshop-name">{result.petshopName}</p>
                <p className="success-price">{result.totalPrice}</p>
              </div>
            </div>
          )}
        </div>

      </div>
    </div>
  );
}