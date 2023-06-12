package usecase.transaction.insert.input;

public interface TransactionInsertInputBoundary {
	void generateTransactionInputData(String amountBefore, String amount, int userId, byte type) throws Exception;
}
