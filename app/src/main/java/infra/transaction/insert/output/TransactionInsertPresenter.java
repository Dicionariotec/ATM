package infra.transaction.insert.output;

import usecase.transaction.insert.output.TransactionInsertOutputBoundary;

public class TransactionInsertPresenter implements TransactionInsertOutputBoundary{
	boolean wasSuccessfullyInserted;
	
	@Override
	public void generateTransactionOutputData(boolean wasSuccessfullyInserted) {
		this.wasSuccessfullyInserted = wasSuccessfullyInserted;
	}
	
	public boolean wasSuccessfullyInserted() {
		return wasSuccessfullyInserted;
	}
}
