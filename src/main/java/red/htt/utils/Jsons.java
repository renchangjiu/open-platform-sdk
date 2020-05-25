package red.htt.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * json utils
 *
 * @author su
 */
public class Jsons {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        // 忽略未知属性
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 将对象转换成json字符串
     *
     * @param data data
     * @return json string
     */
    public static String bean2Json(Object data) {
        try {
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将json字符串转换成对象
     *
     * @param jsonData jsonData
     * @param beanType beanType
     * @return T
     */
    public static <T> T json2Bean(String jsonData, Class<T> beanType) {
        try {
            return MAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json字符串转换成对象
     *
     * @param jsonData     jsonData
     * @param valueTypeRef valueTypeRef
     * @return T
     */
    public static <T> T json2Bean(String jsonData, TypeReference<T> valueTypeRef) {
        try {
            return (T) MAPPER.readValue(jsonData, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 将json字符串转换成bean list
     *
     * @param jsonData jsonData
     * @param beanType beanType
     * @return T
     */
    public static <T> List<T> json2List(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            return MAPPER.readValue(jsonData, javaType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
