package common;

public class LogSingleton {
    private LogBook log = null;
    public LogBook getLog(){
        if(log == null){
            log = new LogBook();
        }
        return log;
    }
}
