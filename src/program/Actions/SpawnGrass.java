package program.Actions;

import program.Coordinates;
import program.Entities.Grass;
import program.Map;


public class SpawnGrass extends SpawnAction<Grass> {
    public SpawnGrass(Map map){
        super(map);
        this.spawnRate = (map.height * map.width) / 10;
    }
    @Override
    protected Grass spawnEntity(Coordinates coordinates) {
        return new Grass(coordinates);
    }
}
