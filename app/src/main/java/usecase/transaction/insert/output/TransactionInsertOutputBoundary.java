package usecase.transaction.insert.output;

public interface TransactionInsertOutputBoundary {
	void generateTransactionOutputData(boolean wasSuccessfullyInserted);
}
