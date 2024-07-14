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
        System.out.println("Ход: " + simulation.turnCount);
        java.util.Map<Class<? extends Entity>, Integer> entityInstenseCounts = simulation.getMap().getEntityCounts();
        System.out.println("Количество хищников: " + entityInstenseCounts.get(Predator.class));
        System.out.println("Количество травоядных: " + entityInstenseCounts.get(Herbivore.class));
        System.out.println("Количество травы: " + entityInstenseCounts.get(Grass.class) + "\n");
    }
}
