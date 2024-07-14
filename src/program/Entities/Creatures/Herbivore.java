package program.Entities.Creatures;

import program.Coordinates;
import program.Entities.Grass;
import program.Map;

public class Herbivore extends Creature {
    public Herbivore(){
        this.health = 1;
    }
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        this.health = 1;
    }
    public boolean isEaten(){
        return health == 0;
    }
    @Override
    public void makeMove(Map map) {
        CreatureNavigator creatureNavigator = new CreatureNavigator(map);
        Coordinates nearGrassCoordinates = creatureNavigator.findNearestEntityCoordinates(this.coordinates,
                Grass.class.getSimpleName());
        map.moveEntity(this, creatureNavigator.findOptimalNextCoordinates(this.coordinates,
                nearGrassCoordinates));
    }
}
