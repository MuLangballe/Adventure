import java.util.Scanner;

public class UserInterface {

    public void startGame(){

    // Opgave 1: Start med at lave brugerfladen + kommandoer i switch-case, med String håndtering

        System.out.println("Welcome to adventure game!");
        System.out.println("Your adventure starts in room 1. ");
        do {
            System.out.println("Here are your choices: \n " +
                    "Go south, north, east or west \n " +
                    "Look \n " +
                            "Help \n " +
                            "Exit \n ");

            menuChoice = keyboard.nextLine().toLowerCase();


            switch (menuChoice) {
                case "go south" :
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go north" :
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go east" :
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "go west" :
                    adventureGame.moveToNextRoom(menuChoice);
                    break;
                case "look" :
                    System.out.println("You are now in: " + adventureGame.getCurrentPosition());
                    break;
                case "help" :
                    System.out.println("Use google!");
                    break;
            }

        } while (!menuChoice.equals("exit"));


            // 1. Current position:
            // Room objekt, med navn og beskrivelse.


            // 2. Udskrive hvilke retninger man kan bevæge sig i fra current position/Room object.

            // 3. Metode til at flytte sig fra ét rum til et andet (set):


            // 4. Gentage processen


}
}