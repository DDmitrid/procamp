package com.globallogic.procamp.lesson2;

import static com.globallogic.procamp.lesson2.LoginController.SUCCESSFUL_LOGIN_RESPONSE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    public static final String USERNAME = "foo";
    public static final String PWD = "pwd";

    @Mock
    private LoginDao loginDao;

    @Mock
    private LoginService loginService;

    @Spy
    @InjectMocks
    private LoginService spiedLoginService;
    
    @InjectMocks
    private LoginController loginController;

    @Test
    public void assertThatNoMethodHasBeenCalled() {
        loginController.login(null);
        Mockito.verifyZeroInteractions(loginService);
    }

    @Test
    public void assertTwoMethodsHaveBeenCalled() {
// 1
        User user = getUser();
        when(loginService.login(user)).thenReturn(true);
// 2
        String login = loginController.login(user);
// 3
        assertThat(login, is(SUCCESSFUL_LOGIN_RESPONSE));

        Mockito.verify(loginService).login(user);
        Mockito.verify(loginService).setCurrentUser(USERNAME);
    }

    @Test
    public void assertOnlyOneMethodHasBeenCalled() {
        User user = getUser();
        
        Mockito.when(loginService.login(user)).thenReturn(false);

        String login = loginController.login(user);

//                assertEquals("OK", login);
        assertThat(login, is(""));
        Mockito.verify(loginService).login(user);
        Mockito.verify(loginService, Mockito.never()).setCurrentUser(anyString());
        Mockito.verifyNoMoreInteractions(loginService);
    }

    @Test
    public void particularMock() {
        loginController.loginService = spiedLoginService;

        User user = new User();
        user.username = USERNAME;
        user.password = PWD;

        Mockito.when(loginDao.isValidUser(USERNAME, PWD)).thenReturn(true);

        String login = loginController.login(user);

        assertEquals(SUCCESSFUL_LOGIN_RESPONSE, login);

        Mockito.verify(spiedLoginService).setCurrentUser(USERNAME);
    }
    
    

    private User getUser() {
        User user = new User();
        user.username = USERNAME;
        return user;
    }

}