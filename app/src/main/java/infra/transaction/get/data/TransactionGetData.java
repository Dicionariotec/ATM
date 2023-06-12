package infra.transaction.get.data;

public class TransactionGetData {
	private int id;
	private String amount;
	private byte type;
	private String datetime;
	
	public TransactionGetData(int id) {
		this.id = id;
	}
	
	public TransactionGetData(int id, String amount, byte type, String datetime) {
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.datetime = datetime;
	}
	
	public int getId() {
		return id;
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
