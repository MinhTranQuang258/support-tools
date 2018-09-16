package vn.tqminh.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.tqminh.domain.Result;

@RestController
public class TestController {

	
	private RestTemplate restTemplate= new RestTemplate();
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private String url= "http://localhost:9200/customer/_search";
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/test")
	public void test() throws JsonParseException, JsonMappingException, IOException {
		String body="{\r\n" + 
				"  \"query\": {\r\n" + 
				"    \"match\": {\r\n" + 
				"      \"name\": \"John Doe\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.set("my_other_key", "my_other_value");
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		String result= response.getBody();
		

		Result result2= objectMapper.readValue(result, Result.class);
		Object object= result2.getHits();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = objectMapper.convertValue(object, Map.class);
		List<Object> list= (List<Object>) map.get("hits");
		Object object2= list.get(0);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1 = objectMapper.convertValue(object2, Map.class);
		System.out.println(map1.get("_source"));
	}
	
}
