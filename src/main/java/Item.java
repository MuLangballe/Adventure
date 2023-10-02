public class Item {
    private String itemName;
    private String itemDescription;

    public Item(String itemName, String itemDesciption){
        this.itemName = itemName;
        this.itemDescription = itemDesciption;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
