package client.model;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.*;
import javafx.application.Platform;

import javax.swing.*;

public class Model implements IClientModel, Subject, Observer{
    private User user;
    private ArrayList<Message> messages;
    private ArrayList<User> accounts;
    private IClientServer server;
    
    public Model(){
        user = new User("","");
        messages = new ArrayList<Message>();
        accounts = new ArrayList<User>();
    }
	@Override
	public void setUserName(String username) {
		user.setUsername(username);
		
	}
	@Override
	public void setIp(String ip) {
		user.setIp(ip);
		
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return user.getIp();
	}
	
	public ArrayList<String> getAccountArrayList(){
        ArrayList<String> accountStringArrayList = new ArrayList<String>();
        for(int i = 0; i < accounts.size(); i++){
            accountStringArrayList.add(accounts.get(i).getUsername());
        }

        return accountStringArrayList;
    }
	public  ArrayList<String> getMessagesArrayList(){
        ArrayList<String> messagesStringArrayList = new ArrayList<String>();
        for(int i = 0; i < messages.size(); i++){
            String newMessage = messages.get(i).getSender().getUsername() +": "+ messages.get(i).getText();
            messagesStringArrayList.add(newMessage);
        }

        return messagesStringArrayList;
    }
	
	@Override
	public void sendMessage(Message msg) {
        try{
            server.sendMsg(msg);
        }catch(RemoteException rEx){
            System.out.println("Model::sendMessage::RemoteException");
        }
		notifyObservers();
	}
	public void addUser() {
		accounts.add(user);
	}
	public boolean connectToServer(String ip){
        try {
            String url = "rmi://" + ip + "/kajetan";

            server = (IClientServer) Naming.lookup( url );
            return true;
        } catch( Exception ex ) {
            System.out.println("Model::connectToServer::Exception");
            return false;
        }
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public synchronized void attachObserver( Observer observer )
    {
        observers.add( observer );
    }
    @Override
    public synchronized void detachObserver( Observer observer)
    {
        observers.remove( observer );
    }
    @Override
    public void notifyObservers()
    {
        System.out.println("ClientModel::notifyAllObservers");
        for( Observer o: observers )
            o.update();
    }
	@Override
	public void update() {
		// TODO Auto-generated method stub
		Platform.runLater(new Runnable() {
    		@Override
    		public void run() {
    			notifyObservers();
    		}
    	});
	}
	

    
}
