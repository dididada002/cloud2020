package com.jt.service.impl;

import com.jt.entity.vo.postGenerater.Image;
import com.jt.entity.vo.postGenerater.Poster;
import com.jt.entity.vo.postGenerater.Text;
import com.jt.service.IPostGenerateService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: jingteng
 * @date: 2020/9/14 21:33
 */
@Service
public class PostGenerateServiceImpl implements IPostGenerateService {
    @Override
    public void testGeneratePost() throws IOException {
        Poster poster = new Poster();
        poster.setWidth(816);
        poster.setHeight(540);
        poster.setBackgroundColor("#ffffff");


        ArrayList<Text> text = new ArrayList<>();
        //标题
        Text text1 = new Text();
        text1.setX(516);
        text1.setY(475);
        text1.setWidth(300);
        text1.setLineHeight(26);
        text1.setColor("#a4a4a4");
        text1.setText("我是一个描述字体 -- 1");
        text1.setFontSize(24);
        text1.setTextAlign("right");
        text.add(text1);

        //描述
        Text text2 = new Text();
        text2.setX(373);
        text2.setY(430);
        text2.setWidth(443);
        text2.setLineHeight(35);
        text2.setColor("#000000");
        text2.setText("我是一个描述字体 -- 2");
        text2.setFontSize(30);
        text2.setTextAlign("right");
        text.add(text2);

        //长按识别小程序码
        Text text3 = new Text();
        text3.setX(152);
        text3.setY(444);
        text3.setWidth(100);
        text3.setLineHeight(26);
        text3.setColor("#666666");
        text3.setText("长按识别");
        text3.setFontSize(24);
        text3.setTextAlign("left");
        text.add(text3);

        Text text4 = new Text();
        text4.setX(152);
        text4.setY(470);
        text4.setWidth(100);
        text4.setLineHeight(26);
        text4.setColor("#666666");
        text4.setText("小程序码");
        text4.setFontSize(24);
        text4.setTextAlign("left");
        text.add(text4);

        poster.setTexts(text);

        ArrayList<Image> imgs = new ArrayList<>();

        //普通图片
        Image image = new Image();
        image.setX(27);
        image.setY(412);
        image.setWidth(120);
        image.setHeight(120);
        image.setUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600101192338&di=1e99abe5f43f5b0c926dab2641d09a77&imgtype=0&src=http%3A%2F%2Fdik.img.kttpdq.com%2Fpic%2F160%2F111422%2F6474bdadb88aea64_1680x1050.jpg");
        imgs.add(image);

        //二维码
        Image image3 = new Image();
        image3.setIndex(2);
        image3.setX(27);
        image3.setY(412);
        image3.setWidth(120);
        image3.setHeight(120);
        image3.setUrl("www.baidu.com");
        image3.setQrCode(true);
        imgs.add(image3);

        poster.setImages(imgs);

        File draw = poster.draw();
    }
}
