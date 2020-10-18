package best.programming;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        String path = "E:\\INFORMATICS\\Projects_Java_2\\DataManager\\";
        String fileName1 = "data.txt";
        int linesQuantity = Employee.readFromTextFile(path+fileName1, employees);
        System.out.println(linesQuantity);
        double avgSalary = Employee.averageSalary(employees,3, "K");
        System.out.println(avgSalary);
        String fileName2 = "serializedObjs";
        Employee.saveSerializedObjToFile(path+fileName2, employees);
    }
}
