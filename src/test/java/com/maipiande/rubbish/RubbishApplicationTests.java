package com.maipiande.rubbish;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RubbishApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void articleList() {
		Map<String,String> param = new LinkedHashMap<>();
		param.put("title","111");param.put("classify","111");
		ResponseEntity<RubbishResult> response = restTemplate.postForEntity("/article/list", param, RubbishResult.class);
		RubbishResult result = response.getBody();
		Assert.assertEquals(result.getStatus(),0);
	}

}
