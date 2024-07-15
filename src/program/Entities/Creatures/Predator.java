package program.Entities.Creatures;


import program.Coordinates;
import program.Map;

public class Predator extends Creature {
    public Predator(Coordinates coordinates) {
        super(coordinates);
        this.setHealth(1);
        this.setSpeed(1);
    }
    @Override
    public void makeMove(Map map) {
        CreatureNavigator creatureNavigator = new CreatureNavigator(map);
        Coordinates nearHerbivoreCoordinates = creatureNavigator.findNearestEntityCoordinates(this.getCoordinates(),
                Herbivore.class.getSimpleName(), this.getSpeed());
        map.moveEntity(this, creatureNavigator.findOptimalNextCoordinates(this.getCoordinates(),
                nearHerbivoreCoordinates, this.getSpeed()));
    }

}
