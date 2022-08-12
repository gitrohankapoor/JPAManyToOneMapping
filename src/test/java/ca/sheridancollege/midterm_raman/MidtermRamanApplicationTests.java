package ca.sheridancollege.midterm_raman;

import ca.sheridancollege.midterm_raman.model.TelevisionShow;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.TreeSet;

@SpringBootTest
class MidtermRamanApplicationTests {
	@Test
	void contextLoads() {
	}

	@Test
	public void addTest(){
		RestTemplate restTemplate = new RestTemplate();
		String successful = "Successfully Added";
		String url = "http://localhost:8080/tv/addShow";
		TelevisionShow tv = new TelevisionShow();
		tv.setShowName("FamilyMan");
		tv.setShowTime("9 AM");
		tv.setShowDescription("FamilyMan-Desc");
		tv.setShowDay("Friday");
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,tv,String.class);
		Assertions.assertThat(responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED));
		Assertions.assertThat(responseEntity.getBody().equals(successful));

	}
	@Test
	public void addTestDetails(){
		RestTemplate restTemplate = new RestTemplate();
		String successful = "Successfully Added";
		String url = "http://localhost:8080/tv/addShow";
		TelevisionShow tv = new TelevisionShow();
		tv.setShowName("Rohan");
		tv.setShowTime("9 AM");
		tv.setShowDescription("Rohan-desc");
		tv.setShowDay("Friday");

		Assertions.assertThat(restTemplate.postForEntity(url,tv,String.class).equals(successful));

	}
	@Test
	public void updateTestDetails(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/tv/addShow";
		TelevisionShow tv = new TelevisionShow();
		tv.setShowName("Office");
		tv.setShowTime("9 AM");
		tv.setShowDescription("Rohan-desc");
		tv.setShowDay("Friday");
	}

}
