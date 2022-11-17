package client.core;


import client.model.IClientModel;
import client.model.Model;

public class ModelFactory {
    private IClientModel clientModel;


    public IClientModel getClientModel(){
        if(clientModel == null){
            clientModel = new Model();
        }
        return clientModel;
    }


}
