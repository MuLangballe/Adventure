import java.util.ArrayList;

public class Adventure {
    private Map map;
    private Player player;
    // slet?: private Enemy enemy;


    public Adventure() {
        this.map = new Map();
        this.player = new Player(50);
    }

    public void buildMap() {
        map.buildMap();
        player.setCurrentRoom(map.getStartRoom());
    }

    public Player getPlayer(){
        return player;
    }

    public boolean moveToNextRoom(String nextRoom) {
        return player.moveToNextRoom(nextRoom);
    }

    public String getCurrentPosition() {
        return player.getCurrentPosition();
    }

    public boolean takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public boolean dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public ArrayList<Item> getPlayerInventory() {
        return player.getInventory();
    }

    public EatMessage eatMessage(String itemName){
        return player.eatItem(itemName);
    }

    public int getHealthPoints(){
        return player.getHealthPoints();
    }

    public EquipMessage equipMessage(String itemName){
        return player.equipItem(itemName);
    }

    public AttackMessage playerAttackEnemy(){
        return player.playerAttackEnemy();
    }

    public AttackMessage enemyAttackPlayer(Player player) {
        return player.enemyAttackPlayer(player);
    }

    /*  public boolean isPlayerDead(Player player) {
        return player.isPlayerDead(player);
    } */

}