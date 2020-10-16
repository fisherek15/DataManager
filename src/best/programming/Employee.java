package best.programming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {

    private String firstName;
    private String lastName;
    private double salary;
    private String gender;
    private int departmentNr;

    public Employee(String firstName, String lastName, double salary, String gender, int departmentNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.gender = gender;
        this.departmentNr = departmentNr;
    }

    public static void readFromTextFile(String fullPath, List<Employee> employees){
        
        File file = new File(fullPath);
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                String[] elements = line.split(" ");
                employees.add(new Employee(elements[0], elements[1], Double.valueOf(elements[2]), elements[3], Integer.valueOf(elements[4])));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
