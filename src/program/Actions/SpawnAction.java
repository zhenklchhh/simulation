package program.Actions;

import program.Coordinates;
import program.Entities.Entity;
import program.Map;

public abstract class SpawnAction<T extends Entity> extends Action {
    int currentRate = 0;
    int spawnRate;

    SpawnAction(Map map) {
        super(map);
    }

    protected abstract T spawnEntity(Coordinates coordinates);
    @Override
    public void performAction() {
        while(currentRate < spawnRate){
            Coordinates emptyCoordinates = map.getEmptyCoordinates();
            map.addEntity(spawnEntity(emptyCoordinates));
            currentRate++;
        }
    }
}
