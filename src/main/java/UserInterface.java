import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Adventure ADVENTURE_GAME;
    private final Scanner KEYBOARD;
    private Player player;

    public UserInterface(Adventure ADVENTURE_GAME) {
        this.ADVENTURE_GAME = ADVENTURE_GAME;
        this.KEYBOARD = new Scanner(System.in);
        this.player = ADVENTURE_GAME.getPlayer();
    }

    public void startGame() {
        ADVENTURE_GAME.buildMap();

        String menuChoice;

        System.out.println("Welcome to adventure game!");
        System.out.println("Your adventure starts in a forrest, looking into a cave. The entrance splits in two directions. A small flashlight appears just outside of the cave.");

        do {
            System.out.println("""
                    \nHere are your choices:\s
                     Go south, north, east or west (g/s/n/e/w)\s
                     Inventory (inv or i)\s
                     Take item (t)\s
                     Drop item (d)\s
                     Look (l)\s
                     Eat\s
                     Health (h)\s
                     Equip (eq)\s
                     Attack (a)\s
                     Help\s
                     Exit\s
                    \s""");

            menuChoice = KEYBOARD.nextLine().toLowerCase();
            String[] words = menuChoice.split("\\s+");

            switch (words[0]) {
                case "take":
                case "t":

                    if (words.length >= 2) {
                        boolean takenItem = ADVENTURE_GAME.takeItem(words[1]);
                        if (takenItem) {
                            System.out.println("The item was added to you inventory.");
                        } else {
                            System.out.println("There's no item like this in the room.");
                        }
                    } else {
                        System.out.println("Which item do you want to take?");
                        ADVENTURE_GAME.takeItem(words[0]);
                        String item = KEYBOARD.nextLine();
                        if (ADVENTURE_GAME.takeItem(item)) {
                            System.out.println(item + " was added to you inventory.");
                        } else {
                            System.out.println("There's no item like this in the room.");
                        }
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
                case "south":
                case "s":
                case "north":
                case "n":
                case "west":
                case "w":
                case "east":
                case "e":
                    if (ADVENTURE_GAME.moveToNextRoom(words[0])) {
                        System.out.println("you are now in " + ADVENTURE_GAME.getCurrentPosition());
                    } else {
                        System.out.println("No room in that direction.");
                    }
                    break;
                case "drop":
                case "d":

                    if (words.length >= 2) {

                        boolean droppedItem = ADVENTURE_GAME.dropItem(words[1]);
                        if (droppedItem) {
                            System.out.println("The item was left in the room.");
                        } else {
                            System.out.println("There's no item like this in your inventory");
                        }

                    } else {
                        System.out.println("Which item do you want to drop?");
                        ADVENTURE_GAME.dropItem(words[0]);
                        String item = KEYBOARD.nextLine();
                        if (ADVENTURE_GAME.dropItem(item)) {
                            System.out.println(item + " was left in the room.");
                        } else {
                            System.out.println("There's no item like this in your inventory.");
                        }
                    }

                    break;
                case "look":
                case "l":
                    System.out.println("you are now in " + ADVENTURE_GAME.getCurrentPosition());
                    break;


                case "eat":

                    if (words.length >= 2) {
                        EatMessage eatMessage = ADVENTURE_GAME.eatMessage(words[1]);
                        switch (eatMessage) {
                            case EAT -> System.out.println("Yuumm!");
                            case CANT_EAT -> System.out.println("no no no. You can't eat that! You crazy.");
                            case NOT_FOUND -> System.out.println("Can't find the requested item.");
                        }

                    } else {
                        System.out.println("Which item from your inventory do you want to eat?");
                        String item = KEYBOARD.nextLine();
                        EatMessage eatMessage = ADVENTURE_GAME.eatMessage(item);
                        switch (eatMessage) {
                            case EAT -> System.out.println("Yuumm!");
                            case CANT_EAT -> System.out.println("no no no. You can't eat that! You crazy.");
                            case NOT_FOUND -> System.out.println("Can't find the requested item.");
                        }
                    }
                    break;
                case "inventory":
                case "inv":
                case "i":
                    ArrayList<Item> items = ADVENTURE_GAME.getPlayerInventory();
                    if (items.isEmpty()) {
                        System.out.println("Your backpack is empty!");
                    } else {
                        for (Item item : items) {
                            System.out.println(item);
                        }
                    }
                    break;
                case "health":
                case "h":
                    System.out.println("Healthpoint balance: " + ADVENTURE_GAME.getHealthPoints());
                    if (ADVENTURE_GAME.getHealthPoints() >= 50) {
                        System.out.println(ADVENTURE_GAME.getHealthPoints() + " You look healthy. Keep up the good work!");
                    } else if (ADVENTURE_GAME.getHealthPoints() < 50) {
                        System.out.println(ADVENTURE_GAME.getHealthPoints() + " Uf! You might need some food to get that health up!");
                    }
                    break;
                case "equip":
                case "eq":

                    if (words.length >= 2) {

                        EquipMessage equipMessage = ADVENTURE_GAME.equipMessage(words[1]);
                        switch (equipMessage) {
                            case EQUIP -> System.out.println("Equipped!");
                            case NOT_A_WEAPON -> System.out.println("Ooops. that is not useful for a weapon.");
                            case WEAPON_NOT_FOUND -> System.out.println("Weapon not found!");
                        }

                    } else {

                        System.out.println("Which item do you want to equip?");
                        String item = KEYBOARD.nextLine();
                        EquipMessage equipMessage = ADVENTURE_GAME.equipMessage(item);
                        switch (equipMessage) {
                            case EQUIP -> System.out.println("Equipped!");
                            case NOT_A_WEAPON -> System.out.println("Ooops. that is not useful for a weapon.");
                            case WEAPON_NOT_FOUND -> System.out.println("Weapon not found!");
                        }
                    }
                    break;
                case "attack":
                case "a":
                    AttackMessage attackMessage = ADVENTURE_GAME.playerAttackEnemy();

                    switch (attackMessage) {
                        case OUT_OF_AMMO -> {
                            System.out.println("OH NO! Out of ammo!");
                            Enemy enemy = ADVENTURE_GAME.getPlayer().getCurrentEnemy();
                            AttackMessage message = ADVENTURE_GAME.enemyAttackPlayer(ADVENTURE_GAME.getPlayer());
                            System.out.println("The enemy attacks you. Your health is now: " + ADVENTURE_GAME.getHealthPoints());

                            if (player.getHealthPoints() <= 0) {
                                System.out.println("You're dead. GAME OVER!");
                                System.exit(0);
                            }
                        }
                        case NO_WEAPON_EQUIPPED -> {
                            System.out.println("No weapon equipped!");
                            ADVENTURE_GAME.getPlayer().getCurrentEnemy();
                            ADVENTURE_GAME.enemyAttackPlayer(ADVENTURE_GAME.getPlayer());
                            System.out.println("The enemy attacks you. Your health is now: " + ADVENTURE_GAME.getHealthPoints());

                            if (player.getHealthPoints() <= 0) {
                                System.out.println("You're dead. GAME OVER!");
                                System.exit(0);
                            }
                        }
                        case ATTACK_SUCCESSFUL -> {

                            // handle enemy state
                            Enemy enemy = ADVENTURE_GAME.getPlayer().getCurrentEnemy();

                            if (enemy.getEnemyHealth() <= 0) {
                                System.out.println("Attack succesfull enemy is dead");

                                Item droppedEnemyItem = enemy.getEnemyWeapon();
                                player.getCurrentRoom().addItem(droppedEnemyItem);

                                continue;
                            }

                            System.out.println("Attack successful! Enemies health: " + ADVENTURE_GAME.getPlayer().getCurrentEnemy().getEnemyHealth());

                            // handle player state
                            ADVENTURE_GAME.enemyAttackPlayer(ADVENTURE_GAME.getPlayer());
                            System.out.println("The enemy attacks you. Your health is now: " + ADVENTURE_GAME.getHealthPoints());

                            if (ADVENTURE_GAME.getHealthPoints() <= 0) {
                                System.out.println("You're dead. GAME OVER!");
                                System.exit(0);
                            }
                        }

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

