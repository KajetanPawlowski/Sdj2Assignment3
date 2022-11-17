package client.view.login;

import client.core.ViewModel;
import client.model.IClientModel;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel implements ViewModel {
    private IClientModel clientModel;

    private StringProperty userNameProperty = new SimpleStringProperty("Default Name");
    private StringProperty ipProperty = new SimpleStringProperty("");
    private StringProperty errorLabelProperty = new SimpleStringProperty("");


    public LoginViewModel(IClientModel model){
        clientModel = model;
    }


    public StringProperty getUserNameProperty(){
        return userNameProperty;
    }
    public StringProperty getIpProperty(){
        return ipProperty;
    }
    public StringProperty getErrorLabelProperty(){
        return errorLabelProperty;
    }
    
    public boolean validateInput() {
    	if(userNameProperty.get().equals("")) {
    		return false;
    	}
    	if(ipProperty.get().equals("")) {
			return false;
		}
    	return clientModel.connectToServer(ipProperty.get());
    }
    public void login() {
    	clientModel.setUserName(userNameProperty.get());
    	clientModel.setIp(ipProperty.get());
    	clientModel.addUser();
    }
    
    public void loginError() {
    	errorLabelProperty.set("Invalid input");
    }
  

}
