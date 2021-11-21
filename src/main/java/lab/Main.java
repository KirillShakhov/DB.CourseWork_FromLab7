package lab;

import java.io.IOException;
import java.util.Properties;
public class Main {
    public static void main(String[] args) {
        try {
            Properties property = new Properties();
            property.load(Main.class.getResourceAsStream("/config.properties"));
            new BD(
                    property.getProperty("db.host"),
                    property.getProperty("db.login"),
                    property.getProperty("db.password")
            );
            ServerController serverController = new ServerController("3030");
            serverController.run();
        }catch (IOException e) {
            System.out.println("Файл конфигурации БД не загружен");
            e.printStackTrace();
        }
    }
}
