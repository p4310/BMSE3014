package practical8.test;

import org.junit.jupiter.api.Test;

import practical8.AuthService;
import practical8.User;

import static org.junit.Assert.*;

public class AuthServiceTest {
    @Test
    public void testRegisterUser() {
        AuthService auth = new AuthService();
        assertTrue(auth.register(new User("alice", "1234", false))); // FR1
    }

    @Test
    public void testDuplicateRegistration() {
        AuthService auth = new AuthService();
        auth.register(new User("alice", "1234", false));
        assertFalse(auth.register(new User("alice", "0000", false))); // FR1
    }

}