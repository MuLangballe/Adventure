import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Adventure ADVENTURE_GAME;
    private final Scanner KEYBOARD;

    public UserInterface(Adventure ADVENTURE_GAME) {
        this.ADVENTURE_GAME = ADVENTURE_GAME;
        this.KEYBOARD = new Scanner(System.in);
    }

    public void startGame() {
        ADVENTURE_GAME.buildMap();

        String menuChoice;

        System.out.println("Welcome to adventure game!");
        System.out.println("Your adventure starts in a forrest, looking into a cave. The entrance splits in two directions. A small flashlight appears just outside of the cave.");

        do {
            System.out.println("""
                    \nHere are your choices:\s
                     Go south, north, east or west (g)\s
                     Inventory (inv or i)\s
                     Take item (t)\s
                     Drop item (d)\s
                     Look (l)\s
                     Eat\s
                     Health (h)\s
                     Equip (e)\s
                     Attack (a)\s
                     Help\s
                     Exit\s
                    \s""");

            menuChoice = KEYBOARD.nextLine().toLowerCase();
            String[] words = menuChoice.split("\\s+");
           /* if (words.length == 1){
                menuChoice = words[1];
            }*/

            switch (words[0]) {
                case "take":
                case "t":
                    boolean takenItem = ADVENTURE_GAME.takeItem(words[1]);
                    if (takenItem) {
                        System.out.println("The item was added to you inventory.");
                    } else {
                        System.out.println("There's no item like this in the room.");
                    }
                    break;
                case "go":
                case "g":
                    if (ADVENTURE_GAME.moveToNextRoom(words[1])) {
                        System.out.println("you are now in " + ADVENTURE_GAME.getCurrentPosition());
                    } else {
                        System.out.println("No room in that direction.");
                    }
                    break;
                case "drop":
                case "d":
                    boolean droppedItem = ADVENTURE_GAME.dropItem(words[1]);
                    if (droppedItem) {
                        System.out.println("The item was left in the room.");
                    } else {
                        System.out.println("There's no item like this in your inventory");
                    }

                    break;
                case "look":
                case "l":
                    System.out.println("you are now in " + ADVENTURE_GAME.getCurrentPosition());
                    break;
                case "eat":
                    EatMessage eatMessage = ADVENTURE_GAME.eatMessage(words[1]);
                    switch (eatMessage) {
                        case EAT -> System.out.println("Yuumm!");
                        case CANT_EAT -> System.out.println("no no no. You can't eat that! You crazy.");
                        case NOT_FOUND -> System.out.println("Can't find the requested item.");
                    }
                    break;
                case "inventory":
                case "inv":
                case "i":
                    ArrayList<Item> items = ADVENTURE_GAME.getPlayerInventory();
                    if(items.isEmpty()) {
                        System.out.println("Your backpack is empty!");
                    }
                    else {
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    }
                    break;
                case "health":
                case "h":
                    System.out.println("Healthpoint balance: " + ADVENTURE_GAME.getHealthPoints());
                    if (ADVENTURE_GAME.getHealthPoints() >= 50) {
                        System.out.println("You look healthy. Keep up the good work!");
                    }
                    break;
                case "equip":
                case "e":
                    EquipMessage equipMessage = ADVENTURE_GAME.equipMessage(words[1]);
                    switch (equipMessage){
                        case EQUIP -> System.out.println("Equipped!");
                        case NOT_A_WEAPON -> System.out.println("Ooops. that is not useful for a weapon.");
                        case WEAPON_NOT_FOUND -> System.out.println("Weapon not found!");
                    }
                    break;
                case "attack":
                case "a": //Do - while til attack sekvens?
                    AttackMessage attackMessage = ADVENTURE_GAME.attackMessage(words[1]);
                    switch (attackMessage){
                        case ATTACK_SUCCESFULL -> System.out.println("Attack succesfull! Good job!");
                        case OUT_OF_AMMO -> System.out.println("OH NO! Out of ammo!");
                        case NO_WEAPON_EQUIPPED -> System.out.println("No weapon equipped!");
                        case NO_ENEMY_PRESENT -> System.out.println("No enemy present");
                    }
                    break;
                case "help":
                    System.out.println("go google");
                    break;
                default:
                    System.out.println("What? i don't understand that gibberish. Try again!");

            }
        }
        while (!menuChoice.equals("exit"));
    }
}

