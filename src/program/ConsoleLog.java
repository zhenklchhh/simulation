package program;

import program.Entities.Creatures.Herbivore;
import program.Entities.Creatures.Predator;
import program.Entities.Entity;
import program.Entities.Grass;

public class ConsoleLog {
    private Simulation simulation;
    public ConsoleLog(Simulation simulation){
        this.simulation = simulation;
    }
    public void printInfoAboutSimulation(){
        Map map = simulation.getMap();
        System.out.println("Ход: " + simulation.turnCount);;
        System.out.println("Количество хищников: " + map.getEntityCounts(Predator.class));
        System.out.println("Количество травоядных: " + map.getEntityCounts(Herbivore.class));
        System.out.println("Количество травы: " + map.getEntityCounts(Grass.class));
    }
}
