package ChT.managelists;

import java.util.LinkedList;

public class Pagination {
    private ItemList itemList = new ItemList();
    private int currentNumberOfPage = 0;
    private int currentIndex = 0;
    private int requestPageSize = 3;
    private int numberOfPages = 1;
    private int amountOfPages = 0;

    public Pagination() {

    }

    // Get the current index
    public int getCurrentIndex() {
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        //k 0  1  2  3  4  5  6  7  8  9
        // rP = 3 y nOP = 1 => (rP * nOp) - rP = 3*1 - 3 = 0
        // rP = 3 y nOP = 2 => (rP * nOp) - rP = 3*2 - 3 = 3
        //return (requestPageSize * numberOfPages) - requestPageSize;
        return (getRequestPageSize() * getNumberOfPages()) - getRequestPageSize();
    }


    //number of items to review in the items list
    private int itemsToGoThrough(int requestPageSize, int numberOfPages) {
        return requestPageSize*numberOfPages;
    }

    // paginate items in the list of items
    public void paginateItems(ItemList items, int numberOfPages) {

        int currentIndex = getCurrentIndex();
        int totalItemsToGoThrough = itemsToGoThrough(requestPageSize, numberOfPages);

        for (int i = 0; i < items.getItems().size(); i++) {
            if (i + 1 == numberOfPages) {

                System.out.println("\n---------------------------------------------------");
                System.out.println("---------[Page: " +(i + 1) + " of "+getCurrentNumberOfPages()+"]-----------");

                printItems(items, currentIndex, totalItemsToGoThrough);
                return;
            }
        }
    }


    // print items
    private void printItems(ItemList items, int currentIndex, int totalTogo) {
        for (int k = currentIndex; k < totalTogo; k++) {
            if (k < items.getItems().size()) {
                System.out.println(items.getItems().get(k).getContent());
            }
        }
    }

   // commands
    public void firstPage(ItemList itemList) {
        paginateItems(itemList, getNumberOfPages());

    }

    public void lastPage(ItemList itemList) {
        paginateItems(itemList, getNumberOfPages());
    }
    public void nextPage(ItemList itemList) {
        paginateItems(itemList, getNumberOfPages());

    }

    public void previousPage(ItemList itemList) {
        paginateItems(itemList, getNumberOfPages());
    }


    // setters and getters

    /*public int getCurrentNumberOfPages() {
        int size = itemList.getItems().size();
        return (itemList.getItems().size() >= 1 && itemList.getItems().size() < getRequestPageSize() ? 1 :
                (int) Math.ceil((double) itemList.getItems().size() / getRequestPageSize()));
    }*/
    public int getCurrentNumberOfPages() {
        int size = itemList.getItems().size();
        double requestPageSize = (double) size / getRequestPageSize();
        int ceil = (int) Math.ceil(requestPageSize);
        return (size >= 1 && size < getRequestPageSize() ? 1 : ceil);
    }

    public void setCurrentNumberOfPage(int currentNumberOfPage) {
        this.currentNumberOfPage = currentNumberOfPage;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getRequestPageSize() {
        return requestPageSize;
    }

    public void setRequestPageSize(int requestPageSize) {
        this.requestPageSize = requestPageSize;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

}
