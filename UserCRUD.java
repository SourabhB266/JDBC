package user_assignment;

import java.util.Scanner;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class UserCRUD {
	public Connection getConnection() throws Exception {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileInputStream = new FileInputStream("jdbc_config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		return connection;

	}

	public void signUp(User user) throws Exception {
		Connection connection = getConnection();
		String query = "insert into user1 (id,username,email,password,address) values(?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getUsername());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());
		preparedStatement.execute();
		connection.close();
		System.out.println("Successfull");
		System.out.println();
	}

	public boolean logIn(User user) throws Exception {
		Connection connection = getConnection();
		String query = "select * from user1 where username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUsername());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");

		}
		if (password.equals(user.getPassword())) {
			return true;
		}
		return false;

	}

	public void createPassword(User user) throws Exception {
		Connection connection = getConnection();
		String query = "update user1 set facebook_pass =?,insta_pass=?,twitter_pass=?,whatsapp_pass=?,snapchat_pass=? where id = ?" ;
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getFacebook_pass());
		preparedStatement.setString(2, user.getInsta_pass());
		preparedStatement.setString(3, user.getTwitter_pass());
		preparedStatement.setString(4, user.getWhatsapp_pass());
		preparedStatement.setString(5, user.getSnapchat_pass());
		preparedStatement.setInt(6,user.getId());
		preparedStatement.execute();
		connection.close();
		System.out.println("Password Created Successfully");
		System.out.println();
		
	}

	public void updatePassword(User user) throws Exception {
		Connection connection = getConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Enter \n 1.Update Facebook Passswod \n 2.Update Insta Password \n 3.Update Twitter Password \n 4.Update Whatsapp Password \n 5.Update SnapChat Password ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Confirm Your Facebook Password");
			String f_pass = scanner.next();
			String query = "select * from user1 where username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			String password = null;
			while (resultSet.next()) {
				password = resultSet.getString("facebook_pass");

			}
			if (f_pass.equals(password)) {
				System.out.println("Enter id to Update Passwod");
				int id = scanner.nextInt();
				System.out.println("Enter New Password");
				String f1_pass = scanner.next();
				user.setFacebook_pass(f1_pass);
				user.setId(id);
				String query1 = "update user1 set facebook_pass = ? where id = ?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
				preparedStatement1.setString(1, user.getFacebook_pass());
				preparedStatement1.setInt(2, user.getId());
				preparedStatement1.execute();
				connection.close();
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Incorrect Password");
			}

		}
			break;

		case 2: {
			System.out.println("Confirm Your Insta Password");
			String in_pass = scanner.next();
			String query = "select * from user1 where username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			String password = null;
			while (resultSet.next()) {
				password = resultSet.getString("insta_pass");

			}
			if (in_pass.equals(password)) {
				System.out.println("Enter id to Update Passwod");
				int id = scanner.nextInt();
				System.out.println("Enter New Password");
				String insta_pass = scanner.next();
				user.setInsta_pass(insta_pass);
				user.setId(id);
				String query1 = "update user1 set insta_pass = ? where id = ?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
				preparedStatement1.setString(1, user.getInsta_pass());
				preparedStatement1.setInt(2, user.getId());
				preparedStatement1.execute();
				connection.close();
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Incorrect Password");
			}
		}
			break;
		case 3: {
			System.out.println("Confirm Your Twitter Password");
			String t_pass = scanner.next();
			String query = "select * from user1 where username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			String password = null;
			while (resultSet.next()) {
				password = resultSet.getString("twitter_pass");

			}
			if (t_pass.equals(password)) {
				System.out.println("Enter id to Update Passwod");
				int id = scanner.nextInt();
				System.out.println("Enter New Password");
				String tw_pass = scanner.next();
				user.setTwitter_pass(tw_pass);
				user.setId(id);
				String query1 = "update user1 set twitter_pass = ? where id = ?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
				preparedStatement1.setString(1, user.getTwitter_pass());
				preparedStatement1.setInt(2, user.getId());
				preparedStatement1.execute();
				connection.close();
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Incorrect Password");
			}
		}
			break;
		case 4: {
			System.out.println("Confirm Your Whatsapp Password");
			String w_pass = scanner.next();
			String query = "select * from user1 where username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			String password = null;
			while (resultSet.next()) {
				password = resultSet.getString("whatsapp_pass");

			}
			if (w_pass.equals(password)) {
				System.out.println("Enter id to Update Passwod");
				int id = scanner.nextInt();
				System.out.println("Enter New Password");
				String wh_pass = scanner.next();
				user.setWhatsapp_pass(wh_pass);
				user.setId(id);
				String query1 = "update user1 set whatsapp_pass = ? where id = ?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
				preparedStatement1.setString(1, user.getWhatsapp_pass());
				preparedStatement1.setInt(2, user.getId());
				preparedStatement1.execute();
				connection.close();
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Incorrect Password");
			}
		}
			break;
		case 5: {
			System.out.println("Confirm Your Snapchat Password");
			String s_pass = scanner.next();
			String query = "select * from user1 where username = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			String password = null;
			while (resultSet.next()) {
				password = resultSet.getString("snapchat_pass");

			}
			if (s_pass.equals(password)) {
				System.out.println("Enter id to Update Passwod");
				int id = scanner.nextInt();
				System.out.println("Enter New Password");
				String sn_pass = scanner.next();
				user.setSnapchat_pass(sn_pass);
				user.setId(id);
				String query1 = "update user1 set snapchat_pass = ? where id = ?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
				preparedStatement1.setString(1, user.getSnapchat_pass());
				preparedStatement1.setInt(2, user.getId());
				preparedStatement1.execute();
				connection.close();
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Incorrect Password");
			}
		}
			break;
		default:
			System.out.println("Invalid Choice");

		}

	}
	
	public void displayPassword(User user) throws Exception {
		Connection connection  = getConnection();
		String query = "select facebook_pass,insta_pass,twitter_pass,whatsapp_pass,snapchat_pass from user1 where id=? " ;
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getId());
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println("Facebook password : " + resultSet.getString("facebook_pass"));
			System.out.println("Insta password : " + resultSet.getString("insta_pass"));
			System.out.println("Twitter password : " + resultSet.getString("twitter_pass"));
			System.out.println("Whatsapp password : " + resultSet.getString("whatsapp_pass"));
			System.out.println("Snapchat password : " + resultSet.getString("snapchat_pass"));
			System.out.println();
		}
		connection.close();
		
	}

}
