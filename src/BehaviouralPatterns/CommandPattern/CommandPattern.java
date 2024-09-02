package BehaviouralPatterns.CommandPattern;

//create  interface for command

import java.util.Stack;

interface Command {
    void execute();
    void undo();
}

//Receiver
class AirConditioner {
    public void turnOnAC(){
        System.out.println("Turning on air condtioner");
    }
    public void turnOffAC(){
        System.out.println("Turning off air condtioner");
    }
}
//create concrete command classes

class TurnOnCommand implements Command {
    AirConditioner airConditioner;
    public TurnOnCommand(AirConditioner airConditioner){
       this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.turnOnAC();
    }

    @Override
    public void undo() {
        airConditioner.turnOffAC();
    }

}
class TurnOffCommand implements Command {
    AirConditioner airConditioner;
    public TurnOffCommand(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOffAC();
    }

    @Override
    public void undo() {
        airConditioner.turnOnAC();
    }

}

//invoker

class Invoker  {
    Stack<Command> undoStack = new Stack<>();
    Stack<Command> redoStack = new Stack<>();
    public void pressButton(Command command) {
        command.execute();
        undoStack.push(command);
        //because initialy, there should not be any command in redo state
        redoStack.clear();
    }

    public void undo() {
        if(!undoStack.isEmpty()){
           Command command =  undoStack.pop();
           command.undo();
           redoStack.push(command);
        }
    }

    public void redo() {
        if(!redoStack.isEmpty()){
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        Invoker invoker = new Invoker();
        TurnOnCommand turnOnCommand = new TurnOnCommand(airConditioner);
//        TurnOffCommand turnOffCommand = new TurnOffCommand(airConditioner);
        invoker.pressButton(turnOnCommand);
//        invoker.pressButton(turnOffCommand);
        invoker.undo();
        invoker.redo();
    }
}
