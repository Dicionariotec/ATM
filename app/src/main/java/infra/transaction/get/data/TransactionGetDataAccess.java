package infra.transaction.get.data;

import domain.Transaction.Transaction;
import application.transaction.get.data.TransactionGetDataGateway;

public class TransactionGetDataAccess implements TransactionGetDataGateway {
	TransactionGetData[] transactionGetData;
	TransactionGetModel transactionGetModel;
	
	public TransactionGetDataAccess(TransactionGetModel transactionGetModel) {
		this.transactionGetModel = transactionGetModel;
	}
	
	@Override
	public synchronized Transaction[] getTransactions(int userId) {
		transactionGetData = transactionGetModel.selectByUserId(userId);
		
		Transaction[] transactions = new Transaction[transactionGetData.length];
		for (int i = 0; i < transactionGetData.length; i++) {
			int transactionId = transactionGetData[i].getId();
			String transactionAmount = transactionGetData[i].getAmount();
			byte transactionType = transactionGetData[i].getType();
			String transactionDatetime = transactionGetData[i].getDatetime();
			transactions[i] = new Transaction(transactionId, transactionAmount, transactionType, transactionDatetime);
		}
		
		return transactions;
	}

}
