package com.jt.entity.vo.postGenerater;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class Image extends Drawable {

    @Override
    public void draw(Graphics2D gd, int posterWidth, int posterHeight) throws IOException {
        BufferedImage image;

        if (qrCode) {
            try {
                image = createQrCode(url, width, height, qrCodeMargin);
            } catch (WriterException e) {
                throw new IOException("生成二维码失败", e);
            }
        } else {
            image = ResourceUtils.getImage(url);
        }

        if (image.getWidth() != width || image.getHeight() != height) {
            image = resize(image, width, height);
        }

        if (borderRadius > 0) {
            image = ResourceUtils.setRadius(image, borderRadius * 4, 0, 0);
        }
        gd.setBackground(ColorTools.String2Color(backgroundColor));
        gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.drawImage(image, x, y, width, height, new ImageObserver() {
            @Override
            public boolean imageUpdate(java.awt.Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
    }

    private static BufferedImage resize(BufferedImage image, int width, int height) {
        java.awt.Image img = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);

        BufferedImage newBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = newBufferedImage.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawImage(img, 0, 0, null);
        graphics.dispose();

        return newBufferedImage;
    }

    private static BufferedImage resize2(BufferedImage image,int x,int y, int width, int height) {
        java.awt.Image img = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);

        BufferedImage newBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = newBufferedImage.createGraphics();
        graphics.drawImage(img, x, y,null);
        graphics.dispose();

        return newBufferedImage;
    }

    private int index = 1;
    public int getZIndex() {
        return index;
    }

    @NotNull(message = "图片X坐标不能为空")
    private Integer x;

    @NotNull(message = "图片Y坐标不能为空")
    private Integer y;

    @NotNull(message = "图片宽度不能为空")
    private Integer width;

    @NotNull(message = "图片高度不能为空")
    private Integer height;

    @Min(value = 0, message = "图片圆角不能小于0")
    private Integer borderRadius = 0;

    @NotEmpty(message = "图片url不能为空")
    private String url;

    @NotEmpty(message = "图片背景不能为空")
    private String backgroundColor = "#FFFFFF";

    private boolean qrCode = false;

    @Min(value = 0, message = "二维码边距最小为0")
    private int qrCodeMargin = 2;

    public static BufferedImage createQrCode(String content, int width, int height, int margin) throws WriterException {

        Map<EncodeHintType, Comparable> hints = new HashMap<>();

        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 字符串编码
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); // 纠错等级
        hints.put(EncodeHintType.MARGIN, margin); // 图片边距
        QRCodeWriter writer = new QRCodeWriter();

        return MatrixToImageWriter.toBufferedImage(writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints));
    }

    public static BufferedImage createQrCode(String content, int width, int height) throws WriterException {
        return createQrCode(content, width, height, 2);
    }

}
