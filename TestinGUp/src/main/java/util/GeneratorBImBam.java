package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneratorBImBam {
    public static List<String> carModels =
            new ArrayList<>(Arrays.asList("Lada", "Kia", "Hyundai", "Toyota", "Volkswagen", "BMW", "Mercedes-Benz", "Audi"));
    static String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static String generateStateNumber() {

        Random random = new Random();

        return letters[random.nextInt(letters.length)] +
                numbers[random.nextInt(numbers.length)] +
                numbers[random.nextInt(numbers.length)] +
                numbers[random.nextInt(numbers.length)] +
                letters[random.nextInt(letters.length)] +
                letters[random.nextInt(letters.length)];
    }

    public static String generateMarkCar(){


        Random random = new Random();
        return carModels.get(random.nextInt(carModels.size()));
    }
}
