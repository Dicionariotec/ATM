package infra.user.get.data;

public interface UserGetModel {
	UserGetData selectByNumber(String number, String password);
}
