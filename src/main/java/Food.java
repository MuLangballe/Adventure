public class Food extends Item{
    public int getHealthPoints() {
        return healthPoints;
    }

    private int healthPoints;

    public Food (String itemName, String itemDesciption, EatMessage eatReturnMessage, EquipMessage equipReturnMessage, int healthPoints){
        super(itemName, itemDesciption, eatReturnMessage, equipReturnMessage);
        this.healthPoints = healthPoints;
    }
}
