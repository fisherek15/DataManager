package best.programming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {

    private final String firstName;
    private final String lastName;
    private final double salary;
    private final String gender;
    private final int departmentNr;

    public Employee(String firstName, String lastName, double salary, String gender, int departmentNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.gender = gender;
        this.departmentNr = departmentNr;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", departmentNr=" + departmentNr +
                '}';
    }

    public static int readFromTextFile(String fullPath, List<Employee> employees){
        
        File file = new File(fullPath);
        String line;
        int linesQuantity = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null && linesQuantity < 100){
                String[] elements = line.split(" ");
                employees.add(new Employee(elements[0], elements[1], Double.parseDouble(elements[2]), elements[3], Integer.parseInt(elements[4])));
                linesQuantity++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return linesQuantity;
    }

    public static double averageSalary(List<Employee> employees, int departmentNr, String gender){
        double sumSalary = 0;
        int counter = 0;
        for (Employee employee : employees) {
            if(employee.departmentNr == departmentNr && employee.gender.equals(gender)){
                sumSalary += employee.salary;
                counter++;
            }
        }
        return sumSalary / counter;
    }

    public static void saveSerializedObjToFile(String fileName, List<Employee> employees){

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(employees);

            out.close();
            file.close();

            System.out.println("Object has been serialized");
        } catch (IOException ex){
            System.out.println("IOException is caught");
        }
    }

    public static List<Employee> readSerializedObjFromFile(String fileName){

        List<Employee> employees = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            employees = (ArrayList) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized");

        } catch(IOException ex){
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex){
            System.out.println("ClassNotFoundException is caught");
        }

        return employees;
    }
}
