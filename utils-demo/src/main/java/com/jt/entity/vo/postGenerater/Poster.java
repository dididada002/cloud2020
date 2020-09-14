package com.jt.entity.vo.postGenerater;

import lombok.Data;
import org.springframework.util.DigestUtils;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jingteng
 * @date: 2019/7/11 16:42
 */
@Data
public class Poster {

    @NotNull(message = "画布宽度不能为空")
    private Integer width;

    @NotNull(message = "画布高度不能为空")
    private Integer height;

    private String backgroundColor = null;

    private String format = "png";

    private ArrayList<Text> texts;

    private ArrayList<Image> images;

    private ArrayList<Block> blocks;

    private ArrayList<Line> lines;


    private void push2map(Map<Integer, ArrayList<Drawable>> indexMap, Drawable drawable) {
        ArrayList<Drawable> drawables = indexMap.get(drawable.getZIndex());
        drawables = drawables == null ? new ArrayList<>() : drawables;
        drawables.add(drawable);
        indexMap.put(drawable.getZIndex(), drawables);
    }

    public File draw() throws IOException {
        // 初始化图片
        BufferedImage image = new BufferedImage(width, height, format.equals("png") ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_3BYTE_BGR);

        // create graphics
        Graphics2D gd = image.createGraphics();

        image = gd.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        gd.dispose();
        gd = image.createGraphics();

        // 初始化画布层级 map
        Map<Integer, ArrayList<Drawable>> indexMap = new HashMap<>();
        ArrayList<Drawable> drawables;

        // 如果有背景，画个矩形做背景
        if (backgroundColor != null) {
            gd.setColor(ColorTools.String2Color(backgroundColor));
            gd.fillRect(0, 0, width, height);
        }

        if (this.blocks != null) {
            // 遍历 blocks
            for (Block block : this.blocks) {
                push2map(indexMap, block);
            }
        }

        if (this.lines != null) {
            // 遍历 lines
            for (Line line : this.lines) {
                push2map(indexMap, line);
            }
        }

        if (this.images != null) {
            // 遍历 images
            for (Image img : this.images) {
                push2map(indexMap, img);
            }
        }

        if (this.texts != null) {
            // 遍历 texts
            for (Text text : this.texts) {
                push2map(indexMap, text);
            }
        }

        // 按 index 顺序执行绘画过程
        for (Integer index : indexMap.keySet()) {
            drawables = indexMap.get(index);
            if (drawables != null) {
                for (Drawable drawable : drawables) {
                    drawable.draw(gd, width, height);
                }
            }
        }

        gd.dispose();

        // 创建临时文件
        File file = File.createTempFile(this.key(), "." + format);
        ImageIO.write(image, format, file); // 把文件写入图片
//        file.deleteOnExit(); // 使用完后删除文件

        return file;
    }

    public String key() {
        return DigestUtils.md5DigestAsHex(this.toString().getBytes());
    }
}
