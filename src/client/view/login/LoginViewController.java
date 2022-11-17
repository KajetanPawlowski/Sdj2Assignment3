package client.view.login;

import client.core.FXMLController;
import client.core.ViewHandler;
import client.core.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginViewController implements FXMLController{
    private ViewHandler viewHandler;
    private LoginViewModel logInVM;

    @FXML
    TextField loginTextField;
    @FXML
    TextField ipTextField;
    @FXML
    Label errorLabel;


    public void init(ViewHandler viewHandler, ViewModel vm){
        this.viewHandler = viewHandler;
        this.logInVM = (LoginViewModel) vm;
        loginTextField.textProperty().bindBidirectional(logInVM.getUserNameProperty());
        ipTextField.textProperty().bindBidirectional(logInVM.getIpProperty());
        errorLabel.textProperty().bindBidirectional(logInVM.getErrorLabelProperty());
    }


    @FXML
    public void onLoginBtn(){
    	if(logInVM.validateInput()) {
    		logInVM.login();
        	viewHandler.openChatView();
    	}else {
    		logInVM.loginError();
    	}
    	
    }
}
