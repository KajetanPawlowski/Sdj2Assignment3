package server;

import common.IClientServer;
import common.Message;
import common.Observer;
import common.Subject;
import javafx.application.Platform;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServerController implements IClientServer, Subject {

    public ChatServerController() throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
    }
    @Override
    public void sendMsg(Message msg) throws RemoteException {
        System.out.println("ChatServerController::sendMs-" + msg.getText());
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

}
