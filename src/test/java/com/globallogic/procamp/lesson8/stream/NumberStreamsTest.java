package com.globallogic.procamp.lesson8.stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberStreamsTest {

    NumberStreams numberStreams = new NumberStreams();
    
    @Test
    public void testCount() {
        
        assertThat(numberStreams.count(), is(1L));
    }

    @Test
    public void testFindAny() {
    }
}