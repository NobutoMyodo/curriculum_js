package zoo.bean;

public class Animal {
    private String name;
    private String species;
    private String classification;
    private int foodCost;

    // コンストラクタ
    public Animal(String name, String species, String classification, int foodCost) {
        this.name = name;
        this.species = species;
        this.classification = classification;
        this.foodCost = foodCost;
    }

    // Getterメソッド (省略可)
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getClassification() {
        return classification;
    }

    public int getFoodCost() {
        return foodCost;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Species: " + species + ", Classification: " + classification + ", Monthly Food Cost: " + foodCost + "円";
    }
}
