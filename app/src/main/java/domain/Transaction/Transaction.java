package domain.Transaction;

public class Transaction {
    private int id;
    private int userId;
    private String amount;
    private byte type;
    private String datetime;
    
    public Transaction(int id, String amount, byte type, String datetime) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.datetime = datetime;
    }

    public Transaction(int id, int userId, String amount, byte type, String datetime) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.datetime = datetime;
    }
    
    public int getId() {
		return id;
	}

    public int getUserId() {
		return userId;
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
