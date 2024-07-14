package program.Entities.Creatures;


import program.Coordinates;
import program.Map;

public class Predator extends Creature {
    public Predator(){
        this.health = 2;
    }
    public Predator(Coordinates coordinates) {
        super(coordinates);
        this.health = 2;
    }
    @Override
    public void makeMove(Map map) {
        CreatureNavigator creatureNavigator = new CreatureNavigator(map);
        Coordinates nearHerbivoreCoordinates = creatureNavigator.findNearestEntityCoordinates(this.coordinates,
                Herbivore.class.getSimpleName());
        map.moveEntity(this, creatureNavigator.findOptimalNextCoordinates(this.coordinates,
                nearHerbivoreCoordinates));
    }

}
