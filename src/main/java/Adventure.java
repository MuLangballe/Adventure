public class Adventure {
private Map map;
private Player player;

public Adventure(){
    this.map = new Map();
    this.player = new Player();

}
public void buildMap() {
    map.buildMap();
    player.setStartRoom(map.getStartRoom());
}

public void moveToNextRoom(String nextRoom){
    player.moveToNextRoom(nextRoom);
}

public String getCurrentPosition(){
    return player.getCurrentPosition();
}

}



// metode til at returne current room name
   /* public String roomDirections(String directions){
        if (directions.equals("go south")){
            return current.getGoSouth().getRoomName();
        } else if (directions.equals("go north")) {
            return current.getGoNorth().getRoomName();
        } else if (directions.equals("go east")) {
            return current.getGoEast().getRoomName();
        } else if (directions.equals("go west")) {
            return current.getGoWest().getRoomName();
        }
    }*/