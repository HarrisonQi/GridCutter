# 轻松切图

简介: 轻松把网络图片/本地图片均匀比例分割

适用场景: 朋友圈发布九张图片、均匀分割一张图片等

> 注意: 当为四格切图、九格切图时, 传入图片宽高比最好为1:1, 六格切图最好为3:2

九格切图轻松搞定:

```java
    public class Test {
        public static void main(String[] args) throws IOException {
            URL url = new URL("https://file.yihezo.cn/yhz/app/vweb/test_square_1.png");//获取网络图片
            GridCutter gridCutter = new GridCutter();
            List<BufferedImage> imgs = gridCutter.getGirdPics(3, 3, url);
            
            // List<BufferedImage> imgs2 = gridCutter.getGirdPics(3, 3, new File("C:/a.png")); //获取本地图片
        }
    }
```

- 四格切图: gridCutter.getGirdPics(2, 2, url);

- 六格切图: gridCutter.getGirdPics(3, 2, url);

- 九格切图: gridCutter.getGirdPics(3, 3, url);

... 以此类推


