package domain.Transaction;

public enum TransactionType {
	DEPOSIT(1),
	WITHDRAWAL(2);
	
	public final int index;
	
	private TransactionType(int index) {
		this.index = index;
	}
}
