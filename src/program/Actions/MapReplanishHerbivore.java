package program.Actions;

import program.Entities.Creatures.Herbivore;
import program.Map;

public class MapReplanishHerbivore extends MapReplanishAction {
    public MapReplanishHerbivore(Map map) {
        super(map);
        this.minimumEntityAmount = (map.height * map.width) / 50;
    }

    @Override
    public void replanishMap() {
        SpawnHerbivore spawnHerbivoreAction = new SpawnHerbivore(map);
        spawnHerbivoreAction.performAction();
    }

    @Override
    public int getNumberOfEntity() {
        return map.getEntityCounts(Herbivore.class);
    }
}
