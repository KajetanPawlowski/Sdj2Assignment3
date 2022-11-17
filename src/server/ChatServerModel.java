package server;

import common.Observer;
import javafx.application.Platform;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ChatServerModel implements IChatServerModel, Observer {
    private IChatDBController database;
    public ChatServerModel(IChatDBController DB){
        database = DB;
    }
    public void run(){
        try {
            LocateRegistry.createRegistry( 1099 );

            ChatServerController controller = new ChatServerController();
            controller.attachObserver(this);

            Naming.rebind( "kajetan", controller );

            System.out.println( "Server listening on " + InetAddress.getLocalHost().getHostAddress() );
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update() {

    }
}
