package zoo;

import java.util.ArrayList;
import java.util.List;
import zoo.bean.Animal;
import zoo.bean.Elephant;
import zoo.bean.Lion;
import zoo.bean.Penguin;

public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    // 動物を登録するメソッド
    public void registerAnimal(String species, String name) {
        Animal animal = null;

        // species に応じた Animal のサブクラスのインスタンスを生成するコードを記述してください。
        // 例えば、species が "ライオン" であれば、Lion クラスのインスタンスを生成します。
        switch (species) {
            case "ライオン":
                animal = new Lion(name);
                break;
            case "ゾウ":
                animal = new Elephant(name);
                break;
            case "ペンギン":
                animal = new Penguin(name);
                break;
            default:
                System.out.println("未知の動物種: " + species);
                return;  // ここでメソッドを終了
        }
        // animalが作成できた場合、動物をリストに追加して、登録メッセージを表示します。
        // animal が null の場合は、未知の種類であることを表示します。
        animals.add(animal);
        System.out.println(animal.getSpecies() +  animal.getName() + "が登録されました。");
    }

    // 動物一覧を表示するメソッド
    public void displayAnimals() {
        if (animals.isEmpty()) {
            System.out.println("現在、登録された動物はいません。");
            return;
        }
        
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    // 餌代の合計を計算するメソッド
    public void calculateTotalCost() {
        double totalCost = 0;
        for (Animal animal : animals) {
            totalCost += animal.getFoodCost();
        }
        System.out.println("全ての動物の月間餌代の合計: " + totalCost + "円");
    }
}