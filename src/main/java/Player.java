import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

 /*   public Player() {
        inventory.add(new Item("kuki", "kuki"));
    }*/

    public void setStartRoom(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public String getCurrentPositionAndItems() {
        String currentRoomNameDescriptionAndItems = currentRoom.getRoomName() + currentRoom.getDescription();
        if (currentRoom.getItems() != null) {
            for (Item item : currentRoom.getItems()) {
                currentRoomNameDescriptionAndItems += "\nYou see: " + item.getItemName() + ". " + item.getItemDescription();
            }
        }
        return currentRoomNameDescriptionAndItems;
    }

    public void moveToNextRoom(String nextRoom) {

        //TODO flyt brugerdialog til UI omskriv til at returnere boolean
        if (nextRoom.equalsIgnoreCase("south")) {
            Room wantedRoom = currentRoom.getGoSouth();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                System.out.println("you are now in " + getCurrentPositionAndItems());
            } else {
                System.out.println("No room in that direction.");
            }
        } else if (nextRoom.equalsIgnoreCase("north")) {
            Room wantedRoom = currentRoom.getGoNorth();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                System.out.println("you are now in " + getCurrentPositionAndItems());
            } else {
                System.out.println("No room in that direction.");
            }
        } else if (nextRoom.equalsIgnoreCase("east")) {
            Room wantedRoom = currentRoom.getGoEast();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                System.out.println("you are now in " + getCurrentPositionAndItems());
            } else {
                System.out.println("No room in that direction.");
            }
        } else if (nextRoom.equalsIgnoreCase("west")) {
            Room wantedRoom = currentRoom.getGoWest();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                System.out.println("you are now in " + getCurrentPositionAndItems());
            } else {
                System.out.println("No room in that direction.");
            }
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean takeItem(String itemName) {
        Item pickupFromRoom = currentRoom.removeItem(itemName);
        if (pickupFromRoom != null) {
            inventory.add(pickupFromRoom);
            return true;
        }
        return false;
    }

    public boolean dropItem(String itemName) {
        // tjek om item findes i inventory
        for (Item inventoryItem : inventory) {
            if (inventoryItem.getItemName().equalsIgnoreCase(itemName)) {
                // hvis den findes, fjern fra inventory og add til rummet:
                inventory.remove(itemName);
                currentRoom.addItem(inventoryItem);
                return true;
            }
        }
            // hvis den ikke findes i inventory:
                return false;
    }
}

