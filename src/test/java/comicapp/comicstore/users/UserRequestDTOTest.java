package comicapp.comicstore.users;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidRequestDTO() {
        UserRequestDTO requestDTO = new UserRequestDTO("John", "Doe", "johndoe");
        assertTrue(validator.validate(requestDTO).isEmpty());
    }

    @Test
    void testInvalidRequestDTO() {
        UserRequestDTO requestDTO = new UserRequestDTO("", "", ""); // Invalid fields
        assertFalse(validator.validate(requestDTO).isEmpty());
    }
}