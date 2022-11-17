package client.core;


import client.view.chat.ChatViewModel;
import client.view.login.LoginViewModel;

public class ViewModelFactory {
    private ModelFactory mf;
    public ViewModelFactory(ModelFactory mf){
        this.mf = mf;
    }
    public LoginViewModel getLoginVM(){
        return new LoginViewModel(mf.getClientModel());
    }
    public ChatViewModel getChatVM() {
        return new ChatViewModel(mf.getClientModel());
    }
    
}
