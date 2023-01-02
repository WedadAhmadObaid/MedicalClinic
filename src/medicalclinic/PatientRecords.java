package medicalclinic;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class PatientRecords {

    //Variables 
    private int count;
    private Patient patient;
    private LocalDateTime Treatment_session_time;

    //constructor
    public PatientRecords(int count, Patient patient, LocalDateTime Treatment_session_time) {
        this.count = count;
        this.patient = patient;
        this.Treatment_session_time = Treatment_session_time;
    }

    //getters and setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getTreatment_session_time() {
        return Treatment_session_time;
    }

    public void setTreatment_session_time(LocalDateTime Treatment_session_time) {
        this.Treatment_session_time = Treatment_session_time;
    }

    @Override
    public String toString() {
        return "\n\nRecord Number          : " + count
                + "\nTreatment Session Time : " + Treatment_session_time
                + "\n\nPatient Information " + patient + "\n";
    }

    //custum methodes
    @SuppressWarnings("empty-statement")
    public void PatientRecordsInfo() {
        System.out.println("\nPatient Records Information" + toString());;
    }

}
