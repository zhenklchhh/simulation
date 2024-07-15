package program.Entities.Creatures;

import program.Coordinates;
import program.Entities.Grass;
import program.Map;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
        this.setHealth(1);
        this.setSpeed(1);
    }
    @Override
    public void makeMove(Map map) {
        CreatureNavigator creatureNavigator = new CreatureNavigator(map);
        Coordinates nearGrassCoordinates = creatureNavigator.findNearestEntityCoordinates(this.getCoordinates(),
                Grass.class.getSimpleName(), this.getSpeed());
        map.moveEntity(this, creatureNavigator.findOptimalNextCoordinates(this.getCoordinates(),
                nearGrassCoordinates, this.getSpeed()));
    }
}
