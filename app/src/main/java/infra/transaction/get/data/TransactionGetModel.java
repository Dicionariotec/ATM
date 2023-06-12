package infra.transaction.get.data;

public interface TransactionGetModel {
	TransactionGetData[] selectByUserId(int userId);
}
