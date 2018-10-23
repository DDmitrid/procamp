package com.globallogic.procamp.lesson2;

public class LoginController {

    public static final String ERROR_RESPONSE = "ERROR";
    public static final String SUCCESSFUL_LOGIN_RESPONSE = "OK";
    public LoginService loginService;

    public String login(User userForm){
        
        if(null == userForm){
            return ERROR_RESPONSE;
        }else{
            boolean logged;

            try {
                logged = loginService.login(userForm);
            } catch (Exception e) {
                return ERROR_RESPONSE;
            }

            if(logged){
                loginService.setCurrentUser(userForm.getUsername());
                return SUCCESSFUL_LOGIN_RESPONSE;
            }

            return "";
        }
    }
}
