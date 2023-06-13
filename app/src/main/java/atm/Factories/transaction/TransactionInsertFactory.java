package atm.Factories.transaction;

import atm.DB.Transaction.TransactionMysql;
import infra.transaction.insert.data.TransactionInsertDataAccess;
import infra.transaction.insert.data.TransactionInsertModel;
import infra.transaction.insert.input.TransactionInsertController;
import infra.transaction.insert.output.TransactionInsertPresenter;
import application.transaction.insert.TransactionInsertInteractor;

public class TransactionInsertFactory {
	// User case
	TransactionInsertInteractor transactionInsertInteractor;
	
	// Input
	TransactionInsertController transactionInsertController;
	
	// Output
	TransactionInsertPresenter transactionInsertPresenter;
	
	// Gateway
	TransactionInsertDataAccess transactionInsertDataAccess;
	
	// Database
	TransactionInsertModel transactionInsertModel;
	
	public TransactionInsertFactory() {
		transactionInsertModel = new TransactionMysql();
		transactionInsertDataAccess = new TransactionInsertDataAccess(transactionInsertModel);
		
		transactionInsertPresenter = new TransactionInsertPresenter();
		transactionInsertInteractor = new TransactionInsertInteractor(transactionInsertPresenter, transactionInsertDataAccess);
		transactionInsertController = new TransactionInsertController(transactionInsertInteractor);
	}
	
	public TransactionInsertController getTransactionInsertController() {
		return transactionInsertController;
	}
	
	public TransactionInsertPresenter getTransactionInsertPresenter() {
		return transactionInsertPresenter;
	}
}
