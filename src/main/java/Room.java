import java.util.ArrayList;

public class Room {
    private String roomName;
    private String description;
    private Room goNorth;
    private Room goSouth;
    private Room goWest;
    private Room goEast;
    private ArrayList<Item> items = new ArrayList<>();


    public Room (String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
    }

    public void addItem(String itemName, String itemDescription){
        items.add(new Item(itemName, itemDescription));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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
