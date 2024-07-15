package program.Actions;

import program.Map;

public abstract class MapReplanishAction extends Action{
    int minimumEntityAmount;

    public MapReplanishAction(Map map) {
        super(map);
    }
    public abstract void replanishMap();
    public abstract int getNumberOfEntity();

    @Override
    public void performAction() {
        if(getNumberOfEntity() < minimumEntityAmount) replanishMap();
    }
}
