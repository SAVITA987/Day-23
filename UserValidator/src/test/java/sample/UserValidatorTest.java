package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

	class UserValidatorTest {

	    @Test
	    void happyPathValidation() {
	        assertTrue(UserValidator.validateAllEntries("Savita", "Tekale", "savita@gmail.com", "91 9876543210", "Savita@123"));
	    }

	    @Test
	    void sadPathValidation() {
	        assertFalse(UserValidator.validateAllEntries("Savita", "Tekale", "invalid_email", "9876543210", "password"));
	    }

	    @Test
	    void parameterizedEmailValidation() {
	        String[] validEmails = {"savita@gmail.com", "yogesh@gmail.com"};
	        assertTrue(UserValidator.validateMultipleEmails(validEmails));

	        String[] invalidEmails = {"savita@gmail.com", "invalid_email", "yogesh@gmail.com"};
	        assertFalse(UserValidator.validateMultipleEmails(invalidEmails));
	    }

	    @Test
	    void customExceptionValidation() {
	        assertThrows(InvalidUserDetailsException.class, () -> {
	            UserValidator.validateAndThrowExceptions("Savita", "Tekale", "invalid_email", "9876543210", "password");
	        });
	    }

	    @Test
	    void lambdaFunctionValidation() {
	        assertTrue(UserValidator.validateFirstNameLambda.validate("Savita"));
	        assertFalse(UserValidator.validateLastNameLambda.validate("Tekale"));
	        assertTrue(UserValidator.validateEmailLambda.validate("savita@gmail.com"));
	        assertFalse(UserValidator.validateMobileLambda.validate("9876543210"));
	        assertTrue(UserValidator.validatePasswordLambda.validate("Savita@123"));
	    }
	}

