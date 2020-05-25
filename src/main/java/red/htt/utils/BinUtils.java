package red.htt.utils;


import java.math.BigInteger;

/**
 * 进制转换工具类
 *
 * @author su
 */
public class BinUtils {

    private BinUtils() {
    }

    /**
     * 二进制转16进制字符串
     *
     * @param src 字节数组
     * @return 16进制字符串
     */
    public static String binToHex(byte[] src) {
        if (src == null || src.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : src) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                sb.append(0);
            }
            sb.append(hv);
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 二进制转十进制
     *
     * @param binarySource 二进制数据的字符串形式, 如: "101"
     * @return int 十进制数据, 如: 5
     */
    public static int binToDecimal(String binarySource) {
        return new BigInteger(binarySource, 2).intValue();
    }

    /**
     * 十进制转二进制
     *
     * @param decimalSource 十进制数据, 如: 5
     * @return String 二进制数据的字符串形式, 如: "101"
     */
    public static String decimalToBin(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        return bi.toString(2);
    }

}
