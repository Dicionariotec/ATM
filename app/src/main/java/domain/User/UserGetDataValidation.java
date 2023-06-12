package domain.User;

public class UserGetDataValidation {
	public static void validate(User user) throws Exception {
		if (user.getId() == -1) {
        	throw new Exception("Usuario nao encontrado");
        }
	}
}
