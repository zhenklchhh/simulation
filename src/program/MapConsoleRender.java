package program;

import program.Entities.Entity;

public class MapConsoleRender {
    private Map map;
    public MapConsoleRender(Map map){
        this.map = map;
    }
    public void render(){
        for(int i = map.height - 1; i >= 0; i--){
            for(int j = 0; j < map.width; j++){
                Coordinates coordinates = new Coordinates(j,i);
                Entity entityAtCoordinates = map.getEntity(coordinates);
                if(entityAtCoordinates == null){
                    System.out.print(".. ");
                    continue;
                }
                switch(entityAtCoordinates.getClass().getSimpleName()){
                    case "Herbivore" -> System.out.print("\uD83D\uDC07 ");
                    case "Predator" -> System.out.print("\uD83D\uDC3A ");
                    case "Rock" -> System.out.print("O ");
                    case "Grass" -> System.out.print("\uD83C\uDF3F ");
                    case "Tree" -> System.out.print("\uD83C\uDF33 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
