package vip.fairy.xml.ch.ch11.JacksonDemo.v15;

import static java.lang.System.out;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JacksonDemo {

  public static void main(String[] args) throws Exception {
    String jsonContent =
        "{" +
            "   \"id\": 820787," +
            "   \"firstName\": \"Pierre\"," +
            "   \"lastName\": \"Francois\"" +
            "}";
    ObjectMapper mapper = new ObjectMapper();
    PropContainer pc =
        mapper.readValue(jsonContent, PropContainer.class);
    Iterator<Map.Entry<String, Object>> iter =
        pc.iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Object> entry = iter.next();
      out.printf("Key: %s, Value: %s%n", entry.getKey(),
          entry.getValue());
    }
    mapper.writeValue(new File("pierre.json"), pc);
  }
}

class PropContainer {

  public String lastName;

  private Map<String, Object> properties;

  PropContainer() {
    properties = new HashMap<>();
  }

  @JsonAnySetter
  void addProperty(String fieldName, Object value) {
    properties.put(fieldName, value);
  }

  Iterator<Map.Entry<String, Object>> iterator() {
    return properties.entrySet().iterator();
  }

  @JsonAnyGetter
  public Map<String, Object> properties() {
    return properties;
  }
}
