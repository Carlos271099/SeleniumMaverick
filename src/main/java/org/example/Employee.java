package org.example;


import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Employees")
public class Employee {

    @ExcelCellName("First Name")
    private String firstName;
    @ExcelCellName("Middle Name")
    private String middleName;
    @ExcelCellName("Last Name")
    private String lastName;
    @ExcelCellName("id")
    private Integer id;

    public Employee(String firstName, String middleName, String lastName, Integer id) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.id = id;

    }

    public Employee(){
        this.firstName = null;
        this.middleName = null;
        this.lastName = null;
        this.id = null;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }


}
