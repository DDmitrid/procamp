package com.globallogic.procamp.lesson2;

public class LoginService {
    private LoginDao loginDao;
    private String currentUser;

    public boolean login(User userForm) {
        boolean validUser = loginDao.isValidUser(userForm.getUsername(), userForm.getPassword());

        return validUser;
    }

    public void setCurrentUser(String username) {
        if(null != username){
            this.currentUser = username;
        }
    }
}
