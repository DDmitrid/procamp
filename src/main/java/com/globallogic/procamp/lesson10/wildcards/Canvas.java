package com.globallogic.procamp.lesson10.wildcards;

import java.util.List;

public class Canvas {
    public void draw(Shape s) {
        s.draw(this);
    }

    public void drawAll(List<Shape> shapes) {
        for (Shape s: shapes) {
            s.draw(this);
        }
    }
}
