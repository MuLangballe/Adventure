import java.util.ArrayList;

public class Player {

    private Room current;
    //private ArrayList<Item> inventory = new ArrayList<>();

    //Metode: take item
    //Metode: drop item

    public void setStartRoom(Room startRoom) {
        this.current = startRoom;
    }

    public String getCurrentPosition() {
        String temp = current.getRoomName() + current.getDescription();
        if (current.getItems() != null) {
            for (Item item : current.getItems()) {
                temp +="\n You find: " + item.getItemName() + ". " + item.getItemDescription();
            }
        }
        return temp;
    }

    public void moveToNextRoom(String nextRoom) {
        if (nextRoom.equalsIgnoreCase("go south")) {
            Room wantedRoom = current.getGoSouth();
            if (wantedRoom != null) {
                current = wantedRoom;
                System.out.println("you are now in " + getCurrentPosition());
            } else {
                System.out.println("No room in that direction.");
            }
        } else if (nextRoom.equalsIgnoreCase("go north")) {
                Room wantedRoom = current.getGoNorth();
                if (wantedRoom != null) {
                    current = wantedRoom;
                    System.out.println("you are now in " + getCurrentPosition());
                } else {
                    System.out.println("No room in that direction.");
                }
        } else if (nextRoom.equalsIgnoreCase("go east")) {
                    Room wantedRoom = current.getGoEast();
                    if (wantedRoom != null) {
                        current = wantedRoom;
                        System.out.println("you are now in " + getCurrentPosition());
                    } else {
                        System.out.println("No room in that direction.");
                    }
        } else if (nextRoom.equalsIgnoreCase("go west")) {
                        Room wantedRoom = current.getGoWest();
                        if (wantedRoom != null) {
                            current = wantedRoom;
                            System.out.println("you are now in " + getCurrentPosition());
                        } else {
                            System.out.println("No room in that direction.");
                        }
                    }
                }
                /* Metode fra fronter:
                public boolean takeItem(String itemName){
        Item pickupFromRoom = current.removeItem(itemName);
        if (pickupFromRoom != null) {
            inventory.add(pickupFromRoom);
            return true;
        }
        return false;
                }*/
            }
