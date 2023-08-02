package repositoryImplementation;

import java.util.List;
import java.util.Scanner;

public class EntityHandler<T> implements ElementOperations {
    private List<T> entityList;
    private Scanner scanner;
    private MenuUtils.ElementCreator<T> creator;
    private Menu menu;

    public EntityHandler(List<T> entityList, Scanner scanner, MenuUtils.ElementCreator<T> creator, Menu menu) {
        this.entityList = entityList;
        this.scanner = scanner;
        this.creator = creator;
        this.menu = menu;
    }


    public boolean handleEntityOperations(String entityName) {
        String entityOption;
        do {
            System.out.println("\n----- " + entityName + " Operations -----");
            System.out.println("1. Save " + entityName);
            System.out.println("2. Count " + entityName + "s");
            System.out.println("3. Find " + entityName + " by Index");
            System.out.println("0. Back to Main Menu");
            System.out.println("-----------------------------");

            entityOption = getMenuOption();

            switch (entityOption) {
                case "1" -> createAndSaveElement();
                case "2" -> countEntitiesAndStock(entityName);
                case "3" -> findEntityByIndex(entityName);
                case "0" -> {
                    return true; // Volver al menú principal
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (!entityOption.equals("0"));

        return false;
    }

    private void countEntitiesAndStock(String entityName) {
        int count = entityList.size();
        System.out.println("Number of " + entityName + "s: " + count);

        if (entityList.size() > 0 && entityList.get(0) instanceof Product) {
            int totalStock = calculateTotalStock();
            System.out.println("Total stock: " + totalStock);
        }
    }



    private String getMenuOption() {
        while (true) {
            System.out.print("Enter option: ");
            String input = scanner.nextLine();

            if (isValidOption(input)) {
                return input;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    private boolean isValidOption(String input) {

        try {
            int option = Integer.parseInt(input);
            return option >= 0 && option <= 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public  void createAndSaveElement() {
        T newElement = creator.create(scanner);
        if (newElement != null) {
            entityList.add(newElement);
            System.out.println("Entity saved successfully.");
        } else {
            System.out.println("Error creating entity.");
        }
    }



    public  int calculateTotalStock() {
        int totalStock = 0;
        for (T entity : entityList) {
            totalStock += ((Product) entity).stock();
        }
        return totalStock;
    }

    public  void findEntityByIndex(String entityName) {
        System.out.print("Enter index: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < entityList.size()) {
            System.out.println(entityName + " at index " + (index + 1) + ": " + entityList.get(index));
        } else {
            System.out.println(entityName + " not found at index " + (index + 1));
        }
    }
}

