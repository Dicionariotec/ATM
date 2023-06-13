package application.user.get;

import domain.User.User;
import domain.User.UserGetDataValidation;
import domain.User.UserGetInputValidation;
import application.user.get.data.UserGetDataGateway;
import application.user.get.input.UserGetInputBoundary;
import application.user.get.output.UserGetOutputBoundary;

public class UserGetInteractor implements UserGetInputBoundary {
    UserGetOutputBoundary userGetOutputBoundary;
    UserGetDataGateway userGetDataGateway;

    public UserGetInteractor(UserGetOutputBoundary userGetOutputBoundary, UserGetDataGateway userGetDataGateway) {
        this.userGetOutputBoundary = userGetOutputBoundary;
        this.userGetDataGateway = userGetDataGateway;
    }

    @Override
    public void generateUserInputData(String number, String password) throws Exception {
    	UserGetInputValidation.validate(number);
        User user = userGetDataGateway.getUser(number, password);
        UserGetDataValidation.validate(user);
        userGetOutputBoundary.generateUserOutputData(user.getId(), user.getName(), user.getBalance());
    }
}
