package program.Actions;

import program.Coordinates;
import program.Entities.Creatures.Predator;
import program.Map;

public class SpawnPredator extends SpawnAction<Predator>{
    public SpawnPredator(Map map) {
        super(map);
        this.spawnRate = (map.height * map.width) / 40;
    }

    @Override
    protected Predator spawnEntity(Coordinates coordinates) {
        return new Predator(coordinates);
    }
}
