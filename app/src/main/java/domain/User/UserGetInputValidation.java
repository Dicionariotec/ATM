package domain.User;

public class UserGetInputValidation {
	public static void validate(String number) throws Exception {
		if (number.isEmpty()) {
        	throw new Exception("Numero do usuario nao pode ser nulo");
        }
	}
}
