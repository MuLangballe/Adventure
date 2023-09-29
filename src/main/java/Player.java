public class Player {

    private Room current;

    public void setStartRoom(Room startRoom) {
        this.current = startRoom;
    }

    public String getCurrentPosition() {
        return current.getRoomName() + current.getDescription();

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
            }
