package com.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Create By wz on 2018/10/26
 */
public class ImageUtil {

    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();

    //生成缩略图
    public static String generateThumbnai(CommonsMultipartFile thumbnail, String targetAddr) {
        //获取随机文件名
        String randomFileName = getRandomFileName();
        //扩展名
        String extension = getFileExtension(thumbnail);
        //targetAddr有时不存在，所以要创建目录
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + randomFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream())
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:\\project\\microsoft.png")), 0.3f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    //生成随机文件名，当前年、月、日、小时、分、秒加上五位随机数
    private static String getRandomFileName() {
        int randomNum = random.nextInt(90000) + 10000;
        String currentTime = sdf.format(new Date());
        return currentTime + randomNum;
    }

    //获取输入文件流的扩展名
    private static String getFileExtension(CommonsMultipartFile file) {
        String originFileName = file.getOriginalFilename();
        return originFileName.substring(originFileName.lastIndexOf("."));
    }

    //创建目标路径所涉及到的目录
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("D:\\project\\image\\back.jpg"))
                .size(800, 300)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:\\IntelliJ IDEA 2017.3.5\\workplace\\o2o\\src\\main\\resources\\microsoft.png")), 0.3f)
                .outputQuality(0.8f)
                .toFile("D:\\project\\image\\new1.jpg");


    }
}
