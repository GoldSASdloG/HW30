package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.deserialization.CaseDeserializer;
import org.example.deserialization.EmployeeDeserializer;
import org.example.serialization.CaseSerializer;
import org.example.serialization.EmployeeSerializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Case caseOne = new Case(
                "Годовой отчет",
                "Составить годовой отчет за 23 год",
                "отчет должен быть на 30 страниц");
        Case caseTwo = new Case(
                "Магазин",
                "Зайти в магазин за продуктами",
                "Нужно взять молока и селедку");


        Employee hr = new Employee("Марина", 10000, "HR", List.of(caseOne));
        Employee manager = new Employee("Вася", 50000, "Manager", List.of(caseTwo));

        Company company = new Company(List.of(hr, manager));

        //todo сериализовывать тут в соответствии со структурой приложенной в файле занятия
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Case.class, new CaseSerializer())
                .registerTypeAdapter(Employee.class, new EmployeeSerializer())
                .registerTypeAdapter(Case.class, new CaseDeserializer())
                .registerTypeAdapter(Employee.class, new EmployeeDeserializer())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(company);
        System.out.println(json);

        //todo десериализовывать тут обратно.
        Company newCompany = gson.fromJson(json, Company.class);
        System.out.println(newCompany);
    }
}
