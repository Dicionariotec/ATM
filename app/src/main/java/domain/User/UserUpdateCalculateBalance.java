package domain.User;

import domain.Transaction.TransactionType;

public class UserUpdateCalculateBalance {
	public static String calculate(String balance, String amount, byte type) {
		amount = TransactionType.DEPOSIT.index == type ? "+" + amount : "-" + amount;
		int userBalance = Integer.parseInt(balance);
		int transactionAmount = Integer.parseInt(amount);
		int newBalance = userBalance + transactionAmount;
		return String.valueOf(newBalance);
	}
}
