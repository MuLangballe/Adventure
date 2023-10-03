public class Food extends Item{
    public int getHealthPoints() {
        return healthPoints;
    }

    private int healthPoints;

    public Food (String itemName, String itemDesciption, EatMessage eatReturnMessage, int healthPoints){
        super(itemName, itemDesciption, eatReturnMessage);
        this.healthPoints = healthPoints;
    }

    // Ved ikke om jeg skal lave det i food klassen. men den kan altid rykkes.


}
