public class RangedWeapon extends Weapon{

    private int remainingShots;

    public RangedWeapon(String itemName, String itemDescription, EatMessage eatMessage, EquipMessage equipMessage, int damage, int remainingShots){
        super(itemName, itemDescription, eatMessage, equipMessage, damage);
        this.remainingShots = remainingShots;
    }

    @Override
    public int remainingUses() {
        return super.remainingUses();
    }
}
