package ChT.managelists;

import java.util.LinkedList;

public class PagingCommands {

    private ItemList itemList = new ItemList();
    Pagination pagination = new Pagination();

    public PagingCommands() {

    }

    public void PagingCommands(ItemList itemList) {
        this.itemList = itemList;
    }

    public void nextPage() {
        pagination.paginateItems(itemList, pagination.getNumberOfPages());
    }



}
