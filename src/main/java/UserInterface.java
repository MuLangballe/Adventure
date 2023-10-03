import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Adventure ADVENTURE_GAME;
    private final Scanner KEYBOARD;

    public UserInterface (Adventure ADVENTURE_GAME) {
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
                     Help\s
                     Exit\s
                    \s""");

            menuChoice = KEYBOARD.nextLine().toLowerCase();
             String[] words = menuChoice.split(" ");

             switch (words[0]){
                 case "take":
                     ADVENTURE_GAME.takeItem(words[1]);
                     break;
                 case "move":
                     ADVENTURE_GAME.moveToNextRoom(words[1]);
                     if (ADVENTURE_GAME.moveToNextRoom(words[1])){
                         System.out.println("you are now in " + ADVENTURE_GAME.getCurrentPosition());
                     } else {
                         System.out.println("No room in that direction.");
                     }
                     break;
                 case "drop":
                     ADVENTURE_GAME.dropItem(words[1]);
                 case "look":
                     ADVENTURE_GAME.getCurrentPosition();
                     break;
                 case "inventory":
                     ArrayList<Item> items = ADVENTURE_GAME.getPlayerInventory();
                     for (Item i : items){
                         System.out.println(i);
                     }
                     break;
                 case "help":
                     System.out.println("go google");
                     break;

             }

           /* switch (menuChoice) {

                //String[] words = menuChoice.split(" ");
                // split
                case "go south":
                case "south":
                case "s":
                   // String[] sentence = menuChoice.split(" ");
                   // if (sentence.length > 1) {
                       // menuChoice = sentence[1];
                   // }
                    adventureGame.moveToNextRoom("south");
                    // brugerdialog. lav movetonextroom til boolean - og lav ui ud fra true false.
                    break;
                case "go north":
                case "north":
                case "n":
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go east":
                case "east":
                case "e":
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go west":
                case "west":
                case "w":
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "inv":
                case "inven":
                case "inventory":
                    // TODO: Metode til at udskrive players items liste.
                    break;
                case "take":
                case "take item":
                    // TODO: Metode til at add til players items liste
                    adventureGame.takeItem(words[1]);
                    break;
                case "drop":
                case "drop item":
                    // TODO: Metode til at remove fra players items liste - evt. add tilbage til current room?
                    break;
                case "look":
                    System.out.println("You are now in: " + adventureGame.getCurrentPosition());
                    break;
                case "help":
                    System.out.println("Use google!");
                    break;
            } */

        } while (!menuChoice.equals("exit"));
    }
}

