public class Player {

    // Startposition:
    private Room current;
    public void setStartRoom(Room startRoom) {
        this.current = startRoom;
    }

    // Metode til at flytte sig fra rum til rum:
    // TODO: ("No room in that direction"); gentages kun første gang man går forkert.
    public void moveToNextRoom(String nextRoom) {
        if (nextRoom.equalsIgnoreCase("go south")) {
            Room wantedRoom = current.getGoSouth();
            if (wantedRoom != null) {
                current = wantedRoom;
                System.out.println("you are now in " + getCurrentPosition());
            } else {
                System.out.println("No room in that direction");
            }
        } else if (nextRoom.equalsIgnoreCase("go north")) {
            if (nextRoom.equalsIgnoreCase("go north")) {
                Room wantedRoom = current.getGoNorth();
                if (wantedRoom != null) {
                    current = wantedRoom;
                    System.out.println("you are now in " + getCurrentPosition());
                } else {
                    System.out.println("No room in that direction");
                }
            } else if (nextRoom.equalsIgnoreCase("go east")) {
                if (nextRoom.equalsIgnoreCase("go east")) {
                    Room wantedRoom = current.getGoEast();
                    current = wantedRoom;
                    System.out.println("you are now in " + getCurrentPosition());
                } else {
                    System.out.println("No room in that direction");
                }

            } else if (nextRoom.equalsIgnoreCase("go west")) {
                if (nextRoom.equalsIgnoreCase("go west")) {
                    Room wantedRoom = current.getGoWest();
                    current = wantedRoom;
                    System.out.println("you are now in " + getCurrentPosition());
                } else {
                    System.out.println("No room in that direction");
                }
                current = current.getGoWest();
            }
        }

    }

    public String getCurrentPosition() {
        return current.getRoomName() + current.getDescription();



    }

}

