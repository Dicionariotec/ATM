package usecase.transaction.get.data;

import domain.Transaction.Transaction;

public interface TransactionGetDataGateway {
	Transaction[] getTransactions(int userId);
}
