package red.htt.utils;


import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author su
 */
public class Hashs {

    /**
     * 获取字符的 md5 值
     *
     * @param source 原文
     * @return res
     */
    public static String md5(String source) {
        // 获得实现指定摘要算法的 MessageDigest 对象
        MessageDigest md = getMessageDigest("MD5");
        // 获得存放哈希值结果的 byte 数组
        byte[] bytes = md.digest(source.getBytes());
        // 转成16进制字符串
        return Bins.binToHex(bytes);
    }

    private static MessageDigest getMessageDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取字符的 md5 值
     *
     * @param source 原文
     * @param salt   salt
     * @param repeat 散列次数
     * @return res
     */
    public static String md5(String source, String salt, int repeat) {
        String ret = "";
        MessageDigest md = getMessageDigest("MD5");
        for (int i = 0; i < repeat; i++) {
            if ("".equals(ret)) {
                byte[] bytes = md.digest((source + salt).getBytes());
                ret = Bins.binToHex(bytes);
            } else {
                byte[] bytes = md.digest(ret.getBytes());
                ret = Bins.binToHex(bytes);
            }
        }
        return ret;
    }


    /**
     * 计算字符串的 SHA1
     *
     * @param source 原文
     * @return 散列计算的结果
     */
    public static String sha1(String source) {
        MessageDigest md = getMessageDigest("SHA1");
        byte[] bytes = md.digest(source.getBytes());
        return Bins.binToHex(bytes);
    }

    /**
     * 计算字符串的 SHA256
     *
     * @param source 原文
     * @return 散列计算的结果
     */
    public static String sha256(String source) {
        MessageDigest md = getMessageDigest("SHA-256");
        byte[] bytes = md.digest(source.getBytes());
        return Bins.binToHex(bytes);
    }

    public static String hmacSha1(String source, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), mac.getAlgorithm());
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(source.getBytes(StandardCharsets.UTF_8));
            return Bins.binToHex(bytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String hmacSha256(String source, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), mac.getAlgorithm());
            mac.init(secretKey);
            byte[] bytes = mac.doFinal(source.getBytes(StandardCharsets.UTF_8));
            return Bins.binToHex(bytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static byte[] hmacSha256(String source, byte[] key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKey secretKey = new SecretKeySpec(key, mac.getAlgorithm());
            mac.init(secretKey);
            return mac.doFinal(source.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    /**
     * 使用nio获取文件的 md5 值
     *
     * @param file File
     */
    public static String md5WithNio(File file) throws IOException {
        if (!file.isFile()) {
            return "";
        }
        String result = "";
        FileChannel channel = new FileInputStream(file).getChannel();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                md.update(buffer);
                buffer.clear();
            }
            channel.close();
            byte[] bytes = md.digest();
            result = Bins.binToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String source = "hello";
        String r1 = sha1(source);
        String r2 = sha256(source);
        System.out.println();
    }
}

