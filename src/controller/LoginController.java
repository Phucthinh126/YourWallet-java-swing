package controller;
import model.User;


public class LoginController {
    // kiem tra xac nhan dang nhap
    public boolean confirmLogin(String userNameInput, String passwordInput){
        User user = new User();
        String userName = user.getUserName();
        String password  = user.getPassword();

        return userName.equals(userNameInput) && password.equals(passwordInput) ? true : false;
    }


    
}