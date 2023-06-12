package usecase.user.get.data;

import domain.User.User;

public interface UserGetDataGateway {
    User getUser(String number, String password);
}
