package test;

import main.builder.EmpBuilder;
import main.pojo.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmpTesterTwo {
    static List<Employee> empList = EmpBuilder.buildEmp();

    public static void main(String[] args) {
        //How many male and female employees are there in the organization
        getMailAndFemailEmpInOrg();
        //How many male and female employees are there in the sales and marketing team?
        getByGengerinSAndMInOrg();
        //Print the name of all departments in the organization?
        getNamesOfAllDepInOrg();
        //What is the average age of male and female employees?
        avgAgeOfMailAndFemailInOrg();
        //Get the details of highest paid employee in the organization?
        getHighestPaidEmpInOrg();
        //Get the names of all employees who have joined after 2015?
        getEmpJoinedAfter2015();
        //Count the number of employees in each department?
        getEmpInEachDep();
        //What is the average salary of each department?
        getAvgSalOfEachDep();
        // Get the details of youngest male employee in the product development department?
        getYoungMailEmpInProdDevDep();
        //Who has the most working experience in the organization?
        getMostExpEmpInOrg();
        //What is the average salary of male and female employees?
        getAvgSalByGenderInOrg();
        //List down the names of all employees in each department?
        getNamesByDepInOrg();
        //What is the average salary and total salary of the whole organization?
        getAvgAndTotalSalInOrg();
        //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        getSeparateEmpByAgeInOrg();
        //Who is the oldest employee in the organization? What is his age and which department he belongs to?
        getAgeAndDepOfOldestEmpInOrg();
        //How to find second highest salary in below array list using Java8 streams
        getSecondHigestSalInOrg();
        //Find First three employee details based on highest salary?
        getTopThreeSalariedEmpInOrg();
        //How to find highest salary in each department
        getHighestSalByDepInOrg();
    }

    private static void getMailAndFemailEmpInOrg() {
        Map<String, Long> mFMap = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        mFMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        /*        Set<Map.Entry<String, Long>> eFMapSet = mFMap.entrySet();
        for (Map.Entry<String, Long> empMap : eFMapSet) {
            System.out.println(empMap.getKey() + ": " + empMap.getValue());
        }*/
    }

    private static void getByGengerinSAndMInOrg() {
        Map<String, Long> empMap = empList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("sales and marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        empMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " employes in sales and marketing: " + entry.getValue()));
       /* Set<Map.Entry<String, Long>> emoMapSet = empMap.entrySet();
        for (Map.Entry<String, Long> empM : emoMapSet) {
            System.out.println(empM.getKey() + " employes in sales and marketing: " + empM.getValue());
        }*/
    }

    private static void getNamesOfAllDepInOrg() {
        List<String> stringList = empList.stream().map(Employee::getDepartment).distinct().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        System.out.println("Names of all Department in Organization: " + stringList);
    }

    private static void avgAgeOfMailAndFemailInOrg() {
        Map<String, Double> avgAgeMap = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        avgAgeMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " gender avg age: " + entry.getValue()));

        /*Set<Map.Entry<String, Double>> avgSet = avgAgeMap.entrySet();
        for (Map.Entry<String, Double> empMap : avgSet) {
            System.out.println(empMap.getKey() + " gender avg age: " + empMap.getValue());
        }*/
    }

    private static void getHighestPaidEmpInOrg() {
        Optional<Employee> highPaidEmp = empList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Highest paid Emp in Org: " + highPaidEmp.get());
    }

    private static void getEmpJoinedAfter2015() {
        List<String> empNames = empList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());
        System.out.println("Employees joined after 2015 in Org: " + empNames);
    }

    private static void getEmpInEachDep() {
        Map<String, Long> empMap = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        empMap.entrySet().forEach(entry -> System.out.println("No of emp in " + entry.getKey() + ": " + entry.getValue()));

       /* Set<Map.Entry<String, Long>> empSet = empMap.entrySet();
        for (Map.Entry<String, Long> empMapEntry : empSet) {
            System.out.println("No of emp in " + empMapEntry.getKey() + ": " + empMapEntry.getValue());
        }*/
    }

    private static void getAvgSalOfEachDep() {
        Map<String, Double> avgSalMap = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        avgSalMap.entrySet().forEach(entry -> System.out.println("Averages Sal of " + entry.getKey() + ": " + entry.getValue()));

/*        Set<Map.Entry<String, Double>> avgSalSet = avgSalMap.entrySet();
        for (Map.Entry<String, Double> mapEntry : avgSalSet) {
            System.out.println("Averages Sal of " + mapEntry.getKey() + ": " + mapEntry.getValue());
        }*/
    }

    private static void getYoungMailEmpInProdDevDep() {
        Optional<Employee> emp = empList.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("male") && employee.getDepartment().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparingInt(Employee::getAge));
        System.out.println("Youngest male employee in prod develop in organization: " + emp.get());

    }

    private static void getMostExpEmpInOrg() {
        Optional<Employee> mostExpEmp = empList.stream()
                .min(Comparator.comparingDouble(Employee::getYearOfJoining));
        System.out.println("Most work experience in the organization: " + mostExpEmp.get());
    }

    private static void getAvgSalByGenderInOrg() {
        Map<String, Double> avgSalMap = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        avgSalMap.entrySet().forEach(entry -> System.out.println("Average salary of " + entry.getKey() + " in the organization is: " + entry.getValue()));

        /*Set<Map.Entry<String, Double>> avgSalSet = avgSalMap.entrySet();
        for (Map.Entry<String, Double> entry : avgSalSet) {
            System.out.println("Average salary of " + entry.getKey() + " in the organization is: " + entry.getValue());
        }*/
    }

    private static void getNamesByDepInOrg() {
        Map<String, List<Employee>> empByDep = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        empByDep.entrySet().forEach(entry -> System.out.println("Employees in " + entry.getKey() + " department are: " + entry.getValue().stream().map(Employee::getName).toList()));

/*        Set<Map.Entry<String, List<Employee>>> empByDepSet = empByDep.entrySet();
        for (Map.Entry<String, List<Employee>> entry : empByDepSet) {
            System.out.println("Employees in " + entry.getKey() + " department are: " + entry.getValue().stream().map(Employee::getName).toList());
        }*/
    }

    private static void getAvgAndTotalSalInOrg() {
        DoubleSummaryStatistics avgAndTotalSal = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Total sal in organization is: " + avgAndTotalSal.getSum());
        System.out.println("Average sal in organization is: " + avgAndTotalSal.getAverage());
    }

    private static void getSeparateEmpByAgeInOrg() {
        Map<Boolean, List<Employee>> empByAge = empList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 25));
        empByAge.entrySet().stream().forEach(
                entry -> {
                    if (entry.getKey()) {
                        System.out.println("Employees older than 25 years old: " + entry.getValue().stream().map(Employee::getName).toList());
                    } else {
                        System.out.println("Employees younger than or equal to 25 years old: " + entry.getValue().stream().map(Employee::getName).toList());
                    }
                }
        );

        empByAge.forEach((key, value) -> {
                    if (key) {
                        System.out.println("Employees older than 25 years old: " + value.stream().map(Employee::getName).toList());
                    } else {
                        System.out.println("Employees younger than or equal to 25 years old: " + value.stream().map(Employee::getName).toList());
                    }
                }

        );

       /* Set<Map.Entry<Boolean, List<Employee>>> empSet = empByAge.entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry : empSet) {
            if (entry.getKey()) {
                System.out.println("Employees older than 25 years old: " + entry.getValue().stream().map(Employee::getName).toList());
            } else {
                System.out.println("Employees younger than or equal to 25 years old: " + entry.getValue().stream().map(Employee::getName).toList());
            }
        }*/
    }

    private static void getAgeAndDepOfOldestEmpInOrg() {
        Employee emp = empList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println("Age of Oldest emp is: " + emp.getAge() + " and working for " + emp.getDepartment() + " department");
    }

    private static void getSecondHigestSalInOrg() {
        List<Double> salDesc1 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getSalary).toList();
        System.out.println("Salary List in desc order : " + salDesc1);
        List<Double> salDesc2 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).map(Employee::getSalary).toList();
        System.out.println("Salary List in desc order after removing first Highest Sal: " + salDesc2);
        Double secHighSal = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().map(Employee::getSalary).get();
        System.out.println("Second highest sal in the organization is: " + secHighSal);
        List<Double> secHighSal2 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getSalary).toList();
        System.out.println("Second highest sal in the organization is: " + secHighSal2.get(1));
    }

    private static void getTopThreeSalariedEmpInOrg() {
        List<Employee> topThreeEmp = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First three highest paid sal emp in org: " + topThreeEmp);

        empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    private static void getHighestSalByDepInOrg() {
        Map<String, List<Employee>> empMap = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        empMap.entrySet().forEach(entry -> System.out.println("Highest sal in " + entry.getKey() + " department is: " + entry.getValue().stream().max(Comparator.comparingDouble(Employee::getSalary)).map(Employee::getSalary).get()));

        /*Set<Map.Entry<String, List<Employee>>> empSet = empMap.entrySet();
        for (Map.Entry<String, List<Employee>> entry : empSet) {
            System.out.println("Highest sal in " + entry.getKey() + " department is: " + entry.getValue().stream().max(Comparator.comparingDouble(Employee::getSalary)).map(Employee::getSalary).get());
        }*/

        Map<String, Optional<Employee>> empMap2 = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary)))));
        empMap2.entrySet().forEach(System.out::println);

        empMap2.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().get().getSalary()));
        System.out.println("-------------------------------------------------------------------------------------------------");
        empMap2.forEach((key, value) -> System.out.println(key + ": " + value.get().getSalary()));
    }

}
