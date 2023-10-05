public class RangedWeapon extends Weapon {

    private int remainingShots;

    public RangedWeapon(String itemName, String itemDescription, EatMessage eatMessage, EquipMessage equipMessage, int damage, int remainingShots) {
        super(itemName, itemDescription, eatMessage, equipMessage, damage);
        this.remainingShots = remainingShots;
    }


    @Override
    public AttackMessage attack() {
        // antal skud minus 1 for hvert attack
        if (remainingShots > 0) {
            remainingShots = remainingShots - 1;
            return AttackMessage.ATTACK_SUCCESFULL;

        }
        return AttackMessage.OUT_OF_AMMO;
    }

}