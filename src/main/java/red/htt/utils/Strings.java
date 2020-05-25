package red.htt.utils;


import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

/**
 * @author yui
 */
public final class Strings extends StringUtils {

    public static void ifEmpty(String source, Consumer<String> consumer) {
        if (isEmpty(source)) {
            consumer.accept(source);
        }
    }

    public static void ifNotEmpty(String source, Consumer<String> consumer) {
        if (isNotEmpty(source)) {
            consumer.accept(source);
        }
    }

    public static void ifContains(String source, String sub, Consumer<Integer> consumer) {
        if (isNotEmpty(source)) {
            int idx = source.indexOf(sub);
            if (idx != -1) {
                consumer.accept(idx);
            }
        }
    }


    public static String htmlSpecialCharsEncode(String str) {
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        return str;
    }

    /**
     * <p>单词首字母转大写</p>
     *
     * <pre>
     * StringUtil.firstLetterToUppercase(null)      = null
     * StringUtil.firstLetterToUppercase("")        = ""
     * StringUtil.firstLetterToUppercase(" ")       = " "
     * StringUtil.firstLetterToUppercase("bob")     = "Bob"
     * StringUtil.firstLetterToUppercase("1 bob  ") = "1  bob  "
     * </pre>
     */
    public static String firstLetterToUpper(String str) {
        return (str != null && str.length() >= 1) ? Character.toUpperCase(str.charAt(0)) + str.substring(1) : str;

    }

    public static String urlEncode(String string) {
        try {
            return isEmpty(string) ? "" : URLEncoder.encode(string, StandardCharsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String urlDecode(String string) {
        try {
            return isEmpty(string) ? "" : URLDecoder.decode(string, StandardCharsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }


}
