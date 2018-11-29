package com.globallogic.procamp.lesson10.bounded;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BoxTest {

    @Test
    public void getVolume() {
        Integer l = 1;
        Double h = 2d;
        Long w = 3L;

        Box box = new Box(l, h, w);

        assertThat(box.getVolume(), closeTo(6, 0.1));
    }
}