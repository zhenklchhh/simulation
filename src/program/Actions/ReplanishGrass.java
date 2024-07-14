package program.Actions;

import program.Entities.Grass;
import program.Map;

public class ReplanishGrass extends ReplanishAction {
    public ReplanishGrass(Map map) {
        super(map);
        this.minimumEntityAmount = (map.height * map.width) / 20;
    }

    @Override
    public int getEntityInstenseCounts() {
        return map.getEntityCounts().get(Grass.class);
    }

    @Override
    public void replanishMap() {
        SpawnGrass spawnGrassAction = new SpawnGrass(map);
        spawnGrassAction.performAction();
    }
}
