package medicalclinic;

import java.time.LocalDateTime;

public class Patient {

    //Variables 
    private int id, age;
    private String name, home_address, phone_number;
    private LocalDateTime time_attendance;

    //constructor 
    public Patient(int id, int age, String name, String home_address, String phone_number, LocalDateTime time_attendance) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.home_address = home_address;
        this.phone_number = phone_number;
        this.time_attendance = time_attendance;
    }

    //getters and setters    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDateTime getTime_attendance() {
        return time_attendance;
    }

    public void setTime_attendance(LocalDateTime time_attendance) {
        this.time_attendance = time_attendance;
    }

    @Override
    public String toString() {
        return "\n\nID              : " + id 
                + "\nAge             : " + age 
                + "\nName            : " + name 
                + "\nHome Address    : " + home_address 
                + "\nPhone Number    : " + phone_number 
                + "\nTime Attendance : " + time_attendance
                +"\n";
    }
    //custum methodes
    @SuppressWarnings("empty-statement")
    public void PatientInfo() {
        System.out.println("Patient Information" + toString());;
    }

}
