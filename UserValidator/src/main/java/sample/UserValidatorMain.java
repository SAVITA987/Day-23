package sample;

import java.util.Scanner;
public class UserValidatorMain {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter First Name: ");
	        String firstName = scanner.nextLine();

	        System.out.print("Enter Last Name: ");
	        String lastName = scanner.nextLine();

	        System.out.print("Enter Email: ");
	        String email = scanner.nextLine();

	        System.out.print("Enter Mobile: ");
	        String mobile = scanner.nextLine();

	        System.out.print("Enter Password: ");
	        String password = scanner.nextLine();

	        try {
	            UserValidator.validateAndThrowExceptions(firstName, lastName, email, mobile, password);
	            System.out.println("All entries are valid!");
	        } catch (InvalidUserDetailsException e) {
	            System.out.println("Invalid Entry: " + e.getMessage());
	        }
	    }
	}

