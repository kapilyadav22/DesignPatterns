package CreationalDesignPattern.SimpleFactory;

enum LoggerType {
    INFO,
    WARNING,
    ERROR
}
interface Logger {
    void log1(String s);
}

class ErrorLogger implements Logger {

    @Override
    public void log1(String logMessage){
        System.out.println("I am inside" + logMessage);
    }
}

class InfoLogger implements Logger {

    public void log1(String logMessage) {
        System.out.println("I am inside" + logMessage);
    }
}

class LoggerFactory {
    public Logger createLogger(LoggerType loggerType){
        switch(loggerType) {
            case INFO:  return new InfoLogger();
            case ERROR: return new ErrorLogger();
            default : throw new IllegalArgumentException("Unknown logger type");
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args){
       LoggerFactory factory = new LoggerFactory();
        try {
           Logger logger = factory.createLogger(LoggerType.INFO);
            logger.log1("info logger");
        } catch(Exception e) {
            System.out.println("Please choose a valid logger type " + e.getMessage());
        }
//        Logger logger2 = factory.createLogger("error");
//        logger2.log1("error logger");
    }
}


