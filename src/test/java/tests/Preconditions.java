package tests;

import entity.User;

import static tests.ITestConstants.PASSWORD;
import static tests.ITestConstants.USERNAME;

public class Preconditions extends BaseTest{

    public static User userWithEmptyUsername = User.builder()
            .password(PASSWORD)
            .username("")
            .build();

    public static User userWithEmptyPassword = User.builder()
            .password("")
            .username(USERNAME)
            .build();

    public static User userEmptyFields = User.builder()
            .password("")
            .username("")
            .build();

    public static User userWithIncorrectFields = User.builder()
            .password("efwefwe")
            .username("efwfwe")
            .build();
}
