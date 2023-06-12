package usecase.transaction.get;

import domain.Transaction.Transaction;
import usecase.transaction.get.data.TransactionGetDataGateway;
import usecase.transaction.get.input.TransactionGetInputBoundary;
import usecase.transaction.get.output.TransactionGetOutputBoundary;

public class TransactionGetInteractor implements TransactionGetInputBoundary {
    TransactionGetOutputBoundary transactionGetOutputBoundary;
    TransactionGetDataGateway transactionGetDataGateway;

    public TransactionGetInteractor(TransactionGetOutputBoundary transactionGetOutputBoundary, TransactionGetDataGateway transactionGetDataGateway) {
        this.transactionGetOutputBoundary = transactionGetOutputBoundary;
        this.transactionGetDataGateway = transactionGetDataGateway;
    }

	@Override
	public void generateTransactionInputData(int userId) {
		Transaction[] transactions = transactionGetDataGateway.getTransactions(userId);
		transactionGetOutputBoundary.generateTransactionOutputData(transactions);
	}
}
