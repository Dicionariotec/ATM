package usecase.user.get;

import domain.User.User;
import usecase.user.get.data.UserGetDataGateway;
import usecase.user.get.input.UserGetInputBoundary;
import usecase.user.get.input.UserGetInputData;
import usecase.user.get.output.UserGetOutputBoundary;

public class UserGetInteractor implements UserGetInputBoundary {
    UserGetOutputBoundary userGetOutputBoundary;
    UserGetDataGateway userGetDataGateway;

    public UserGetInteractor(UserGetOutputBoundary userGetOutputBoundary, UserGetDataGateway userGetDataGateway) {
        this.userGetOutputBoundary = userGetOutputBoundary;
        this.userGetDataGateway = userGetDataGateway;
    }

    @Override
    public void generateUserInputData(String number, String password) throws Exception {
        // TODO: apagar esse usergetinputdata se so estiver usando aqui
    	UserGetInputData userGetInputData = new UserGetInputData(number, password);

    	// TODO: validar em outro local
        if (userGetInputData.getNumber().isEmpty()) {
        	throw new Exception("Numero do usuario nao pode ser nulo");
        }
        
        User user = userGetDataGateway.getUser(userGetInputData.getNumber(), userGetInputData.getPassword());
        
        if (user.getId() == -1) {
        	throw new Exception("Usuario nao encontrado");
        }
        
        userGetOutputBoundary.generateUserOutputData(user.getId(), user.getName(), user.getBalance());
    }
}
