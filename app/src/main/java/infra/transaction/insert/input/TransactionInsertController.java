package infra.transaction.insert.input;

import application.transaction.insert.input.TransactionInsertInputBoundary;

public class TransactionInsertController {
	TransactionInsertInputBoundary transactionInsertInputBoundary;
	
	public TransactionInsertController(TransactionInsertInputBoundary transactionInsertInputBoundary) {
		this.transactionInsertInputBoundary = transactionInsertInputBoundary;
	}
	
	public void transactionInsertInputData(String amountBefore, String amount, int userId, byte type) throws Exception {
		transactionInsertInputBoundary.generateTransactionInputData(amountBefore, amount, userId, type);
	}
}
