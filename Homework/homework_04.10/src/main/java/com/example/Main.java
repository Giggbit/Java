package com.example;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        com.example.Person person = new com.example.Person("John", 30);

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("person.json")) {
            gson.toJson(person, writer);
            System.out.println("Объект успешно записан в файл");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("person.json")) {
            com.example.Person deserializedPerson = gson.fromJson(reader, com.example.Person.class);
            System.out.println("JSON успешно прочитан");
            System.out.println("Имя: " + deserializedPerson.getName());
            System.out.println("Возраст: " + deserializedPerson.getAge());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}