package a1_1901040195;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnrolmentManager {
    private int id;
    private String name;
    private String dob;
    private String address;
    private String email;

    public EnrolmentManager() {
    }

    public EnrolmentManager(int id, String name, String dob, String address, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EnrolmentManager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void addEnrolment() {
        List<EnrolmentManager> enrolmentManagers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id: ");
        id = sc.nextInt();
        System.out.println("Enter the student's name: ");
        name = sc.nextLine();
        System.out.println("Enter the student's date of birth: ");
        dob = sc.nextLine();
        System.out.println("Enter the address: ");
        address = sc.nextLine();
        System.out.println("Enter the email: ");
        email = sc.nextLine();
    }
}
