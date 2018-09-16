package vn.tqminh.application.conversion;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface Parser<K, V> {

	Map<K, V> parseObjectToMap(Object object);
	
	Map<K, V> parseStringToMap(String string) throws JsonParseException, JsonMappingException, IOException;
	
	<E> E parseStringToCustomType(String content, Class<E> valueType) throws JsonParseException, JsonMappingException, IOException;
}
