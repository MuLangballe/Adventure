import java.util.ArrayList;

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
    return player.getCurrentPositionAndItems();
}

public boolean takeItem(String itemName) {
    return player.takeItem(itemName);
}

public boolean dropItem(String itemName) {
    return player.dropItem(itemName);
}
public ArrayList<Item> inventoryList() {
    return player.getInventory();
}

}



// metode til at returne current room directions... hvis vi vil ha det ;)
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