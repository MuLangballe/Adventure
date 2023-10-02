import java.util.Scanner;

public class UserInterface {

    private Adventure adventureGame;
    private Scanner keyboard;

    public UserInterface (Adventure adventureGame) {
        this.adventureGame = adventureGame;
        this.keyboard = new Scanner(System.in);

    }

    public void startGame() {
        adventureGame.buildMap();

        String menuChoice;

        System.out.println("Welcome to adventure game!");
        System.out.println("Your adventure starts in a forrest, looking into a cave. The entrance splits in two directions. A small flashlight appears just outside of the cave.\n");

        do {
            System.out.println("Here are your choices: \n " +
                    "Go south, north, east or west \n " +
                    "Inventory \n " +
                    "Take item \n " +
                    "Drop item \n " +
                    "Look \n " +
                    "Help \n " +
                    "Exit \n ");

            menuChoice = keyboard.nextLine().toLowerCase();

            switch (menuChoice) {

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
                    // Metode til at udskrive players items liste.
                    break;
                case "take":
                case "take item":
                    // Metode til at add til players items liste
                    break;
                case "drop":
                case "drop item":
                    // Metode til at remove fra players items liste - evt. add tilbage til current room?
                    break;
                case "look":
                    System.out.println("You are now in: " + adventureGame.getCurrentPosition());
                    break;
                case "help":
                    System.out.println("Use google!");
                    break;
            }

        } while (!menuChoice.equals("exit"));
    }
}

// 1. Current position:
// Room objekt, med navn og beskrivelse.


// 2. Udskrive hvilke retninger man kan bevæge sig i fra current position/Room object.

// 3. Metode til at flytte sig fra ét rum til et andet (set):


// 4. Gentage processen
