package handbook;


import java.util.*;
import java.util.stream.Collectors;

public class Handbook {

    private static String maxPopulationV2(List<City> cities){
        City[] citiesArray = new City[cities.size()];
        cities.toArray(citiesArray);

        int maxPopul = 0;
        int indexOfMaxPopul = 0;

        for (int i = 0; i < citiesArray.length; i++) {
            if(citiesArray[i].getPopulation() > maxPopul){
                maxPopul = citiesArray[i].getPopulation();
                indexOfMaxPopul = i;
            }
        }

        return String.format("[%d] = %d", indexOfMaxPopul, maxPopul);
    }

    private static String maxPopulation(List<City> cities){
        Optional<City> max = cities.stream().max(Comparator.comparingInt(City::getPopulation));

        City maxPopCity = max.get();
        String result = String.format("[%d] = %d", cities.indexOf(maxPopCity), maxPopCity.getPopulation());

        return result;
    }

    private static List<City> sortByName(List<City> cities){
        return cities.stream().sorted(Comparator.comparing(city -> city.getName().toLowerCase())).collect(Collectors.toList());
    }

    private static List<City> sortByDistinctAndName(List<City> cities){
        return cities.stream().sorted(Comparator.comparing(City::getDistinct).thenComparing(City::getName)).collect(Collectors.toList());
    }

    private static void countOfCitiesInRegions(List<City> cities){
        cities = cities.stream().sorted(Comparator.comparing(City::getRegion)).collect(Collectors.toList());
        String currentRegion = cities.get(0).getRegion();
        int cityCount = 0;
        for (int i = 0; i < cities.size(); i++) {
            if(!cities.get(i).getRegion().equals(currentRegion)){
                System.out.printf("%s - %d\n",currentRegion, cityCount);
                cityCount = 1;
                currentRegion = cities.get(i).getRegion();
            }
            else cityCount++;
        }

    }

    public static void main(String[] args) {

        List<City> cityList = null;

        try{
            cityList =  CityUtils.loadCities("/home/anton/Документы/VitrualIntern/city_ru.csv");

        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Wrong filePath.");
            System.exit(0);
        }


        countOfCitiesInRegions(cityList);
        



    }

}
