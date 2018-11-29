package com.globallogic.procamp.lesson10.wildcards;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CanvasTest {

    Canvas canvas = new Canvas();

    @Test
    public void testDraw() {
        canvas.draw(new Rectangle());
        canvas.draw(new Circle());
    }

    @Test
    public void testDrawAll() {
        List<Shape> list = new ArrayList<>();

        list.add(new Rectangle());
        list.add(new Circle());

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
                        
//        canvas.drawAll(rectangles);
        // public void drawAll(List< ? extended Shape> shapes) {
    }
}