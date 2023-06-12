package infra.user.get.output;

import usecase.user.get.output.UserGetOutputBoundary;
import usecase.user.get.output.UserGetOutputData;

public class UserGetPresenter implements UserGetOutputBoundary {
    UserGetOutputData userGetOutputData;

    @Override
    public void generateUserOutputData(int id, String userName, String userBalance) {
        userGetOutputData = new UserGetOutputData(id, userName, userBalance);
    }

    public UserGetOutputData getUserGetOutputData() {
        return userGetOutputData;
    }
}
