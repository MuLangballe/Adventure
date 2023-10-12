import java.util.ArrayList;

public class Player {
    private int healthPoints;
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Weapon currentWeapon;
    // slet?: private Enemy currentEnemy;

    public Player(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    // TODO Omskriv fra string til ?
    public String getCurrentPosition() {
        String currentPositionAndRoomItems = currentRoom.getRoomName() + currentRoom.getDescription();
        if (currentRoom.getEnemies() != null) {
            for (Enemy enemies : currentRoom.getEnemies()) {
                currentPositionAndRoomItems += "\nYou see: " + enemies.getEnemyName() /* + ". It has a: " + enemies.getEnemyWeapon() */ + ". Health: " + enemies.getEnemyHealth();
            }
        }
        if (currentRoom.getItems() != null) {
            for (Item item : currentRoom.getItems()) {
                currentPositionAndRoomItems += "\nYou find: " + item.getItemName() + ". " + item.getItemDescription();
            }
        }
        return currentPositionAndRoomItems;
    }

    public EquipMessage equipItem(String itemName) {
        Item itemToEquip = findItemInInventory(itemName);
        if (itemToEquip == null) {
            return EquipMessage.WEAPON_NOT_FOUND;
        }
        if (itemToEquip instanceof Weapon) {
            //  inventory.remove(item); fjerner våbnet
            currentWeapon = (Weapon) itemToEquip;
            return EquipMessage.EQUIP;

            // TODO: Måske tilføje parameter på Player så man kun kan "Equippe" ét våben til spilleren
        }
        return EquipMessage.NOT_A_WEAPON;
    }


    public boolean takeItem(String itemName) {
        Item itemToPickUp = currentRoom.removeItemFromRoom(itemName);
        if (itemToPickUp != null) {
            inventory.add(itemToPickUp);

            if (currentWeapon == null) {
                this.equipItem(itemName);
            }
            return true;
        }
        return false;
    }


    public boolean dropItem(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item != null) {
            inventory.remove(item);
            currentRoom.addItem(item);
            return true;
        }
        return false;
    }

    public EatMessage eatItem(String itemName) {
        Item itemToEat = findItemInInventory(itemName);

        if (itemToEat == null) {
            return EatMessage.NOT_FOUND;
        }

        if (itemToEat instanceof Food) {
            int healthPoints1 = ((Food) itemToEat).getHealthPoints();
            healthPoints += healthPoints1;
            removeItemFromInventory(itemName);
            return EatMessage.EAT;
        }
        return EatMessage.CANT_EAT;
    }

    // TODO: tilføje metode til at bruge eatItem uden at adde til inventory først.

    public AttackMessage playerAttackEnemy() {
        if (!currentRoom.getEnemies().isEmpty()) {
            Enemy enemy = currentRoom.getEnemies().get(0);
            if (currentWeapon != null) {
                int attackResult = enemy.getEnemyHealth() - currentWeapon.getDamage();
                enemy.setEnemyHealth(attackResult);
                return currentWeapon.attack();
            }
            return AttackMessage.NO_WEAPON_EQUIPPED;
        } else {
            return AttackMessage.NO_ENEMY_PRESENT;
        }
    }


    public Enemy getCurrentEnemy() {
        return currentRoom.getEnemies().get(0);
    }

    // TODO: hvornår skal enemy angribe? Evt. Attack-sequence mode.
    public AttackMessage enemyAttackPlayer(Player player) {
        Enemy enemy = currentRoom.getEnemies().get(0);
        int enemyAttackResult = this.getHealthPoints() - enemy.getEnemyWeapon().getDamage();
        player.setHealthPoints(enemyAttackResult);

        return AttackMessage.ENEMY_ATTACKS;
    }


    // TODO: Player dead + enemy dead
   /* public boolean isPlayerDead(Player player) {
        if (healthPoints <= 0) {
            //game over: start over eller exit?
            return true;
        } else {
            return false;
        }
    }*/

    public Item findItemInInventory(String itemName) {
        Item item = null;
        for (Item i : inventory) {
            if (i.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                item = i;
            }
        }
        return item;
    }

    public Item removeItemFromInventory(String itemName) {
        Item item = findItemInInventory(itemName);
        inventory.remove(item);
        return item;
    }


    public boolean moveToNextRoom(String nextRoom) {
        if (nextRoom.equalsIgnoreCase("south") || nextRoom.equalsIgnoreCase("s")) {
            Room wantedRoom = currentRoom.getGoSouth();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                return true;
            } else {
                return false;
            }
        } else if (nextRoom.equalsIgnoreCase("north") || nextRoom.equalsIgnoreCase("n")) {
            Room wantedRoom = currentRoom.getGoNorth();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                return true;
            } else {
                return false;
            }
        } else if (nextRoom.equalsIgnoreCase("east")|| nextRoom.equalsIgnoreCase("e")) {
            Room wantedRoom = currentRoom.getGoEast();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                return true;
            } else {
                return false;
            }
        } else if (nextRoom.equalsIgnoreCase("west") || nextRoom.equalsIgnoreCase("w")) {
            Room wantedRoom = currentRoom.getGoWest();
            if (wantedRoom != null) {
                currentRoom = wantedRoom;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
