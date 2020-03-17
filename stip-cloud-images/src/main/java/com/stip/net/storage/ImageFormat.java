package com.stip.net.storage;

/**
 * @author wangzun
 * @version 2019/4/23 下午5:49
 * @desc 图片格式枚举
 */
public enum  ImageFormat {
    JPEG,TIFF,PNG,BMP,GIF,ICO,RAW,PSD,UNKNOW;

    public static ImageFormat getImageFormat(String suffix) {
        switch (suffix) {
            case "JPEG":
                return JPEG;
            case "TIFF":
                return TIFF;
            case "PNG":
                return PNG;
            case "BMP":
                return BMP;
            case "ICO":
                return ICO;
            case "RAW":
                return RAW;
            case "PSD":
                return PSD;
            case "UNKNOW":
                return UNKNOW;
            default :
                return JPEG;
        }
    }

    public static String getDesc(ImageFormat format) {
        switch (format) {
            case JPEG:
                return "JPEG";
            case TIFF:
                return "TIFF";
            case PNG:
                return "PNG";
            case BMP:
                return "BMP";
            case ICO:
                return "ICO";
            case RAW:
                return "RAW";
            case PSD:
                return "PSD";
            case UNKNOW:
                return "UNKNOW";
            default :
                return "JPEG";
        }
    }

    public String getDesc() {
        return ImageFormat.getDesc(this);
    }
}
