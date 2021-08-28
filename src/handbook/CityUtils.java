package handbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CityUtils {

     static List<City> loadCities(String filePath) throws IllegalArgumentException {
        if (!Files.exists(Paths.get(filePath))) {
            throw new IllegalArgumentException("File not found or wrong path");
        }

        List<City> cityList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Scanner scanner = new Scanner(fis)) {

            while (scanner.hasNext()) {
                Optional<City> note = parseCity(scanner.nextLine());
                note.ifPresent(cityList::add);
            }
        } catch (IOException ioe) {
        }

        return cityList;
    }

    private static Optional<City> parseCity(String note) {
        String[] params = note.split(";");
        String name = params[1];
        String region = params[2];
        String distinct = params[3];
        int population = Integer.parseInt(params[4]);
        String foundation = "";
        if(params.length == 6) foundation = params[5];



        City city = new City(name, region, distinct, population, foundation);
        return Optional.of(city);
    }
}