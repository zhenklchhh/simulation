package program.Actions;

import program.Entities.Creatures.Herbivore;
import program.Map;

public class ReplanishHerbivore extends ReplanishAction{
    public ReplanishHerbivore(Map map) {
        super(map);
        this.minimumEntityAmount = (map.height * map.width) / 50;
    }

    @Override
    public void replanishMap() {
        SpawnHerbivore spawnHerbivoreAction = new SpawnHerbivore(map);
        spawnHerbivoreAction.performAction();
    }

    @Override
    public int getEntityInstenseCounts() {
        return map.getEntityCounts().get(Herbivore.class);
    }
}
