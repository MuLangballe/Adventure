import java.util.ArrayList;

public class Player {

    private int healthPoints;

    //TODO: lave player constructor, så healthpoint kan settes.
    public int healthbar() {
        int healthPoints = 50;
        return healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }


    public EatMessage eatItem(String itemName){
        Item item = findItem(itemName);
        if (item instanceof Food){
            int healthPoints1 =  ((Food) item).getHealthPoints();
            setHealthPoints(50); //Nu virker det .. men det skal flyttes!!!!!!
            healthPoints += healthPoints1;
            removeItem(itemName);
        } else if (!(item instanceof Food)){
            return EatMessage.CANT_EAT;
        }
        else if (item == null){
            return EatMessage.NOT_FOUND;
        }
        return item.getEatReturnMessage();
    }

    public Room getCurrent() {
        return current;
    }

    private Room current;
    private ArrayList<Item> inventory = new ArrayList<>();

    public void setStartRoom(Room startRoom) {
        this.current = startRoom;
    }

    public String getCurrentPosition() {
        String temp = current.getRoomName() + current.getDescription();
        if (current.getItems() != null) {
            for (Item item : current.getItems()) {
                temp += "\n You find: " + item.getItemName() + ". " + item.getItemDescription();
            }
        }
        return temp;
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item findItem(String itemName) {
        Item item = null;
        for (Item i : inventory) {
            if (i.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                item = i;
            }
        }
        return item;
    }

    public Item removeItem(String itemName) {
        Item item = findItem(itemName);
        inventory.remove(item); //TODO: håndtering af hvis man ikke kan finde objektet
        return item;
    }

    // Health metode
    // Startværdi, fx 5 healthpoints

    // udskrive nuværende health points

    // tilføje/fjerne health via eat-metode

    // fjerne health, enemies



    public boolean moveToNextRoom(String nextRoom) {
        if (nextRoom.equalsIgnoreCase("south")) {
            Room wantedRoom = current.getGoSouth();
            if (wantedRoom != null) {
                current = wantedRoom;
                return true;
            } else {
                return false;
            }
        } else if (nextRoom.equalsIgnoreCase("north")) {
            Room wantedRoom = current.getGoNorth();
            if (wantedRoom != null) {
                current = wantedRoom;
                return true;
            } else {
                return false;
            }
        } else if (nextRoom.equalsIgnoreCase("east")) {
            Room wantedRoom = current.getGoEast();
            if (wantedRoom != null) {
                current = wantedRoom;
                return true;
            } else {
                return false;
            }
        } else if (nextRoom.equalsIgnoreCase("west")) {
            Room wantedRoom = current.getGoWest();
            if (wantedRoom != null) {
                current = wantedRoom;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
