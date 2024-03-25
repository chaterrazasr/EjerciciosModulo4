package ChT.managelists;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Pagination pagination = new Pagination();
        Item item;
        ItemList itemList = new ItemList();

        Scanner scanner = new Scanner(System.in);

        String content = "";

        int option = 0;


        while (option != 8) {
            System.out.println("\n__________________Menu______________________");
            subMenu();
            System.out.println("_________________________________________");
            System.out.println("Number of Pages: " + pagination.getCurrentNumberOfPages());
            System.out.println("_________________________________________");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            System.out.println("_________________________________________\n");
            switch (option) {

                case 1:
                    System.out.println("Add a Item");
                    System.out.println("Enter the number of items you want to add to the list: ");

                    pagination.setAmountOfPages(scanner.nextInt());

                    for (int i = 0; i < pagination.getAmountOfPages(); i++) {
                        System.out.print("Enter the content ["+(i+1)+"]: ");
                        content = scanner.next();
                        item = new Item(content);
                        itemList.addItem(item);

                    }

                    pagination.setNumberOfPages(1);
                    pagination.setItemList(itemList);
                    pagination.paginateItems(itemList, pagination.getNumberOfPages());
                    break;

                case 2:
                    System.out.println("Show first page");

                    if (isEmpty(itemList)) {break;}

                    pagination.setNumberOfPages(1);
                    pagination.firstPage(itemList);
                    break;
                case 3:
                    System.out.println("Show last page");

                    if (isEmpty(itemList)) {break;}

                    pagination.setNumberOfPages(pagination.getCurrentNumberOfPages());
                    pagination.lastPage(itemList);
                    break;

                case 4:
                    System.out.println("Show next page");

                    if (isEmpty(itemList)) {break;}
                    pagination.setNumberOfPages(pagination.getNumberOfPages()+1);


                    if(pagination.getNumberOfPages() > pagination.getCurrentNumberOfPages()) {
                        System.out.println("There are no more pages");
                        pagination.setNumberOfPages(pagination.getNumberOfPages()-1);
                        break;
                    }
                    pagination.nextPage(itemList);
                    break;

                case 5:
                    System.out.println("Show previous page");
                    System.out.println("---------------------------------");

                    if (isEmpty(itemList)) {break;}
                    pagination.setNumberOfPages(pagination.getNumberOfPages()-1);

                    if (pagination.getNumberOfPages() < 1){
                        System.out.println("There are no more pages");
                        pagination.setNumberOfPages(pagination.getNumberOfPages()+1);
                        break;
                    }
                    pagination.previousPage(itemList);
                    break;

                case 6:
                    System.out.println("Show a specific page");

                    System.out.println("--------------["+(itemList.getItems().size() == 0 ? 0:1)+
                                    " - "+pagination.getCurrentNumberOfPages()+"]---------------");

                    if (isEmpty(itemList)) {break;}

                    System.out.print("Enter the number of pages: ");
                    pagination.setNumberOfPages(scanner.nextInt());

                    if (pagination.getNumberOfPages() < 1 || pagination.getNumberOfPages() > pagination.getCurrentNumberOfPages()) {
                        System.out.println("Invalid page");
                        System.out.println("The valid pages are from 1 to "+pagination.getCurrentNumberOfPages());
                        break;
                    }

                    System.out.println("---------[Size Page: "+pagination.getRequestPageSize()+"]-----------");
                    pagination.paginateItems(itemList, pagination.getNumberOfPages());
                    System.out.println("---------------------------------");
                    break;

                case 7:
                    System.out.println("Set page size");
                    System.out.print("Enter the page size: ");
                    pagination.setRequestPageSize(scanner.nextInt());
                    pagination.setNumberOfPages(1);
                    pagination.paginateItems(itemList, pagination.getNumberOfPages());
                    break;

                case 8:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }

    }

    public static boolean isEmpty(ItemList itemList) {
        if (itemList.getItems().size() == 0) {
            System.out.println("The list is empty");
            return true;
        }
        return false;
    }

    public static void subMenu() {
        System.out.println("1. Add a element");
        System.out.println("2. Show first page");
        System.out.println("3. Show last page");
        System.out.println("4. Show next page");
        System.out.println("5. Show previous page");
        System.out.println("6. Show a specific page");
        System.out.println("7. Set page size");
        System.out.println("8. Exit");
    }


}
