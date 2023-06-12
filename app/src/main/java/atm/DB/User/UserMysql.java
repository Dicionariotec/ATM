package atm.DB.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import infra.user.get.data.UserGetModel;
import infra.user.update.data.UserUpdateModel;
import usecase.user.get.data.UserGetData;

public class UserMysql implements UserGetModel, UserUpdateModel {

	public synchronized UserGetData selectByNumber(String number, String password) {
		UserGetData userGetData = new UserGetData(-1);
		userGetData.setNumber(number);
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Idkfa600%")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users where number = '" + number + "' and password = '" + password + "' limit 1");
			if(resultSet.next()) {
				userGetData = new UserGetData(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getString(5));
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userGetData;
	}

	@Override
	public synchronized String updateBalance(int userId, String balance) {
		String balanceAfter = "";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Idkfa600%")) {
			PreparedStatement preparedStatement = connection.prepareStatement("update users set balance = ? where id = ? LIMIT 1;", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, balance);
			preparedStatement.setInt(2, userId);
			int affectedRows = preparedStatement.executeUpdate();
			connection.close();
			
			if (affectedRows > 0) {
				balanceAfter = getUserBalance(userId);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return balanceAfter;
	}
	
	private synchronized String getUserBalance(int userId) {
		String balance = "";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Idkfa600%")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select id, balance from users where id = " + userId + " limit 1");
			if(resultSet.next()) {
				balance = resultSet.getString(2);
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return balance;
	}

}
