package com.globallogic.procamp.lesson2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.hamcrest.MockitoHamcrest;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

//sudo docker run -d -p 9000:9000 -p 9092:9092 sonarqube
//mvn sonar:c

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    public static final String SECOND = "second";
    @Mock
    List mock;
    
    
//    @Spy
//    List<String> spy;
    

//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testMock() {

//        List<String> spy = spy(new ArrayList<>());
//        
//        spy.add(SECOND);
//        System.out.println(spy.get(0));

        doAnswer(i -> {


            return null;
        })
                        .when(mock).clear();
        
        
        
//        mock.add(SECOND);
//        mock.clear();
//
//        InOrder inOrder = inOrder(mock);
//
//        inOrder.verify(mock).add(anyString());
//        inOrder.verify(mock).clear();

//        verify(mock).clear();
//        verify(mock).add(anyString());
//        when(mock.get(anyInt())).thenReturn("first", "secondW");

//        System.out.println(mock.get(0));
//        verify(mock, atLeast(2)).add(SECOND);
//        verify(mock, times(2)).add(SECOND);
//        verify(mock, atMost(2)).add(SECOND);
//        verify(mock, atLeastOnce()).add(SECOND);
//        verify(mock, never()).add(SECOND);
        
                
    }
//    public void testArgumentCaptor() {
//        mockList.add("test");
//
//        verify(mockList).add(listCaptor.capture());
//
//        assertThat("", listCaptor.getValue(), isA(String.class));
//    }
}
