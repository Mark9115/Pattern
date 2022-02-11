package mark.patterns.state;

interface ComputerState{
    void switchState(ComputerStateContext context);
}

class ComputerStateContext
{
    private ComputerState currentState;

    public ComputerStateContext(){
        currentState = new ComputerIsOn();
    }

    public void setState(ComputerState state){
        currentState = state;
    }

    public void switchState(){
        currentState.switchState(this);
    }
}

class ComputerIsOn implements ComputerState{
    @Override
    public void switchState(ComputerStateContext context){
        System.out.println("Computer is starting...");
    }

}

class ComputerIsOff implements ComputerState{
    @Override
    public void switchState(ComputerStateContext context){
        System.out.println("Computer is shutting down...");
    }

}

public class StatePattern {
    public static void main(String[] args) {
        ComputerStateContext stateContext = new ComputerStateContext();
        stateContext.switchState();
        stateContext.setState(new ComputerIsOff());
        stateContext.switchState();
        stateContext.setState(new ComputerIsOn());
        stateContext.switchState();
    }
}
