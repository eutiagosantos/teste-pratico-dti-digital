package dti.teste.pratico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

// removi essas configuracoes porque acho que nao precisa de banco de dados nesse teste
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class, 
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})
public class PraticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticoApplication.class, args);
	}

}
