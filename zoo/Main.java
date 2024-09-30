package zoo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 動物を登録");
            System.out.println("2. 動物一覧を表示");
            System.out.println("3. 餌代の合計を計算");
            System.out.println("4. 終了");

            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("'ペンギン', 'ライオン', 'ゾウ'から種類を入力してください: ");
                String species = scanner.nextLine();
                System.out.print("動物の名前を入力してください: ");
                String name = scanner.nextLine();
                zoo.registerAnimal(species, name);
            } else if (choice == 2) {
                zoo.displayAnimals();
            } else if (choice == 3) {
                zoo.calculateTotalCost();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("無効な選択です。もう一度お試しください。");
            }
        }

        scanner.close();
    }
}
