package infra.transaction.get.output;

import domain.Transaction.Transaction;
import usecase.transaction.get.output.TransactionGetOutputBoundary;

public class TransactionGetPresenter implements TransactionGetOutputBoundary {
	TransactionGetOutputData[] transactionGetOutputData;
	
	@Override
	public void generateTransactionOutputData(Transaction[] transactions) {
		transactionGetOutputData = new TransactionGetOutputData[transactions.length];
		for (int i = 0; i < transactions.length; i++) {
			String transactionAmount = transactions[i].getAmount();
			byte transactionType = transactions[i].getType();
			String transactionDatetime = transactions[i].getDatetime();
			transactionGetOutputData[i] = new TransactionGetOutputData(transactionAmount, transactionType, transactionDatetime);
		}
	}
	
	public TransactionGetOutputData[] getTransactionGetOutputData() {
		return transactionGetOutputData;
	}

}
