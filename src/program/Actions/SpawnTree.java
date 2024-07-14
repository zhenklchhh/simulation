package program.Actions;

import program.Coordinates;
import program.Entities.Tree;
import program.Map;

public class SpawnTree extends SpawnAction<Tree>{
    public SpawnTree(Map map) {
        super(map);
        this.spawnRate = (map.height * map.width) / 20;
    }

    @Override
    protected Tree spawnEntity(Coordinates coordinates) {
        return new Tree(coordinates);
    }
}
