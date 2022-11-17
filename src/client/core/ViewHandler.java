package client.core;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory vmf;
    private Scene logInScene;
    private Scene chatScene;
    private Scene mainScene;
    private Stage stage;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
        stage = new Stage();
    }

    public void start() {
        openLoginView();
    }

    public void openLoginView() {
            Parent root = createFromFXML(vmf.getLoginVM(),"../view/login/LogInView.fxml");

            //No MENU BAR

            logInScene = new Scene(root);
            stage.setScene(logInScene);
            stage.setTitle("Login");
            stage.show();

    }
    
    public void openChatView() {
        Parent root = createFromFXML(vmf.getChatVM(),"../view/chat/ChatView.fxml");

        //No MENU BAR

        chatScene = new Scene(root);
        stage.setScene(chatScene);
        stage.setTitle("Chat");
        stage.show();

    }

    
	private Parent createFromFXML(ViewModel vm, String filePath){
        Parent layout;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(filePath));
            layout = loader.load();

            FXMLController controller = loader.getController();
            controller.init(this, vm);


        } catch (IOException e) {
            e.printStackTrace();
            layout = null;
        }
        return layout;
    }


}
