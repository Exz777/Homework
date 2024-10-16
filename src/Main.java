import animals.Animals;
import animals.valid.ListValid;
import animals.valid.NumberValid;
import data.AnimalData;
import data.MenuData;
import factory.AnimalFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animals> animalsList = new ArrayList<>();
        ListValid listValid = new ListValid();
        NumberValid numberValid = new NumberValid();
        AnimalFactory animalFactory = new AnimalFactory();

        while (true) {
            System.out.println("Команды меню: add/list/exit");
            String commStr = scanner.next().toUpperCase(Locale.ROOT).trim();

            if (!listValid.isCommValid(commStr, MenuData.values())) {
                System.out.println("Ошибка! Введите команду из списка!");
                continue;
            }
            MenuData menuData = MenuData.valueOf(commStr);
            switch (menuData) {
                case ADD:
                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Введите тип животного:\n CAT/DOG/DUCK");
                        animalTypeStr = scanner.next().toUpperCase().trim();
                        if (listValid.isCommValid(animalTypeStr, AnimalData.values())) {
                            break;
                        }
                        System.out.println("Error!!! Неверный тип животного!\n Введите из списка!");
                    }
                    Animals animals = animalFactory.create(AnimalData.valueOf(animalTypeStr));    // !!!!!!


                    System.out.println("Введите имя животного");
                    animals.setName(scanner.next());

                    System.out.println("Введите возраст животного (max. 30)");
                    animals.setAge(scanner);

                    System.out.println("Введите вес животного (max. 30)");
                    animals.setWeight(scanner);

                    while (true) {
                        System.out.println("Введите цвет животного(кирил.)");
                        String colorStr = scanner.next();

                        if (numberValid.isNumber(colorStr, Pattern.compile("[а-яА-Я]+$"))) {
                            animals.setColor(colorStr);
                            break;
                        }
                        System.out.println("Error!!! Неверный цвет животного.\n(Введите кириллицей)");
                    }
                    animalsList.add(animals);



                case LIST:
                    if (animalsList.isEmpty()) {
                        System.out.println("Здесь пока пусто");
                        continue;
                    }


                    for (Animals animal : animalsList) {
                        System.out.println(animal.toString());
                    }
                    break;

                case EXIT:
                    System.exit(0);
            }
        }
    }
}




