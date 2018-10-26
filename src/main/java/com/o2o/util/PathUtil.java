package com.o2o.util;

/**
 * Create By wz on 2018/10/25
 */
public class PathUtil {

    //获取操作系统的文件分隔符
    public static String seperator = System.getProperty("file.seperator");

    public static String getImgBasePath() {
        String osName = System.getProperty("os.name");
        String basepath = "";
        if (osName.toLowerCase().startsWith("win")) {
            basepath = "D:/project/image/";
        } else {
            basepath = "/home/user/image/";
        }
        basepath = basepath.replace("/", seperator);
        return basepath;
    }

    //子路径
    public static String getShopImgPath(Long shopId) {
        String imagePath = "/upload/shop" + shopId + "/";
        return imagePath.replace("/", seperator);
    }


}
