package com.jt.entity.vo.postGenerater;

import java.awt.*;
import java.io.IOException;

public interface DrawableInterface {
    void draw(Graphics2D gd, int posterWidth, int posterHeight) throws IOException;

    int getZIndex();
}
