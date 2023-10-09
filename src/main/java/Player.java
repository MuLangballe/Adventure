import java.util.ArrayList;

public class Player {
    private int healthPoints;
    private Room current;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Weapon currentWeapon;

    public Player(int healthPoints){
        this.healthPoints = healthPoints;
    }

    public boolean isPlayerDead(Player player){
        if (healthPoints <= 0){
            //game over: start over eller exit?
            return true;
        } else {
            return false;
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public boolean takeItem(String itemName) {
        Item pickupFromRoom = current.removeItemFromRoom(itemName);
        if (pickupFromRoom != null) {
            inventory.add(pickupFromRoom);
            return true;
        }
        return false;
    }

    public boolean dropItem(String itemName) {
        Item item = findItemInInventory(itemName);
        // tjek om item findes i inventory
            if (item != null) {
                // hvis den findes, fjern fra inventory og add til rummet:
                inventory.remove(item);
                current.addItem(item);
                return true;
            }
        // hvis den ikke findes i inventory:
        return false;
    }

    public EatMessage eatItem(String itemName){
        Item item = findItemInInventory(itemName);
        if (item instanceof Food){
            int healthPoints1 =  ((Food) item).getHealthPoints();
            healthPoints += healthPoints1;
            removeItemFromInventory(itemName);
            return EatMessage.EAT;
        } else if (!(item instanceof Food)){
            return EatMessage.CANT_EAT;
        }
        else if (item == null){
            return EatMessage.NOT_FOUND;
        }
        return item.getEatReturnMessage();
    }

    // Evt. tilføje metode til at bruge eatItem uden at adde til inventory først.

    public EquipMessage equipItem(String itemName){
        Item item = findItemInInventory(itemName);
        if (item instanceof Weapon){
          //  inventory.remove(item); fjerner våbnet
            currentWeapon = (Weapon) item;
            return EquipMessage.EQUIP;

            // Måske tilføje parameter på Player så man kan "Equippe" ét våben til spilleren
        } else if (!(item instanceof Weapon)){
            return EquipMessage.NOT_A_WEAPON;
        }
        else if (item == null){
            return EquipMessage.WEAPON_NOT_FOUND;
        }
        return item.getEquipReturnMessage();
    }

    public AttackMessage attack(){
        if(currentWeapon != null){
           return currentWeapon.attack();
        }
        return AttackMessage.NO_WEAPON_EQUIPPED;
    }


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

    /*public void addToInventory(Item item) {
        inventory.add(item);
    }*/

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item findItemInInventory(String itemName) {
        Item item = null;
        for (Item i : inventory) {
            if (i.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                item = i;
            }
        }
        return item;
    }

    public Item removeItemFromInventory(String itemName) {
        Item item = findItemInInventory(itemName);
        inventory.remove(item);
        return item;
    }


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
