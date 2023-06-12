package domain.Transaction;

public class TransactionInsertInputValidation {
	public static void validate(String amountBefore, String amount, byte type) throws Exception {
		if (!amount.matches("^[0-9]*$")) {
			throw new Exception("Quantidade deve ter apenas numeros");
		}
		
		int transactionAmount = Integer.parseInt(amount);
		if (transactionAmount < 0 && transactionAmount > 9999) {
			throw new Exception("Quantidade deve ser maior do que zero e menor do que 9999");
		}
		
		if (type == TransactionType.WITHDRAWAL.index) {
			int transactionAmountBefore = Integer.parseInt(amountBefore);
			if (transactionAmount > transactionAmountBefore) {
				throw new Exception("Saldo insuficiente");
			}
		}
	}
}
