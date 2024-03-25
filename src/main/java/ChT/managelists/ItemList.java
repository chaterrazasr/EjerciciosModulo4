package ChT.managelists;

import java.util.LinkedList;


public class ItemList {

    LinkedList<Item> items = new LinkedList<Item>();
    public ItemList() {

    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void printItems() {
        for (Item item: items) {
            System.out.println(item.getContent());
        }
    }
}
