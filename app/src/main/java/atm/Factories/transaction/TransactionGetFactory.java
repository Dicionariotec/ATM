package atm.Factories.transaction;

import atm.DB.Transaction.TransactionMysql;
import infra.transaction.get.data.TransactionGetDataAccess;
import infra.transaction.get.data.TransactionGetModel;
import infra.transaction.get.input.TransactionGetController;
import infra.transaction.get.output.TransactionGetPresenter;
import usecase.transaction.get.TransactionGetInteractor;

public class TransactionGetFactory {
	// Use case
	TransactionGetInteractor transactionGetInteractor;
	
	// Input
	TransactionGetController transactionGetController;
	
	// Output
	TransactionGetPresenter transactionGetPresenter;
	
	// Gateway
	TransactionGetDataAccess transactionGetDataAccess;
	
	// Database
	TransactionGetModel transactionGetModel;
	
	public TransactionGetFactory() {
		transactionGetModel = new TransactionMysql();
		transactionGetDataAccess = new TransactionGetDataAccess(transactionGetModel);
		
		transactionGetPresenter = new TransactionGetPresenter();
		transactionGetInteractor = new TransactionGetInteractor(transactionGetPresenter, transactionGetDataAccess);
		transactionGetController = new TransactionGetController(transactionGetInteractor);
	}
	
	public TransactionGetController getTransactionGetController() {
		return transactionGetController;
	}
	
	public TransactionGetPresenter getTransactionGetPresenter() {
		return transactionGetPresenter;
	}
}
