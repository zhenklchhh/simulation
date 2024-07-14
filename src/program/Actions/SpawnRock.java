package program.Actions;

import program.Coordinates;
import program.Entities.Rock;
import program.Map;

public class SpawnRock extends SpawnAction<Rock>{
    public SpawnRock(Map map) {
        super(map);
        this.spawnRate = (map.height * map.width) / 20;
    }

    @Override
    protected Rock spawnEntity(Coordinates coordinates) {
        return new Rock(coordinates);
    }
}
