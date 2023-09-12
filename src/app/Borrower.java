package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String telephone;
    private static List<Object> listOfBorrowers = new ArrayList<>();

    public Borrower(String firstName, String lastName, LocalDate dateOfBirth, String address, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.telephone = telephone;

        listOfBorrowers.add(List.of(firstName, lastName, dateOfBirth, address, telephone));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public static List<Object> getListOfBorrowers() {
        return listOfBorrowers;
    }
}
