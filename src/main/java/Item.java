public class Item {
    private String itemName;
    private String itemDescription;
    private EatMessage eatReturnMessage;

    public Item(String itemName, String itemDesciption, EatMessage eatReturnMessage){
        this.itemName = itemName;
        this.itemDescription = itemDesciption;
        this.eatReturnMessage = eatReturnMessage;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public EatMessage getEatReturnMessage() {
        return eatReturnMessage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
