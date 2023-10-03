import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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
        System.out.println("Your adventure starts in a forrest, looking into a cave. The entrance splits in two directions. A small flashlight appears just outside of the cave.\n");

        do {
            System.out.println("""
                    Here are your choices:\s
                     Go south, north, east or west\s
                     Inventory\s
                     Take item\s
                     Drop item\s
                     Look\s
                     Eat\s
                     Health\s
                     Help\s
                     Exit\s
                    \s""");

            menuChoice = KEYBOARD.nextLine().toLowerCase();
            String[] words = menuChoice.split(" ");

            switch (words[0]) {
                case "take":
                    ADVENTURE_GAME.takeItem(words[1]);
                    break;
                case "move":
                    if (ADVENTURE_GAME.moveToNextRoom(words[1])) {
                        System.out.println("you are now in " + ADVENTURE_GAME.getCurrentPosition());
                    } else {
                        System.out.println("No room in that direction.");
                    }
                    break;
                case "drop":
                    ADVENTURE_GAME.dropItem(words[1]);
                    break;
                case "look":
                    System.out.println("you are now in " + ADVENTURE_GAME.getCurrentPosition());
                    break;
                case "eat":
                    EatMessage eatMessage = ADVENTURE_GAME.eatMessage(words[1]);
                    switch (eatMessage) {
                        case EAT -> System.out.println("Yuumm!");
                        case CANT_EAT -> System.out.println("no no no. You can't eat that! You crazy.");
                        case NOT_FOUND -> System.out.println("Can't find the requested item.");
                        }
                        case "inventory":
                            ArrayList<Item> items = ADVENTURE_GAME.getPlayerInventory();
                            for (Item i : items) {
                                System.out.println(i);
                            }
                            break;
                        case "health":
                            System.out.println("Healthpoint balance: " + ADVENTURE_GAME.healthbar());
                            if (ADVENTURE_GAME.healthbar() >= 50) {
                                System.out.println("You look healthy. Keep up the good work!");
                            }
                            break;
                        case "help":
                            System.out.println("go google");
                            break;

                    }
            }
            while (!menuChoice.equals("exit")) ;
        }
    }

