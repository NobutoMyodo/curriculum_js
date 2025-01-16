package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableFromSQL {
    public static void main(String[] args) {
        // PostgreSQL接続情報
        String url = "jdbc:postgresql://localhost:5433/blog-system";
        String user = "postgres";
        String password = "postgres";

        // SQLファイルのパス
        String sqlFile = "src/main/resources/db/create_blogs_table.sql";

        try (Connection con = DriverManager.getConnection(url, user, password);
             BufferedReader reader = new BufferedReader(new FileReader(sqlFile))) {

            // SQLファイルの読み込み
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }

            // SQL文の実行
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql.toString());
            System.out.println("テーブルが作成されました");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}