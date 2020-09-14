package com.jt.entity.vo.postGenerater;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import sun.font.FontDesignMetrics;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Data
public class Text extends Drawable {

    @Override
    public void draw(Graphics2D gd, int posterWidth, int posterHeight) {
        Font drawFont;

        try {
            drawFont = Font.createFont(Font.TRUETYPE_FONT, ResourceUtils.getFontFile(font)).deriveFont((float) fontSize);
        } catch (Exception e) {
            drawFont = new Font("Default", Font.PLAIN, fontSize);
        }
        // 设置字体和颜色
        gd.setFont(drawFont);
        gd.setColor(ColorTools.String2Color(color));
        //消除文字锯齿
        gd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //消除图片锯齿
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 文本域实际宽度
        int textWidth = width + x > posterWidth ? posterWidth - x : (width == 0 ? posterWidth : width);
        // 当前行数
        int currentNum = 0;
        // 当前行应该取到第几个文字
        int lineTextindex;

        // 剩余没有画的图片
        String surplus = text;
        // 当前行文本
        String lineText;
        // 是否最后一行
        boolean lastLine;
        // 是否需要省略号
        boolean ellipsis = textOverflow.equals("ellipsis");

        // x 轴偏移量
        int offsetX = 0;

        // 当前行文本宽度
        int lineTextWidth;
        lineHeight = lineHeight <= 0 ? fontSize : lineHeight;

        // 一行一行画
        while (surplus.length() > 0 && currentNum < lineNum) {
            lineTextWidth = getWordWidth(drawFont, surplus);
            lastLine = currentNum + 1 == lineNum;
            // 放不下的时候,就要对文本进行裁剪了
            if (lineTextWidth > textWidth) {
                lineTextindex = interceptALine(surplus, drawFont, textWidth, lastLine, ellipsis);
                lineText = surplus.substring(0, lineTextindex); // 截取当前行文本
                surplus = surplus.substring(lineTextindex); // 记录剩余文本
                lineTextWidth = getWordWidth(drawFont, lineText); // 重新计算宽度
            } else {
                lineText = surplus;
                surplus = ""; // 画完了
            }

            if (textAlign.equals("center")) {
                offsetX = (textWidth - lineTextWidth) / 2;
            }

            if (lastLine && ellipsis && surplus.length() > 0) {
                lineText = lineText + "...";
            }

            gd.drawString(lineText, x + offsetX, y + fontSize + (lineHeight - fontSize) / 2 + currentNum * lineHeight);
            currentNum++;
        }
    }

    private int interceptALine(String surplus, Font drawFont, int textWidth, boolean lastLine, boolean ellipsis) {
        int fullTextWidth = getWordWidth(drawFont, surplus);
        // 如果是最后一行且溢出且需要省略号，则预留省略号宽度
        textWidth = fullTextWidth > textWidth && lastLine && ellipsis ? textWidth - getWordWidth(drawFont, "...") : textWidth;

        // 默认值,后面试用循环不断调整为最佳值
        int lineIndex = surplus.length() - (fullTextWidth - textWidth) / fontSize;

        String lineText = surplus.substring(0, lineIndex);
        int lineTextWidth = getWordWidth(drawFont, lineText);

        // 循环到文本宽度小于文本域宽度为止
        while (lineTextWidth > textWidth) {
            lineIndex--;
            lineText = surplus.substring(0, lineIndex);
            lineTextWidth = getWordWidth(drawFont, lineText);
        }

        return lineIndex;
    }

    private static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;
    }

    private int index = 1;
    public int getZIndex() {
        return index;
    }

    @NotNull(message = "文本X坐标不能为空")
    private int x = 0;//  x 坐标
    @NotNull(message = "文本Y坐标不能为空")
    private int y = 0; // y 坐标
    @Min(value = 8, message = "文本字体大小不能小于8")
    private Integer fontSize = 24; // 字体大小
    @Min(value = 0, message = "文本区域宽度不能小于0")
    private Integer width = 0; // 文本域宽度
    @Min(value = 0, message = "文本行高不能小于0")
    private Integer lineHeight = 0; // 行高

    @Min(value = 1, message = "文本行数不能小于1")
    private Integer lineNum = 1; // 行数

    @NotNull(message = "文本字体颜色不能为null")
    private String color = "#000000"; // 颜色

    @NotEmpty(message = "文本内容不能为空")
    private String text; // 文本内容

    @Min(value = 0, message = "文本透明度不能小于0")
    @Max(value = 1, message = "文本透明度能大于1")
    private Integer opacity = 1; // 透明度

    private String textAlign = "left"; // 文本对齐方式
    private String font = "pfr"; // 字体
    private String textOverflow = "ellipsis"; // 文本溢出默认省略号

}
