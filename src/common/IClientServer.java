package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientServer extends Remote {
    void sendMsg(Message msg) throws RemoteException;
}
