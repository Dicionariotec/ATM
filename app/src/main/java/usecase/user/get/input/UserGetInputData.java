package usecase.user.get.input;

public class UserGetInputData {
    private String number;
    private String password;

    public UserGetInputData(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }
    
    public String getPassword() {
		return password;
	}
}
