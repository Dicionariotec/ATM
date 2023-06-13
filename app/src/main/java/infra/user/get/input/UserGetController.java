package infra.user.get.input;

import application.user.get.input.UserGetInputBoundary;

public class UserGetController {
    UserGetInputBoundary userGetInputBoundary;

    public UserGetController(UserGetInputBoundary userGetInputBoundary) {
        this.userGetInputBoundary = userGetInputBoundary;
    }

    public void userGetInputData(String number, String password) throws Exception {
        userGetInputBoundary.generateUserInputData(number, password);
    }
}
