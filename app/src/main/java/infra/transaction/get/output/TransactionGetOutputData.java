package infra.transaction.get.output;

public class TransactionGetOutputData {
	private String amount;
	private byte type;
	private String datetime;
	
	public TransactionGetOutputData(String amount, byte type, String datetime) {
		this.amount = amount;
		this.type = type;
		this.datetime = datetime;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public byte getType() {
		return type;
	}
	
	public String getDatetime() {
		return datetime;
	}
}
