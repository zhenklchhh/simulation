package program.Entities.Creatures;

import program.Coordinates;
import program.Map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CreatureNavigator {
    private Map map;
    public CreatureNavigator(Map map) {
        this.map = map;
    }
    public Coordinates findOptimalNextCoordinates(Coordinates currentCoordinates, Coordinates targetCoordinates, int speed){
        int dx = targetCoordinates.x - currentCoordinates.x;
        int dy = targetCoordinates.y - currentCoordinates.y;
        int moveX = Integer.compare(dx, 0) * speed;
        int moveY = Integer.compare(dy, 0) * speed;
        Coordinates nextCoordinates = new Coordinates(currentCoordinates.x + moveX,
                currentCoordinates.y + moveY);
        if(nextCoordinates.equals(targetCoordinates)){
            map.removeEntity(targetCoordinates);
            return nextCoordinates;
        }
        int[][] directions = getDirections(moveX,moveY);

        for (int[] direction : directions) {
            nextCoordinates = new Coordinates(currentCoordinates.x + direction[0],
                    currentCoordinates.y + direction[1]);
            if (!map.hasEntityAtCoordinates(nextCoordinates)) {
                break;
            }
        }
        return nextCoordinates;
    }
    public Coordinates findNearestEntityCoordinates(Coordinates currentCoordinates, String entityClassName, int speed){
        Coordinates resultCoordinates = null;
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(currentCoordinates);
        HashSet<Coordinates> usedCoordinates = new HashSet<>();
        while(!queue.isEmpty()){
            Coordinates coordinates = queue.poll();
            if(!usedCoordinates.contains(coordinates)){
                if(checkIfNeededEntityAtCoordinates(coordinates, entityClassName)){
                    resultCoordinates = coordinates;
                    break;
                }
                ArrayList<Coordinates> nearCoordinates = map.getNearCoordinates(coordinates, speed);
                for(Coordinates nearCoordinate : nearCoordinates){
                    queue.add(nearCoordinate);
                }
                usedCoordinates.add(coordinates);
            }
        }
        return resultCoordinates;
    }
    private boolean checkIfNeededEntityAtCoordinates(Coordinates coordinates, String entityClassName){
        if(map.hasEntityAtCoordinates(coordinates)){
            String entityAtCoordinatesClassName = map.getEntity(coordinates).getClass().getSimpleName();
            if(entityClassName.equals(entityAtCoordinatesClassName)){
                return true;
            }
        }
        return false;
    }
    public int[][] getDirections(int moveX, int moveY){
        if(moveX == 0){
            return new int[][]{{1, moveY}, {-1, moveY},
                    {1, 0}, {-1, 0},
                    {1, -moveY}, {-1, -moveY}, {0, -moveY}};
        }else if(moveY == 0){
            return new int[][]{{moveX, 1}, {moveX, 0},
                    {0, 1}, {0, -1},
                    {-moveX, 1}, {-moveX, -1}, {-moveX, 0}};
        }else{
            return new int[][]{{moveX, 0}, {0, moveY},
            {-moveX, moveY}, {moveX, -moveY},
            {-moveX, 0}, {0, -moveY}, {-moveX, -moveY}};
        }
    }
}
