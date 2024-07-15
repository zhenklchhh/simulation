package program.Actions;

import program.Entities.Grass;
import program.Map;

public class MapReplanishGrass extends MapReplanishAction {
    public MapReplanishGrass(Map map) {
        super(map);
        this.minimumEntityAmount = (map.height * map.width) / 20;
    }

    @Override
    public int getNumberOfEntity() {
        return map.getEntityCounts(Grass.class);
    }

    @Override
    public void replanishMap() {
        SpawnGrass spawnGrassAction = new SpawnGrass(map);
        spawnGrassAction.performAction();
    }
}
