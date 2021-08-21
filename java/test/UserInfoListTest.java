package test;

import user.UserInfoList;

import java.io.IOException;

public class UserInfoListTest {
    public static void main(String[] args) throws IOException {
        UserInfoList userData = new UserInfoList();
        System.out.println(userData.getData().toString());
        System.out.println(userData.wrapper());
    }
}
