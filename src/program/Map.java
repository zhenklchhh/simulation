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
    private java.util.Map<Class<? extends Entity>, Integer> entitiesCounter = new HashMap<>();
    public Map(int width, int height){
        this.width = width;
        this.height = height;
        entitiesCounter.putAll(java.util.Map.of(Grass.class, 0, Rock.class, 0, Tree.class, 0,
                Predator.class, 0, Herbivore.class, 0));
    }
    public void addEntity(Entity entity){
        Class<? extends Entity> entityType = entity.getClass();
        entitiesCounter.put(entityType, entitiesCounter.get(entityType) + 1);
        entities.put(entity.getCoordinates(), entity);
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
            ((Herbivore) entity).setHealth(Creature.DEAD_STATE_HP);
        }
        Class<? extends Entity> entityType = entity.getClass();
        entitiesCounter.put(entityType, entitiesCounter.get(entityType) - 1);
        entities.remove(coordinates);
    }
    public void moveEntity(Entity entity, Coordinates newCoordinates){
        entities.remove(entity.getCoordinates());
        entities.put(newCoordinates, entity);
        entity.setCoordinates(newCoordinates);
    }
    public int getEntityCounts(Class<? extends Entity> entityClass){
        return entitiesCounter.get(entityClass);
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
    public ArrayList<Coordinates> getNearCoordinates(Coordinates coordinates, int range){
        ArrayList<Coordinates> nearCoordinates = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                int newX = coordinates.x + dx * range;
                int newY = coordinates.y + dy * range;
                if (newX >= 0 && newX < this.width && newY >= 0 && newY < this.height) {
                    nearCoordinates.add(new Coordinates(newX, newY));
                }
            }
        }

        return nearCoordinates;
    }
}
