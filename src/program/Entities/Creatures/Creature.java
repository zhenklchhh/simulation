package program.Entities.Creatures;

import program.Coordinates;
import program.Entities.Entity;
import program.Map;

public abstract class Creature extends Entity {
    private int health;
    private int speed;
    public static int DEAD_STATE_HP = 0;
    public Creature(Coordinates coordinates) {
        super(coordinates);
    }
    public boolean isDead(){
        return health == 0;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void makeMove(Map map);
}
