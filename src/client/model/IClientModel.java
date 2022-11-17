package client.model;

import java.util.ArrayList;

import common.Message;
import common.Observer;

public interface IClientModel {
	void setUserName(String username);
	void setIp(String ip);
	String getUserName();
	String getIp();
	ArrayList<String> getAccountArrayList();
	ArrayList<String> getMessagesArrayList();
	
	void sendMessage(Message msg);
	void addUser();
	boolean connectToServer(String ip);
	
	
	void attachObserver( Observer observer );

    void detachObserver( Observer observer);

    void notifyObservers();
	
}
