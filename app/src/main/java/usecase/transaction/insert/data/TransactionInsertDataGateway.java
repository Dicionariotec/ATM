package usecase.transaction.insert.data;

public interface TransactionInsertDataGateway {
	boolean inserTransaction(String amount, int userId, byte type);
}
