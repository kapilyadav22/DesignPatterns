package BehaviouralPatterns.ChainOfResponsibility;

//creating handlers separately

enum LogLevel {
    DEBUG, ERROR, INFO
}

/*
class Logger {
    LogLevel level;
    String message;

    public Logger(LogLevel level, String message) {
        this.level = level;
        this.message = message;
    }
    LogLevel getLevel() {
        return level;
    }
    String getMessage() {
        return message;
    }
}
*/

interface Handler {
     void log(LogLevel level, String message);
     void setHandler(Handler handler);
}

class ErrorHandler implements Handler{
    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(level == LogLevel.ERROR){
            System.out.println("ERROR: " + message);
        } else if(handler!=null){
            System.out.println("inside ErrorHandler");
            handler.log(level, message);
        }
    }
}

class InfoHandler implements Handler{
    private Handler handler;
@Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    @Override
    public void log(LogLevel level, String message) {
        if(level == LogLevel.INFO){
            System.out.println("INFO: " + message);
        } else if(handler!=null){
            System.out.println("inside InfoHandler");
            handler.log(level, message);
        }
    }
}

class DebugHandler implements Handler{
    private Handler handler;
    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(level == LogLevel.DEBUG){
            System.out.println("DEBUG: " + message);
        } else if(handler!=null){
            handler.log(level, message);
        }
    }
}

public class Logger3Demo {
    public static void main(String[] args) {
//        Logger logger = new Logger(LogLevel.DEBUG,"Debug logger");
//        Logger logger2 = new Logger(LogLevel.INFO,"Info Logger");
//        Logger logger3 = new Logger(LogLevel.ERROR,"Error Logger");

        Handler handler = new InfoHandler();
        Handler handler2 = new ErrorHandler();
        Handler handler3 = new DebugHandler();

        handler.setHandler(handler2);
        handler2.setHandler(handler3);

        handler.log(LogLevel.DEBUG,"Debug logger");
        handler.log(LogLevel.INFO,"Info logger");
        handler.log(LogLevel.ERROR,"Error logger");



    }
}
