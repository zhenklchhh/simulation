package program;

import program.Actions.*;

import java.util.ArrayList;
import java.util.List;


public class Simulation {
    public volatile boolean runnable;
    private final Map map = new Map(20,20);
    private final ConsoleLog consoleLog = new ConsoleLog(this);
    private final MapConsoleRender mapConsoleRender = new MapConsoleRender(map);
    private final List<Action> initActions = new ArrayList<>();
    private final List<Action> turnActions = new ArrayList<>();
    public int turnCount = 0;
    public void initSimulation(){
        initActions();
        for(Action initAction : initActions){
            initAction.performAction();
        }
        mapConsoleRender.render();
        consoleLog.printInfoAboutSimulation();
    }
    public void nextTurn(){
        for(Action turnAction : turnActions){
            turnAction.performAction();
        }
        mapConsoleRender.render();
        turnCount++;
        consoleLog.printInfoAboutSimulation();
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            if(Thread.currentThread().isInterrupted()){
                runnable = false;
            }else {
                throw new RuntimeException(e);
            }
        }
    }
    public void startSimulation(){
        runnable = true;
        Thread simulationThread = new Thread(() -> {
            while(runnable){
                nextTurn();
            }
        });
        simulationThread.start();
    }
    public void pauseSimulation(){
        runnable = false;
        Thread.currentThread().interrupt();
    }
    public Map getMap(){
        return map;
    }
    public void initActions(){
        initActions.add(new SpawnGrass(map));
        initActions.add(new SpawnHerbivore(map));
        initActions.add(new SpawnRock(map));
        initActions.add(new SpawnPredator(map));
        initActions.add(new SpawnTree(map));
        turnActions.add(new MoveAllCreaturesAction(map));
        turnActions.add(new ReplanishGrass(map));
        turnActions.add(new ReplanishHerbivore(map));
    }
}
