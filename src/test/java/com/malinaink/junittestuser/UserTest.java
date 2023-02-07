package com.malinaink.junittestuser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Test
    @DisplayName("when a new user is created, then getter return the correct value")
    void checkGetValuesTest() {
        User user1 = new User("test", "test.test@test");
        String actual = "test" + " test.test@test";
        Assertions.assertEquals(user1.getLogin() + " " + user1.getEmail(), actual);
    }

    @Test
    @DisplayName("when empty constructor is created, then getter return null")
    void createEmptyConstructorReturnNull() {
        User user2 = new User();
        Assertions.assertNull(user2.getEmail());
        Assertions.assertNull(user2.getLogin());
    }

    @Test
    @DisplayName("when the email contains characters '@' and '.' then the email is valid")
    void checkOfCorrectEmail() {
        User user3 = new User("test", "test.test@test");
        Assertions.assertTrue(user3.getEmail().contains(".") && user3.getEmail().contains("@"));
    }

    @Test
    @DisplayName("when the email and password are equal, then authorization will not complete")
    void checkToLoginNotEqualEmail() {
        User user4 = new User("test", "test2");
        Assertions.assertNotEquals(user4.getLogin(), user4.getEmail(), "username and password not should be equal");
    }
}
