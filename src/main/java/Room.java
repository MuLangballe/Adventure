public class Room {
    private String roomName;
    private String description;
    private Room goNorth;
    private Room goSouth;
    private Room goWest;
    private Room goEast;

    // private String beskrivelse;
    // Skal klassen indeholde et ArrayList til at håndtere hvilke retninger man kan bevæge sig i fra det pågældende rum? - Nej

    public Room (String roomName) {
        this.roomName = roomName;
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
