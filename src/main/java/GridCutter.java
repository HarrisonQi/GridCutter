import entity.ImgCo;
import util.ImgUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GridCutter {
    public static void main(String[] args) throws IOException {
        // sourceRegion(40, 70, 30, 50) (从左向右的坐标, 从上至下的坐标, 从左向右长度, 从上向下长度)

        URL url = new URL("https://file.yihezo.cn/yhz/app/vweb/test_square_1.png");

        GridCutter gridCutter = new GridCutter();
//       gridCutter.getGirdPics(url);
        List<BufferedImage> imgs = gridCutter.getGirdPics(3, 3, url);
        List<String> baseCodes = new ArrayList<>();
        for (BufferedImage img : imgs) {
            baseCodes.add(ImgUtils.bufferedImageToBase64(img));
        }
        System.out.println(baseCodes);
    }

    public List<BufferedImage> getGirdPics(int xColumns, int yColumns, File file) throws IOException {
        BufferedImage img = ImageIO.read(new FileInputStream(file));
        return this.getGridPics(xColumns, yColumns, img, null);
    }

    public List<BufferedImage> getGirdPics(int xColumns, int yColumns, URL url) throws IOException {
        BufferedImage img = ImgUtils.getImg(url);
        return this.getGridPics(xColumns, yColumns, img, null);
    }

    public List<BufferedImage> getGridPics(int xColumns, int yColumns, BufferedImage img, String outFolderPath) throws IOException {
        List<BufferedImage> resImgs = new ArrayList<>();

        int index = 1;
        for (int i = 1; i <= yColumns; i++) {
            ImgCo imgCo = new ImgCo();
            int height = img.getHeight();
            imgCo.setCo2(height / yColumns * i - height / yColumns);
            imgCo.setLen2(height / yColumns);

            for (int j = 1; j <= xColumns; j++) {
                int width = img.getWidth();
                imgCo.setCo1(width / xColumns * j - width / xColumns);
                imgCo.setLen1(width / xColumns);

                BufferedImage resImg = img.getSubimage(imgCo.getCo1(), imgCo.getCo2(), imgCo.getLen1(), imgCo.getLen2());


                if (outFolderPath != null) {
                    if (outFolderPath.trim().length() > 0) {
                        if (!outFolderPath.endsWith("/")) {
                            // 若路径字符串不以'/'结尾, 则补上
                            outFolderPath += "/";
                        }
                        File f = new File(outFolderPath + index + ".png");
                        ImageIO.write(resImg, "png", f);
                    }
                }
                resImgs.add(resImg);
                index++;
            }
        }
        return resImgs;
    }
}
