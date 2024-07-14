package program.Actions;


import program.Map;

public abstract class Action {
    protected Map map;
    Action(Map map){
        this.map = map;
    }

    public abstract void performAction();
}
