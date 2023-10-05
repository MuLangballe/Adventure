public abstract class Weapon extends Item{

    private int damage;

    public Weapon(String itemName, String itemDescription, EatMessage eatMessage, EquipMessage equipReturnMessage, int damage) {
        super(itemName, itemDescription, eatMessage, equipReturnMessage);
        this.damage = damage;
    }

    public int remainingUses() {
        return remainingUses();
    }


    public abstract AttackMessage attack();

}
