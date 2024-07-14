package program.Actions;

import program.Entities.Creatures.Creature;
import program.Map;

public class MoveAllCreaturesAction extends Action {

    public MoveAllCreaturesAction(Map map) {
        super(map);
    }

    @Override
    public void performAction() {
        for(Creature creature : map.getAllCreatures()){
            if(creature.health != 0){
                creature.makeMove(map);
            }
        }
    }
}
