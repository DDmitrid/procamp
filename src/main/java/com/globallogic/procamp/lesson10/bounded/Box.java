package com.globallogic.procamp.lesson10.bounded;

/*
    see test 
 */
public class Box<T extends Number> {
    
    private T length;
    private T height;
    private T width;

    Box(T length, T height, T width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    double getVolume () {
        return length.doubleValue() 
                        * height.doubleValue() 
                        * width.doubleValue();
    }
}