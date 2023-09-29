public class Map {

    Room startRoom;

    public void buildMap() {

        Room room1 = new Room("Room 1", "description");
        Room room2 = new Room("Room 2", "description");
        Room room3 = new Room("Room 3", "description");
        Room room4 = new Room("Room 4", "description");
        Room room5 = new Room("Room 5", "description");
        Room room6 = new Room("Room 6", "description");
        Room room7 = new Room("Room 7", "description");
        Room room8 = new Room("Room 8", "description");
        Room room9 = new Room("Room 9", "description");

        startRoom = room1;


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

    public Room getStartRoom() {
        return startRoom;
    }


}