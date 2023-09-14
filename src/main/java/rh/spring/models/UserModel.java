package rh.spring.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class UserModel {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private double balance;

    // No-args constructor
    public UserModel() {
    }

    public UserModel(int id, String firstName, String lastName, String email, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return id == userModel.id && Double.compare(balance, userModel.balance) == 0 && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName) && Objects.equals(email, userModel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, balance);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
