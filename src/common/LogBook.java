package common;

import java.util.ArrayList;

public class LogBook {
    public ArrayList<String> activities = new ArrayList<String>();

    public void log(String className, String method){
        String activity = className + "::" + method;
    }
    public void log(String className, String method, String errorCode){
        String activity = className + "::" + method + "::" + errorCode;
    }
    private void saveActivity(String activity){
        activities.add(activity);
        System.out.println(activity);
    }
}
