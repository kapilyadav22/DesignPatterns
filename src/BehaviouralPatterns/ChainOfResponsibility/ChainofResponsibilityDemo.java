package BehaviouralPatterns.ChainOfResponsibility;

/*use cases
    ATM/vending machine
    Design logger (Amazon)
 */
abstract class LogProcessor {

    public static final int  DEBUG = 0;
    public static final int  ERROR = 1;
    public static final int  INFO = 2;
    LogProcessor nextProcessor;
    LogProcessor(LogProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }
     void log(int logLevel, String message){
        if(nextProcessor != null){
            nextProcessor.log(logLevel,message);
        }
     }
}

class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    void log(int logLevel, String message) {
        if(logLevel == DEBUG){
            System.out.println(message);
        } else {
            System.out.println("Inside DebugLogProcessor, proceeding to next Processor" );
            super.log(logLevel,message);
        }
    }
}

class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    void log(int logLevel,String message) {
        if(logLevel == ERROR){
            System.out.println(message);
        } else {
            System.out.println("Inside ErrorLogProcessor, proceeding to next Processor" );
            super.log(logLevel,message);
        }
    }
}

class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    void log(int logLevel,String message) {
        if(logLevel == INFO){
            System.out.println(message);
        } else {
            System.out.println("Inside InfoLogProcessor, proceeding to next Processor" );
            super.log(logLevel,message);
        }
    }
}

public class ChainofResponsibilityDemo {
    public static void main(String[] args) {

        LogProcessor logProcessor = new InfoLogProcessor(
                new ErrorLogProcessor(new DebugLogProcessor(null)));
        logProcessor.log(LogProcessor.INFO,"This is a info logger");
        logProcessor.log(LogProcessor.DEBUG,"This is a debug logger");
        logProcessor.log(LogProcessor.ERROR, "This is an error logger");
    }
}
