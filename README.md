# Teste Prático DTI Digital

Este projeto é uma aplicação full-stack desenvolvida com **Spring Boot** no backend e **React** no frontend para o teste prático da DTI Digital.

## 🚀 Tecnologias

### Backend
- Java 21+
- Spring Boot
- Maven

### Frontend
- React 18+
- Node.js 24
- npm/yarn

## 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java 21** ou superior
- **Node.js 18** ou superior
- **Maven 3.6** ou superior
- **Git**

## 🚀 Instruções para Execução Local

### **Passo 1: Clone o Repositório**

```bash
git clone https://github.com/eutiagosantos/teste-pratico-dti-digital.git
cd teste-pratico-dti-digital
```

### **Passo 2: Executar o Backend (Spring Boot)**

1. **Opção A - Executar diretamente com Maven:**
```bash
./mvnw spring-boot:run
```

2. **Opção B - Compilar e executar o JAR:**
```bash
# Compilar o projeto
./mvnw clean package

# Executar o JAR gerado
java -jar target/*.jar
```

4. **Verificar se está funcionando:**
   - Acesse: `http://localhost:8080`
   - Você deve ver uma resposta da API ou página de status

**💡 Dica:** No Windows, use `mvnw.cmd` ao invés de `./mvnw`

### **Passo 3: Executar o Frontend (React)**

1. **Abra um NOVO terminal** e navegue para o frontend:
```bash
cd frontend/my-app
```

2. **Instale as dependências:**
```bash
npm install
```

3. **Execute o projeto em modo desenvolvimento:**
```bash
npm run dev
```

4. **Verificar se está funcionando:**
   - O navegador deve abrir automaticamente em `http://localhost:3000`
   - Se não abrir, acesse manualmente

### **Passo 4: Verificação Final**

✅ **Backend**: `http://localhost:8080` - API REST funcionando  
✅ **Frontend**: `http://localhost:5173` - Interface React carregada  
✅ **Comunicação**: Frontend consegue fazer chamadas para o backend  

### **⚡ Execução Rápida (Resumo)**

Para desenvolvedores experientes:

```bash
# Terminal 1 - Backend
./mvnw spring-boot:run

# Terminal 2 - Frontend  
cd frontend && npm install && npm run dev
```

### **🔄 Parando a Aplicação**

- **Backend**: `Ctrl + C` no terminal do Spring Boot
- **Frontend**: `Ctrl + C` no terminal do React

## 📋 Premissas Assumidas

Durante o desenvolvimento deste projeto, as seguintes premissas foram assumidas:

### 🔹 **Arquitetura e Tecnologia**
- **Separação clara entre frontend e backend**: Optou-se por uma arquitetura desacoplada com APIs REST
- **Sem autenticação complexa**: Para simplificar o teste, não foi implementado sistema de login/autenticação
- **Sem persistência de dados**: Os dados são mantidos em memória durante a execução da aplicação
- **Padrão strategy**: Assumi que se eu utilizasse o padrao de projeto strategy o codigo ficaria bem mais organizado

## 🏗️ Decisões de Projeto

### **Escolha das Tecnologias**

**Spring Boot (Backend)**
- ✅ **Rapidez de desenvolvimento**: Spring Boot permite configuração mínima e foco na lógica de negócio
- ✅ **Ecossistema maduro**: Ampla documentação e comunidade ativa
- ✅ **Facilidade para APIs REST**: Anotações simples para criar endpoints
- ✅ **Uma escolha pessoal**: O spring boot é o framework que mais tenho conhecimento

**React (Frontend)**
- ✅ **Component-based**: Facilita reutilização e manutenção do código
- ✅ **Ecosystem rico**: Ampla variedade de bibliotecas e ferramentas
- ✅ **Virtual DOM**: Performance otimizada para interfaces dinâmicas
- ✅ **Developer experience**: Excelentes ferramentas de desenvolvimento

### **Arquitetura Escolhida**

```
Frontend (React)     →     Backend (Spring Boot)
Port: 5173          →      Port: 8080
     ↓              →           ↓
  Components        →      Controllers
  Services          →      Services  
  State Management  →      DTOs/Models
```

### **Padrões de Desenvolvimento**

**Backend (Spring Boot)**
- **Controller → Service → Strategy pattern**: Separação clara de responsabilidades
- **DTOs**: Para transferência de dados entre camadas
- **Exception handling**: Tratamento centralizado de exceções
- **CORS configuration**: Configuração para permitir comunicação com o frontend

**Frontend (React)**
- **Abordagem moderna do React**
- **Component composition**: Componentes pequenos e focados

## 👨‍💻 Autor

**Tiago Santos**
- GitHub: [@eutiagosantos](https://github.com/eutiagosantos)

---

## 🆘 Problemas Comuns

### Backend não inicia
- Verifique se a versão do Java é 21 ou superior
- Verifique se a porta 8080 não está em uso

### Erro de CORS
- Certifique-se de que o backend está configurado para aceitar requisições do frontend
