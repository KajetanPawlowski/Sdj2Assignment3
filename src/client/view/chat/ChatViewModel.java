package client.view.chat;


import client.core.ViewModel;
import client.model.IClientModel;
import client.model.Model;
import common.Message;
import common.Observer;
import common.User;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ChatViewModel implements ViewModel, Observer {
    private IClientModel clientModel;

    private StringProperty messageInputProperty = new SimpleStringProperty("");
    private StringProperty accountNameLabelProperty = new SimpleStringProperty("");
    private ObservableList<String> messageList;
    private ObservableList<String> accountList;
    


    public ChatViewModel(IClientModel model){
        clientModel = model;
        clientModel.attachObserver(this);
        accountNameLabelProperty.set("Hi " + clientModel.getUserName());
        messageList = FXCollections.observableArrayList();
        accountList = FXCollections.observableArrayList();
        clientModel.notifyObservers();
        
    }

    public StringProperty getMessageInputProperty(){
        return messageInputProperty;
    }
    public StringProperty getAccountNameLabelProperty(){
        return accountNameLabelProperty;
    }
    public ObservableList<String> getMessagesList(){
        return messageList;
    }
    public ObservableList<String> getAccountsList(){
        return accountList;
    }
    
    
    
    
    public void sentMessage(){
        clientModel.sendMessage(new Message(new User(clientModel.getUserName(),""),messageInputProperty.get()));
        messageInputProperty.setValue("");

    }
    

    public void updateMessageList(){
        messageList.clear();
        for(int i = 0; i < clientModel.getMessagesArrayList().size(); i++) {
            messageList.add(clientModel.getMessagesArrayList().get(i));
        }

    }
    public void updateAccountList(){
        accountList.clear();
        for(int i = 0; i < clientModel.getAccountArrayList().size();i++){
            accountList.add(clientModel.getAccountArrayList().get(i));
        }
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		updateMessageList();
		updateAccountList();
		
	}

}
