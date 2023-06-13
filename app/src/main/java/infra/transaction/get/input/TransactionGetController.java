package infra.transaction.get.input;

import application.transaction.get.input.TransactionGetInputBoundary;

public class TransactionGetController {
	TransactionGetInputBoundary transactionGetInputBoundary;
	
	public TransactionGetController(TransactionGetInputBoundary transactionGetInputBoundary) {
		this.transactionGetInputBoundary = transactionGetInputBoundary;
	}
	
	public void transactionGetInputData(int userId) throws Exception {
		transactionGetInputBoundary.generateTransactionInputData(userId);
	}
}
