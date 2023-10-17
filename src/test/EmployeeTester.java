package test;

import main.pojo.Employee;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTester {
    public static void main(String[] args) {
        List<Employee> empList = buildEmp();
        //How many male and female employees are there in the organization?
        Map<String, Long> noOfMAilAndFemail = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("No Of male and female employees are there in the organization: " + noOfMAilAndFemail);
        System.out.println("==================================");
        // Print the name of all departments in the organization?
        System.out.println(empList.stream().map(Employee::getDepartment).distinct().toList());
        empList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        System.out.println("==================================");
        // What is the average age of male and female employees?
        Map<String, Double> avgAgeByGender = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("Average age by gender: " + avgAgeByGender);
        System.out.println("==================================");
        //Get the details of highest paid employee in the organization?
        Optional<Employee> employeeOptional = empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("higest paid employee in the organisation is: ");
        System.out.println(employeeOptional.get());
        System.out.println("==================================");
        //Get the names of all employees who have joined after 2015?
        System.out.println("Get List of employes who joined after 2015");
        System.out.println(empList.stream().filter(e -> e.getYearOfJoining() > 2015).collect(Collectors.toList()));
        System.out.println("Get let of employe Name who joined after 2015: " + empList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).toList());
        empList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
        System.out.println("==================================");
        //Count the number of employees in each department?
        Map<String, Long> groupByDepartment = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count the number of employees in each department: " + groupByDepartment);
        Set<Map.Entry<String, Long>> entryS = groupByDepartment.entrySet();
        for (Map.Entry<String, Long> entry : entryS) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("==================================");
        //What is the average salary of each department?
        System.out.println("Average salary of each department");
        Map<String, Double> avgSalByDep = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalByDep);
        Set<Map.Entry<String, Double>> avgSalMapEntrySet = avgSalByDep.entrySet();
        for (Map.Entry<String, Double> avgSal : avgSalMapEntrySet) {
            System.out.println(avgSal.getKey() + ":  " + avgSal.getValue());
        }
        System.out.println("==================================");
        //Get the details of youngest male employee in the product development department?
        Optional<Employee> youngestEmp = empList.stream().filter(emp->emp.getGender().equalsIgnoreCase("Male")&&emp.getDepartment().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparingInt(Employee::getAge));
                //.collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println("youngest male employee in the product development department: "+youngestEmp);

    }

    private static List<Employee> buildEmp() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }

}
