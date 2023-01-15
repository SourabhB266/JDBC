package user_assignment;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		UserCRUD crud = new UserCRUD();
		boolean exit = true;
		do {
			System.out.println("Choose Your Option \n 1.SignUp \n 2.LogIn \n 3.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter a Id");
				int id = scanner.nextInt();
				System.out.println("Enter a Username");
				String name = scanner.next();
				System.out.println("Enter a Email");
				String email = scanner.next();
				System.out.println("Enetr a Password");
				String password = scanner.next();
				System.out.println("Enter a Address");
				String address = scanner.next();
				user.setId(id);
				user.setUsername(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);
				try {
					crud.signUp(user);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
				break;

			case 2: {
				System.out.println("Enter a Username");
				String name = scanner.next();
				System.out.println("Enter a Password");
				String password = scanner.next();
				user.setUsername(name);
				user.setPassword(password);
				try {
					boolean result = crud.logIn(user);
					if (result == true) {
						System.out.println("Logged In Successfully");
						System.out.println();
						System.out.println(
								"Choose Your Option \n 1.To Create Password for Social Media Accounts \n 2.Display Passwords \n 3.To Change Your Social Media Accounts Password");
						int choice1 = scanner.nextInt();
						switch (choice1) {
						case 1: {
							System.out.println("Enter Your Facebook Password");
							String face_pass = scanner.next();
							System.out.println("Enter Your Instagram Password");
							String insta_pass = scanner.next();
							System.out.println("Enter Your Twitter Password");
							String twitter_pass = scanner.next();
							System.out.println("Enter Your Whatsapp Password");
							String whatsapp_pass = scanner.next();
							System.out.println("Enter Your SnapChat Password");
							String snapchat_pass = scanner.next();
							user.setFacebook_pass(face_pass);
							user.setInsta_pass(insta_pass);
							user.setTwitter_pass(twitter_pass);
							user.setWhatsapp_pass(whatsapp_pass);
							user.setSnapchat_pass(snapchat_pass);
							crud.createPassword(user);
						}
							break;
						case 2:{
							System.out.println("Enter Id");
							int id = scanner.nextInt();
							user.setId(id);
							crud.displayPassword(user);
						}
						case 3: {
							crud.updatePassword(user);

						}
							break;
												
						default:
							System.out.println("Invalid Choice");
						}

					} else
						System.out.println("Invalid Credential");
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
				break;

			default:
				System.out.println("Thank You...!!!");
			}
		} while (exit);
	}

}
