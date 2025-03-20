package tests;

import entity.User;

import static tests.ITestConstants.PASSWORD;


public class Preconditions extends BaseTest{

    protected static final User userWithEmptyUsername = User.builder()
            .password(PASSWORD)
            .username("")
            .build();

    protected static final User userWithEmptyPassword = User.builder()
            .password("")
            .username(System.getProperty("username"))
            .build();

    protected static final User userEmptyFields = User.builder()
            .password("")
            .username("")
            .build();

    protected static final User userWithIncorrectFields = User.builder()
            .password("efwefwe")
            .username("efwfwe")
            .build();

    protected static final User userSuccessLogin = User.builder()
            .password(PASSWORD)
            .username(System.getenv("username"))
            .build();
}
