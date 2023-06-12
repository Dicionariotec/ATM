package infra.user.get.data;

import usecase.user.get.data.UserGetData;

public interface UserGetModel {
	UserGetData selectByNumber(String number, String password);
}
