package com.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();

    //生成缩略图
    public static String generateThumbnai(File thumbnail, String targetAddr) {
        //获取随机文件名
        String randomFileName = getRandomFileName();
        //扩展名
        String extension = getFileExtension(thumbnail);
        //targetAddr有时不存在，所以要创建目录
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + randomFileName + extension;

        logger.debug("current relativeAddr is : " + relativeAddr);
        //绝对路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current completeAddr is : " + PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail)
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:\\IntelliJ IDEA 2017.3.5\\workplace\\o2o\\target\\classes\\microsoft.png")), 0.3f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
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
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf("."));
    }

    //创建目标路径所涉及到的目录
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
    }

}
