public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String itemName, String itemDescription, EatMessage eatMessage, EquipMessage equipReturnMessage, int damage){
        super(itemName, itemDescription, eatMessage, equipReturnMessage, damage);

    }

    @Override
    public AttackMessage attack(){
        return AttackMessage.ATTACK_SUCCESFULL;
    }
}
