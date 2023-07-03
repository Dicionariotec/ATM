package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import domain.User.UserGetDataValidation;
import domain.User.UserGetInputValidation;
import domain.User.User;

public class UserTest {
    @Test
    public void userNumberEmpty() {
        Exception exception = assertThrows(Exception.class, () ->
            UserGetInputValidation.validate("")
        );
        assertEquals("Numero do usuario nao pode ser nulo", exception.getMessage());
    }

    @Test
    public void userNotExists() {
        User user = new User(-1);
        Exception exception = assertThrows(Exception.class, () ->
            UserGetDataValidation.validate(user)
        );
        assertEquals("Usuario nao encontrado", exception.getMessage());
    }
}
