package application.transaction.get.output;

import domain.Transaction.Transaction;

public interface TransactionGetOutputBoundary {
	void generateTransactionOutputData(Transaction[] transactions);
}
