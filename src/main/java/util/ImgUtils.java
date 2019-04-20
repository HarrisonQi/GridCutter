package util;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ImgUtils {

    /**
     * 通过URL获取图片
     *
     * @param url 图片URL
     * @return BufferedImage 图片类型
     * @throws IOException 图片连接异常
     */
    public static BufferedImage getImg(URL url) throws IOException {
        URLConnection connection = url.openConnection(); //打开连接
        connection.setDoOutput(true);
        connection.setReadTimeout(3000);
        return ImageIO.read(connection.getInputStream()); //读取连接的流，赋值给BufferedImage对象
    }

    public static String bufferedImageToBase64(BufferedImage img) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        ImageIO.write(img, "png", baos);//写入流中
        byte[] bytes = baos.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encodeBuffer(bytes).trim();
    }

}
