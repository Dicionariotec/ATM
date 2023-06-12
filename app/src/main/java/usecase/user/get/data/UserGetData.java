package usecase.user.get.data;

public class UserGetData {
	private int id;
	private String number = "";
	private String name = "";
	private String balance = "";
	
	public UserGetData(int id) {
		this.id = id;
	}
	
	public UserGetData(int id, String number, String name, String balance) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.balance = balance;
	}
	
	public UserGetData() {}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getBalance() {
		return balance;
	}
}
