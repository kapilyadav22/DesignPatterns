package CreationalDesignPattern.FactoryMethod;

interface ILogger {
    void createLog();
}
class DebugLogger implements ILogger {
    @Override
    public void createLog(){
        System.out.println("DEBUG is called");
    }
}

class InfoLogger implements ILogger {
    @Override
    public void createLog() {
        System.out.println("Info logger is called");
    }
}

class ErrorLogger implements ILogger {
    @Override
    public void createLog() {
        System.out.println("CreationalDesignPattern.FactoryMethod.ErrorLogger is called");
    }
}

interface ILoggerFactory {
    ILogger getLogger();
}

class DebugLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger getLogger()  {
        return new DebugLogger();
    }
}
class InfoLoggerFactory implements ILoggerFactory {
    public ILogger getLogger() {
        return new InfoLogger();
    }
}
class ErrorLoggerFactory implements ILoggerFactory {
    public  ILogger getLogger()   {
        return new ErrorLogger();
    }
}

public class FactoryMethod {
    FactoryMethod(){
        DebugLoggerFactory dlf = new DebugLoggerFactory();
        ILogger Ilogger =  dlf.getLogger();
        Ilogger.createLog();

        ErrorLoggerFactory erfl = new ErrorLoggerFactory();
        ILogger Ilogger2 = erfl.getLogger();
        Ilogger2.createLog();

        InfoLoggerFactory ifl = new InfoLoggerFactory();
        ILogger Ilogger3 = ifl.getLogger();
        Ilogger3.createLog();

    }
}

