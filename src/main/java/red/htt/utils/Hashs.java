package red.htt.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author su
 */
public class Hashs {

    /**
     * 获取字符的 md5 值
     *
     * @param source source
     * @return res
     */
    public static String md5(String source) {
        try {
            // 获得实现指定摘要算法的 MessageDigest 对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 获得存放哈希值结果的 byte 数组
            byte[] bytes = md.digest(source.getBytes());
            // 转成16进制字符串
            return BinUtils.binToHex(bytes);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取字符的 md5 值
     *
     * @param source source
     * @param salt   salt
     * @param repeat 散列次数
     * @return res
     */
    public static String md5(String source, String salt, int repeat) {
        String ret = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            for (int i = 0; i < repeat; i++) {
                if ("".equals(ret)) {
                    byte[] bytes = md.digest((source + salt).getBytes());
                    ret = BinUtils.binToHex(bytes);
                } else {
                    byte[] bytes = md.digest(ret.getBytes());
                    ret = BinUtils.binToHex(bytes);
                }
            }
            return ret;
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 计算字符串的 SHA1
     *
     * @param str 需要进行散列计算(SHA)的字符
     * @return 散列计算的结果
     */
    public static String sha(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] bytes = md.digest(str.getBytes());
            return BinUtils.binToHex(bytes);
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 获取文件的 md5 值
     *
     * @param file File
     */
    public static String md5(File file) {
        FileInputStream fis = null;
        String result = "";
        try {
            fis = new FileInputStream(file);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] bytes = md.digest();
            result = BinUtils.binToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
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
            result = BinUtils.binToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
