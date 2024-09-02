package BehaviouralPatterns.ChainOfResponsibility;

/*use cases
    ATM/vending machine
    Design logger (Amazon)
 */
abstract class LogProcessor2 {

    public static final int  DEBUG = 0;
    public static final int  ERROR = 1;
    public static final int  INFO = 2;
    LogProcessor2 nextProcessor;
    LogProcessor2(LogProcessor2 nextProcessor){
        this.nextProcessor = nextProcessor;
    }
    abstract void log(int logLevel, String message);
}

 class DebugLogProcessor2 extends LogProcessor2 {
    public DebugLogProcessor2(LogProcessor2 nextProcessor) {
        super(nextProcessor);
    }
    @Override
    void log(int logLevel, String message) {
        if(logLevel == DEBUG){
            System.out.println(message);
        } else if(nextProcessor != null){
                nextProcessor.log(logLevel,message);
            }
        }
    }

class ErrorLogProcessor2 extends LogProcessor2 {
    public ErrorLogProcessor2(LogProcessor2 nextProcessor) {
        super(nextProcessor);
    }
    @Override
    void log(int logLevel,String message) {
        if(logLevel == ERROR){
            System.out.println(message);
        } else if(nextProcessor != null){
            nextProcessor.log(logLevel,message);
        }
    }
}

class InfoLogProcessor2 extends LogProcessor2 {
    public InfoLogProcessor2(LogProcessor2 nextProcessor) {
        super(nextProcessor);
    }
    @Override
    void log(int logLevel,String message) {
        if(logLevel == INFO){
            System.out.println(message);
        }
        else if(nextProcessor != null){
            nextProcessor.log(logLevel,message);
        }
    }
}

public class LoggerDemo2 {

    public static void main(String[] args) {

        LogProcessor2 logProcessor = new InfoLogProcessor2(
                new ErrorLogProcessor2(new DebugLogProcessor2(null)));
        logProcessor.log(LogProcessor2.INFO,"This is a info logger");
        logProcessor.log(LogProcessor2.DEBUG,"This is a debug logger");
        logProcessor.log(LogProcessor2.ERROR, "This is an error logger");
    }
}
