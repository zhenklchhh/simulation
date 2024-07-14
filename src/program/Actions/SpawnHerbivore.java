package program.Actions;

import program.Coordinates;
import program.Entities.Creatures.Herbivore;
import program.Map;

public class SpawnHerbivore extends SpawnAction<Herbivore> {
    public SpawnHerbivore(Map map){
        super(map);
        this.spawnRate =  (map.height * map.width) / 20;
    }
    @Override
    protected Herbivore spawnEntity(Coordinates coordinates) {
        return new Herbivore(coordinates);
    }
}
