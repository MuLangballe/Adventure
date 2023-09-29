import java.util.Scanner;

public class UserInterface {

    private Adventure adventureGame;
    private Scanner keyboard;

    public UserInterface (Adventure adventureGame) {
        this.adventureGame = adventureGame;
        this.keyboard = new Scanner(System.in);

    }
    // TODO: del 2 nye kommandoer: inventory, take, drop.
    // TODO: brugerfladen udvides, så man sammen med beskrivelsen af et rum, får en liste over de ting der ligger i rummet
    public void startGame() {
        adventureGame.buildMap();

        String menuChoice;

        System.out.println("Welcome to adventure game!");
        System.out.println("Your adventure starts in a forrest, looking into a cave. The entrance splits in two directions. A small flashlight appears just outside of the cave.\n");

        do {
            System.out.println("Here are your choices: \n " +
                    "Go south, north, east or west \n " +
                    "Look \n " +
                    "Help \n " +
                    "Exit \n ");

            menuChoice = keyboard.nextLine().toLowerCase();

            switch (menuChoice) {
                case "go south":
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go north":
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go east":
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go west":
                    adventureGame.moveToNextRoom(menuChoice);
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
