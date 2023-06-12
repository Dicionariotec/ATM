package domain.User;

public class User {
    private int id;
    private String number;
    private String name;
    private String balance;
    
    public User(int id) {
        this.id = id;
    }

    public User(int id, String number, String name, String balance) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.balance = balance;
    }
    
    public int getId() {
		return id;
	}

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
    
    public String getBalance() {
		return balance;
	}
}
