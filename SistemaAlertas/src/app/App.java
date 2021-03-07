package app;

import domain.EnumNotifications;
import domain.UserModel;

public class App {
    public static void main(String[] args) {
        UserModel u1 = new UserModel("Bruno", 1, EnumNotifications.email);
        System.out.println(u1);
    }
}
