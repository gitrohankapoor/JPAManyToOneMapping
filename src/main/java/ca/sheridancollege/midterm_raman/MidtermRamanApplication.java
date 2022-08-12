package ca.sheridancollege.midterm_raman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MidtermRamanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MidtermRamanApplication.class, args);
	}

	/*@Bean
	public RestTemplate getRestTemplate(){
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(httpComponentsClientHttpRequestFactory);
	}*/

}
