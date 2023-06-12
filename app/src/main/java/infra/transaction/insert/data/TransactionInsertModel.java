package infra.transaction.insert.data;

public interface TransactionInsertModel {
	boolean insert(String amount, int userId, byte type);
}
