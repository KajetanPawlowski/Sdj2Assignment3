package server;

public class RunServer {

    public static void main(String[] args) {
        ChatServerModel server = new ChatServerModel(new CharDBController());
        server.run();
    }
}
