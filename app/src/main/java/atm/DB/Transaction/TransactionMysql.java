package atm.DB.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import infra.transaction.get.data.TransactionGetData;
import infra.transaction.get.data.TransactionGetModel;
import infra.transaction.insert.data.TransactionInsertData;
import infra.transaction.insert.data.TransactionInsertModel;

public class TransactionMysql implements TransactionGetModel, TransactionInsertModel {

	@Override
	public synchronized TransactionGetData[] selectByUserId(int userId) {
		List<TransactionGetData> transactionGetDatas = new ArrayList<>();
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Idkfa600%")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from transactions where user_id = " + userId);
			while(resultSet.next()) {
				transactionGetDatas.add(new TransactionGetData(resultSet.getInt(1),resultSet.getString(2),resultSet.getByte(3),resultSet.getString(5)));
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactionGetDatas.toArray(new TransactionGetData[0]);
	}

	@Override
	public boolean insert(String amount, int userId, byte type) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM", "root", "Idkfa600%")) {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into transactions (amount, type, user_id, created_at) values ('" + amount + "', " + type + ", " + userId + ", NOW())", Statement.RETURN_GENERATED_KEYS);
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows > 0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					connection.close();
					return true;
				}
			}
			
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
