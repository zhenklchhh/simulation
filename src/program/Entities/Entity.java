package program.Entities;

import program.Coordinates;

public abstract class Entity {
    public Coordinates coordinates;
    public Entity(){}

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
