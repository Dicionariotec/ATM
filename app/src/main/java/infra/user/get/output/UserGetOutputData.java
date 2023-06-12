package infra.user.get.output;

public class UserGetOutputData {
	private int userId;
    private String userName;
    private String userBalance;

    public UserGetOutputData(int userId, String userName, String userBalance) {
    	this.userId = userId;
        this.userName = userName;
        this.userBalance = userBalance;
    }

    public String getUserName() {
        return userName;
    }
    
    public int getUserId() {
		return userId;
	}
    
    public String getUserBalance() {
		return userBalance;
	}
}
