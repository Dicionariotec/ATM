package infra.transaction.insert.data;

import usecase.transaction.insert.data.TransactionInsertDataGateway;

public class TransactionInsertDataAccess implements TransactionInsertDataGateway {
	TransactionInsertModel transactionInsertModel;
	
	public TransactionInsertDataAccess(TransactionInsertModel transactionInsertModel) {
		this.transactionInsertModel = transactionInsertModel;
	}
	
	@Override
	public boolean inserTransaction(String amount, int userId, byte type) {
		return transactionInsertModel.insert(amount, userId, type);
	}

}
