package handbook;

public class City {
    private String name;
    private String region;
    private String distinct;
    private int population;
    private String foundation;

    public City(String name, String region, String distinct, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.distinct = distinct;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistinct() {
        return distinct;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", distinct='" + distinct + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}
