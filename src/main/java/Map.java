public class Map {

    Room startRoom;

    public void buildMap() {

        Room room1 = new Room("the cave entrance. ", "You are standing in a forrest, looking into a cave. The entrance splits in two directions. A small flashlight appears just outside of the cave.");
        Room room2 = new Room("the clay cave. ", "You are standing in a typical cave-like room with clay walls. There are roots coming down from the ceiling.");
        Room room3 = new Room("the moist cave. ", "You entered a moist room with a lot of colorful fungi.");
        Room room4 = new Room("the drip cave. ", "You hear a drip as you enter the room. A small hole in the ceiling let's the moonshine in. Another drip. A dark and mysterious shadow approaches you.");
        Room room5 = new Room("the diamond cave. ", "You go through the small and narrow hole in the north wall... at first the darkness is overwhelming. So you turn on your flashlight, and is almost blinded by something shining. You discover the whole cave is covered in diamonds!");
        Room room6 = new Room("the prison room. ", "This room has thick stonewalls and floors. You notice some broken chains on the floor, and some broken barricades in front of the rooms entrances.");
        Room room7 = new Room("the narrow cave. ", "This room is very narrow and full of cobwebs and spiders.");
        Room room8 = new Room("the cellar room. ", "The room has a stonewall, and looks like a cellar room. There is a picture of a strange creature on the north wall. Looks like there's a hole behind it...");
        Room room9 = new Room("the very very dark cave. ", "You entered a very dark room, it is hard to see anything. Whoops! You fall. There must be a hole in the floor! You try to get up - and feels something just beside your right hand. it's sharp. Sort of feels like a sword?");

        startRoom = room1;


        // Directions+items from room 1:
        room1.setGoEast(room2);
        room1.setGoSouth(room4);
        room1.addItem(new Item("Flashlight", "it's small but effective.", EatMessage.CANT_EAT, EquipMessage.NOT_A_WEAPON));
        room1.addItem(new MeleeWeapon("Knife", "small rusty knife", EatMessage.CANT_EAT, EquipMessage.EQUIP, 50));
        room1.addEnemy(new Enemy("Testmonster", new MeleeWeapon("Testvåben", "Test", EatMessage.CANT_EAT, EquipMessage.EQUIP, 50), 50));

        // Directions+items from room 2:
        room2.setGoEast(room3);
        room2.setGoWest(room1);
        room2.addItem(new Food("Apple", "beautiful red apple", EatMessage.EAT, EquipMessage.NOT_A_WEAPON, 15));

        // Directions+items from room 3:
        room3.setGoSouth(room6);
        room3.setGoWest(room2);
        room3.addItem(new Food ("Luminous mushroom", "You don't know what to use it for, but it's pretty.", EatMessage.EAT, EquipMessage.NOT_A_WEAPON, -20));

        // Directions+items from room 4:
        room4.setGoNorth(room1);
        room4.setGoSouth(room7);
        room4.addItem(new RangedWeapon("Bow", "old wooden bow", EatMessage.CANT_EAT,EquipMessage.EQUIP, 10, 5));

        // Directions+items from room 5:
        room5.setGoSouth(room8);
        room5.addItem(new Item ("Diamonds", "Shiny!", EatMessage.CANT_EAT, EquipMessage.NOT_A_WEAPON));

        // Directions+items from room 6:
        room6.setGoNorth(room3);
        room6.setGoSouth(room9);

        // Directions+items from room 7:
        room7.setGoNorth(room4);
        room7.setGoEast(room8);

        // Directions+items from room 8:
        room8.setGoNorth(room5);
        room8.setGoEast(room9);
        room8.setGoWest(room7);

        // Directions+items from room 9:
        room9.setGoNorth(room6);
        room9.setGoWest(room8);
        room9.addItem(new MeleeWeapon("Sword", "Sharp silver sword with A LOT of diamonds", EatMessage.CANT_EAT, EquipMessage.EQUIP, 30));

    }

    public Room getStartRoom() {
        return startRoom;
    }


}