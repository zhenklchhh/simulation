package program;

import program.Entities.Creatures.Creature;
import program.Entities.Creatures.Herbivore;
import program.Entities.Creatures.Predator;
import program.Entities.Entity;
import program.Entities.Grass;
import program.Entities.Rock;
import program.Entities.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Map {
    public int width;
    public int height;
    private HashMap<Coordinates, Entity> entities = new HashMap<>();
    private java.util.Map<Class<? extends Entity>, Integer> entityIntenseCounts = new HashMap<>();
    public Map(int width, int height){
        this.width = width;
        this.height = height;
        entityIntenseCounts.putAll(java.util.Map.of(Grass.class, 0, Rock.class, 0, Tree.class, 0,
                Predator.class, 0, Herbivore.class, 0));
    }
    public void addEntity(Entity entity){
        Class<? extends Entity> entityType = entity.getClass();
        entityIntenseCounts.put(entityType, entityIntenseCounts.get(entityType) + 1);
        entities.put(entity.coordinates, entity);
    }
    public boolean hasEntityAtCoordinates(Coordinates coordinates){
        return entities.containsKey(coordinates);
    }
    public Coordinates getEmptyCoordinates(){
        Random random = new Random();
        Coordinates coordinates = new Coordinates(random.nextInt(this.width), random.nextInt(this.height));
        while(hasEntityAtCoordinates(coordinates)){
            coordinates.x = random.nextInt(this.width);
            coordinates.y = random.nextInt(this.height);
        }
        return coordinates;
    }
    public void removeEntity(Coordinates coordinates){
        Entity entity = this.getEntity(coordinates);
        if(entity instanceof Herbivore){
            ((Herbivore) entity).health = 0;
        }
        Class<? extends Entity> entityType = entity.getClass();
        entityIntenseCounts.put(entityType, entityIntenseCounts.get(entityType) - 1);
        entities.remove(coordinates);
    }
    public void moveEntity(Entity entity, Coordinates newCoordinates){
        entities.remove(entity.coordinates);
        entities.put(newCoordinates, entity);
        entity.coordinates = newCoordinates;
    }
    public java.util.Map<Class<? extends Entity>, Integer> getEntityCounts(){
        return entityIntenseCounts;
    }
    public Entity getEntity(Coordinates coordinates){
        return entities.get(coordinates);
    }
    public ArrayList<Creature> getAllCreatures(){
        ArrayList<Creature> creatures = new ArrayList<>();
        for(Entity entity : entities.values()){
            if(entity instanceof Creature){
                creatures.add((Creature) entity);
            }
        }
        return creatures;
    }
    public ArrayList<Coordinates> getNearCoordinates(Coordinates coordinates){
        ArrayList<Coordinates> nearCoordinates = new ArrayList<>();
        if(coordinates.x > 0){
            nearCoordinates.add(new Coordinates(coordinates.x - 1, coordinates.y));
        }
        if(coordinates.y > 0){
            nearCoordinates.add(new Coordinates(coordinates.x, coordinates.y - 1));
        }
        if(coordinates.x > 0 && coordinates.y > 0){
            nearCoordinates.add(new Coordinates(coordinates.x - 1, coordinates.y - 1));
        }
        if(coordinates.x < this.width - 1){
            nearCoordinates.add(new Coordinates(coordinates.x + 1, coordinates.y));
        }
        if(coordinates.y < this.height - 1){
            nearCoordinates.add(new Coordinates(coordinates.x, coordinates.y + 1));
        }
        if(coordinates.x < this.width - 1 && coordinates.y < this.height - 1){
            nearCoordinates.add(new Coordinates(coordinates.x + 1, coordinates.y + 1));
        }
        if(coordinates.x > 0 && coordinates.y < this.height - 1){
            nearCoordinates.add(new Coordinates(coordinates.x - 1, coordinates.y + 1));
        }
        if(coordinates.x < this.width - 1 && coordinates.y > 0){
            nearCoordinates.add(new Coordinates(coordinates.x + 1, coordinates.y - 1));
        }
        return nearCoordinates;
    }
}
