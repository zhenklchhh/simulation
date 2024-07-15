package program.Entities;

import program.Coordinates;

public abstract class Entity {
    Coordinates coordinates;
    public Entity(){}

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
