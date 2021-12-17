package neo.vn.test365children.Listener;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 8/14/2018
 * @updated 8/14/2018
 * @modified by
 * @updated on 8/14/2018
 * @since 1.0
 */
public class ParserJson {
  public static <T> List<T> toList(String json, Class<T> clazz) {
    if (null == json) {
      return null;
    }
    Gson gson = new Gson();
    return gson.fromJson(json, new TypeToken<T>(){}.getType());
  }
}