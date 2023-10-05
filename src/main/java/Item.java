public class Item {
    private String itemName;
    private String itemDescription;
    private EatMessage eatReturnMessage;
    private EquipMessage equipReturnMessage;

    public Item(String itemName, String itemDesciption, EatMessage eatReturnMessage, EquipMessage equipReturnMessage){
        this.itemName = itemName;
        this.itemDescription = itemDesciption;
        this.eatReturnMessage = eatReturnMessage;
        this.equipReturnMessage = equipReturnMessage;
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

    public EquipMessage getEquipReturnMessage(){
        return equipReturnMessage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
