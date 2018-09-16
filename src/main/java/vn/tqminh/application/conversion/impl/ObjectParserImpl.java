package vn.tqminh.application.conversion.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.tqminh.application.conversion.Parser;

@Component
public final class ObjectParserImpl implements Parser<String, Object>{

	@Autowired
	private ObjectMapper objectMapper;
	
	private ObjectParserImpl() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> parseObjectToMap(Object object) {
		Map<String, Object> map = objectMapper.convertValue(object, Map.class);
		return map;
	}

	@Override
	public Map<String, Object> parseStringToMap(String content) throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> map = objectMapper.readValue(content, new TypeReference<Map<String, String>>(){});
		return map;
	}

	@Override
	public <E> E parseStringToCustomType(String content, Class<E> valueType) throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(content, valueType);
	}

}
