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
