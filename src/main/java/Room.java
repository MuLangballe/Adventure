import java.util.ArrayList;

public class Room {
    private String roomName;
    private String description;
    private Room goNorth;
    private Room goSouth;
    private Room goWest;
    private Room goEast;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public Room (String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }


    public void addItem(Item item){
        items.add(item);
    }

    public Item findItemInRoom(String itemName){
        Item item = null;
        for (Item i : items){
            if (i.getItemName().toLowerCase().contains(itemName.toLowerCase())){
                item = i;
            }
        }
        return item;
    }
    public Item removeItemFromRoom(String itemName){
        Item item = findItemInRoom(itemName);
        items.remove(item); //TODO: håndtering af hvis man ikke kan finde objektet
        return item;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public String getRoomName() {
        return roomName;
    }

    public Room getGoNorth() {
        return goNorth;
    }

    public void setGoNorth(Room goNorth) {
        this.goNorth = goNorth;
    }

    public Room getGoSouth() {
        return goSouth;
    }

    public void setGoSouth(Room goSouth) {
        this.goSouth = goSouth;
    }

    public Room getGoWest() {
        return goWest;
    }

    public void setGoWest(Room goWest) {
        this.goWest = goWest;
    }

    public Room getGoEast() {
        return goEast;
    }

    public void setGoEast(Room goEast) {
        this.goEast = goEast;
    }

    public String getDescription() {
        return description;
    }
}
