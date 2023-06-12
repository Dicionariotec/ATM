package infra.transaction.insert.data;

public class TransactionInsertData {
	private int id;
    private int userId;
    private String amount;
    private byte type;
    private String datetime;
    
    public TransactionInsertData(int id, int userId, String amount, byte type, String datetime) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.datetime = datetime;
    }
    
    public String getAmount() {
		return amount;
	}
    
    public String getDatetime() {
		return datetime;
	}
    
    public int getId() {
		return id;
	}
    
    public byte getType() {
		return type;
	}
    
    public int getUserId() {
		return userId;
	}
}
