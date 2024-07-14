package program.Actions;

import program.Map;

public abstract class ReplanishAction extends Action{
    int minimumEntityAmount;

    public ReplanishAction(Map map) {
        super(map);
    }
    public abstract void replanishMap();
    public abstract int getEntityInstenseCounts();

    @Override
    public void performAction() {
        if(getEntityInstenseCounts() < minimumEntityAmount) replanishMap();
    }
}
