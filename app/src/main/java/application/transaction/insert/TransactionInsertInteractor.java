package application.transaction.insert;

import domain.Transaction.TransactionInsertInputValidation;
import application.transaction.insert.data.TransactionInsertDataGateway;
import application.transaction.insert.input.TransactionInsertInputBoundary;
import application.transaction.insert.output.TransactionInsertOutputBoundary;

public class TransactionInsertInteractor implements TransactionInsertInputBoundary {
	TransactionInsertOutputBoundary transactionInsertOutputBoundary;
	TransactionInsertDataGateway transactionInsertDataGateway;
	
	public TransactionInsertInteractor(TransactionInsertOutputBoundary transactionInsertOutputBoundary, TransactionInsertDataGateway transactionInsertDataGateway) {
		this.transactionInsertOutputBoundary = transactionInsertOutputBoundary;
		this.transactionInsertDataGateway = transactionInsertDataGateway;
	}
	
	@Override
	public void generateTransactionInputData(String amountBefore, String amount, int userId, byte type) throws Exception {
		TransactionInsertInputValidation.validate(amountBefore, amount, type);
		boolean wasSuccessfullyInserted = transactionInsertDataGateway.inserTransaction(amount, userId, type);
		transactionInsertOutputBoundary.generateTransactionOutputData(wasSuccessfullyInserted);
	}

}
