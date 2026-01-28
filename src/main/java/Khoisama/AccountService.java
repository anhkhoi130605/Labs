package Khoisama;

import java.util.regex.Pattern;

public class AccountService {


    public boolean isValidEmail(String email) {
        if (email == null) return false;

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }


    public boolean isValidPassword(String password) {
        if (password == null) return false;

        // > 6 ký tự
        if (password.length() <= 6) return false;

        // Có ít nhất 1 chữ hoa, 1 chữ thường, 1 ký tự đặc biệt
        String passwordRegex =
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$";

        return password.matches(passwordRegex);
    }



    public boolean isValidUsername(String username) {
        if (username == null) return false;
        return username.length() >= 3;
    }


    public boolean isValidAccount(String username, String password, String email) {
        return isValidUsername(username)
                && isValidPassword(password)
                && isValidEmail(email);
    }


    public boolean registerAccount(String username, String password, String email) {

        if (!isValidAccount(username, password, email)) {
            System.out.println("Đăng ký thất bại: Thông tin không hợp lệ");
            return false;
        }


        System.out.println("Đăng ký thành công!");
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);

        return true;
    }
}