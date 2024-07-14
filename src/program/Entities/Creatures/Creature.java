package program.Entities.Creatures;

import program.Coordinates;
import program.Entities.Entity;
import program.Map;

public abstract class Creature extends Entity {
    public int health;
    public Creature () {}
    public Creature(Coordinates coordinates) {
        super(coordinates);
    }
    public abstract void makeMove(Map map);
}
