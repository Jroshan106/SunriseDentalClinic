package Tests;

import dao.UserDAO;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserAccountTest {

    @Test
    public void testDuplicateUsernameDetection() {

        UserDAO dao = new UserDAO();

        boolean exists = dao.usernameExists("staff");

        assertTrue(
            "The system must detect an existing username.",
            exists
        );
    }
}