package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import member.bean.User;

public class Main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("1. 一般ユーザーを登録");
            System.out.println("2. 管理者ユーザーを登録");
            System.out.println("3. ユーザー情報を表示");
            System.out.println("4. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 改行文字を消費

            switch (choice) {
                case 1:
                    registerGeneralUser(scanner);
                    break;
                case 2:
                    registerAdminUser(scanner);
                    break;
                case 3:
                    findUsers();
                    break;
                case 4:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("無効な選択です。");
            }
        }

        scanner.close();
    }

    // 一般ユーザーを登録するメソッド
    public static void registerGeneralUser(Scanner scanner) {
        System.out.print("名前を入力してください: ");
        String name = scanner.nextLine();
        System.out.print("メールアドレスを入力してください: ");
        String email = scanner.nextLine();

        GeneralUser newUser = new GeneralUser(name, email);
        users.add(newUser);
        System.out.println("ユーザーが登録されました");
}
    // 管理者ユーザーを登録するメソッド
    public static void registerAdminUser(Scanner scanner) {
        System.out.print("名前を入力してください: ");
        String name = scanner.nextLine();
        System.out.print("メールアドレスを入力してください: ");
        String email = scanner.nextLine();

        AdminUser newUser = new AdminUser(name, email);
        users.add(newUser);
        System.out.println("管理者ユーザーが登録されました");
}
    // メールアドレスが既に登録されているか確認するメソッド
    
    // 登録されたユーザーを表示するメソッド
    public void findUsers(){
        if(){
            System.out.println()
        }
    }
}
