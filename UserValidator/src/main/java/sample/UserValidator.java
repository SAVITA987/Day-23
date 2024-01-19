package sample;

import java.util.regex.*;

	public class UserValidator {
	    public static boolean validateFirstName(String firstName) {
	        return firstName.matches("[A-Z][a-zA-Z]{2,}");
	    }
	    public static boolean validateLastName(String lastName) {
	        return lastName.matches("[A-Z][a-zA-Z]{2,}");
	    }

	    public static boolean validateEmail(String email) {
	        return email.matches("[a-zA-Z]+\\.[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?");
	    }

	    public static boolean validateMobile(String mobile) {
	        return mobile.matches("\\d{2} \\d{10}");
	    }

	    public static boolean validatePassword(String password) {
	        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");
	    }

	    public static boolean validateAllEntries(String firstName, String lastName, String email, String mobile, String password) {
	        return validateFirstName(firstName) &&
	                validateLastName(lastName) &&
	                validateEmail(email) &&
	                validateMobile(mobile) &&
	                validatePassword(password);
	    }

	    public static boolean validateMultipleEmails(String[] emails) {
	        for (String email : emails) {
	            if (!validateEmail(email)) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public static void validateAndThrowExceptions(String firstName, String lastName, String email, String mobile, String password) throws InvalidUserDetailsException {
	        if (!validateFirstName(firstName)) {
	            throw new InvalidUserDetailsException("Invalid First Name");
	        }
	        if (!validateLastName(lastName)) {
	            throw new InvalidUserDetailsException("Invalid Last Name");
	        }
	        if (!validateEmail(email)) {
	            throw new InvalidUserDetailsException("Invalid Email");
	        }
	        if (!validateMobile(mobile)) {
	            throw new InvalidUserDetailsException("Invalid Mobile");
	        }
	        if (!validatePassword(password)) {
	            throw new InvalidUserDetailsException("Invalid Password");
	        }
	    }

	    public static ValidatorFunction validateFirstNameLambda = (String firstName) -> firstName.matches("[A-Z][a-zA-Z]{2,}");
	    public static ValidatorFunction validateLastNameLambda = (String lastName) -> lastName.matches("[A-Z][a-zA-Z]{2,}");
	    public static ValidatorFunction validateEmailLambda = (String email) -> email.matches("[a-zA-Z]+\\.[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+(\\.[a-zA-Z]+)?");
	    public static ValidatorFunction validateMobileLambda = (String mobile) -> mobile.matches("\\d{2} \\d{10}");
	    public static ValidatorFunction validatePasswordLambda = (String password) -> password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}");

	    interface ValidatorFunction {
	        boolean validate(String input);
	    }
	}

	class InvalidUserDetailsException extends Exception {
	    public InvalidUserDetailsException(String message) {
	        super(message);
	    }
	}

