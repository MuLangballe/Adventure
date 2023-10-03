import java.util.ArrayList;

public class Adventure {
    private Map map;
    private Player player;


    public Adventure() {
        this.map = new Map();
        this.player = new Player();
    }

    public void buildMap() {
        map.buildMap();
        player.setStartRoom(map.getStartRoom());
    }

    public boolean moveToNextRoom(String nextRoom) {
        return player.moveToNextRoom(nextRoom);
    }

    public String getCurrentPosition() {
        return player.getCurrentPosition();
    }

    public void takeItem(String menuChoice) {
        Item item = player.getCurrent().removeItem(menuChoice);
        player.addToInventory(item);
    }

    public ArrayList<Item> getPlayerInventory() {
        return player.getInventory();
    }

        public void dropItem(String menuChoice) {
        Item item = player.removeItem(menuChoice);
        player.getCurrent().addItem(item);
    }
}