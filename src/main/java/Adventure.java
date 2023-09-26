public class Adventure {
    private Room current;

    public void buildMap() {

        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");
        Room room4 = new Room("Room 4");
        Room room5 = new Room("Room 5");
        Room room6 = new Room("Room 6");
        Room room7 = new Room("Room 7");
        Room room8 = new Room("Room 8");
        Room room9 = new Room("Room 9");

        // Startposition:
        current = room1;

        // Directions from room 1:
        room1.setGoEast(room2);
        room1.setGoSouth(room4);

        // Directions from room 2:
        room2.setGoEast(room3);
        room2.setGoWest(room1);

        // Directions from room 3:
        room3.setGoSouth(room6);
        room3.setGoWest(room2);

        // Directions from room 4:
        room4.setGoNorth(room1);
        room4.setGoNorth(room1);

        // Directions from room 5:
        room5.setGoSouth(room8);

        // Directions from room 6:
        room6.setGoNorth(room3);
        room6.setGoSouth(room9);

        // Directions from room 7:
        room7.setGoNorth(room4);
        room7.setGoEast(room8);

        // Directions from room 8:
        room8.setGoNorth(room5);
        room8.setGoEast(room9);
        room8.setGoWest(room7);

        // Directions from room 9:
        room9.setGoNorth(room6);
        room9.setGoWest(room8);
    }

    // metode til at returne current room name
   /* public String roomDirections(String directions){
        if (directions.equals("go south")){
            return current.getGoSouth().getRoomName();
        } else if (directions.equals("go north")) {
            return current.getGoNorth().getRoomName();
        } else if (directions.equals("go east")) {
            return current.getGoEast().getRoomName();
        } else if (directions.equals("go west")) {
            return current.getGoWest().getRoomName();
        }
    }*/

    // Metode til at flytte sig fra rum til rum:
    public void moveToNextRoom(String nextRoom) {
        if (nextRoom.equalsIgnoreCase("go south")) {
            Room wantedRoom = current.getGoSouth();
            if (wantedRoom != null) {
                current = wantedRoom;
            } else {
                System.out.println("No room in that direction");
            }
        } else if (nextRoom.equalsIgnoreCase("go north")) {
            if (nextRoom.equalsIgnoreCase("go north")) {
                Room wantedRoom = current.getGoNorth();
                if (wantedRoom != null) {
                    current = wantedRoom;
                } else {
                    System.out.println("No room in that direction");
                }
            } else if (nextRoom.equalsIgnoreCase("go east")) {
                if (nextRoom.equalsIgnoreCase("go east")) {
                    Room wantedRoom = current.getGoEast();
                    current = wantedRoom;
                } else {
                    System.out.println("No room in that direction");
                }

            } else if (nextRoom.equalsIgnoreCase("go west")) {
                if (nextRoom.equalsIgnoreCase("go west")) {
                    Room wantedRoom = current.getGoWest();
                    current = wantedRoom;
                } else {
                    System.out.println("No room in that direction");
                }
                current = current.getGoWest();
            }
        }

    }

    public String getCurrentPosition() {
        return current.getRoomName();
    }

}
