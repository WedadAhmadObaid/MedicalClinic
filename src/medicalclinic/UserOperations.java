package medicalclinic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UserOperations {

    private int typing;
    private final Scanner sc = new Scanner(System.in);
    private final LinkedList<Patient> linkedlist_Patient = new LinkedList<>();
    private final Stack STACKs = new Stack();
    private final Queue<PatientRecords> QUEUEs = new LinkedList<>();
    private int count = 0;

    public void printOption() {
        System.out.println("1 :Entry for the receptionist.");
        System.out.println("2 :Entry is for the doctor only.");
        System.out.println("0 :Exit.");
        System.out.print("Choose your status 0 - 2 ? : ");
    }

    public void printDoctor() {
        System.out.println("\nView patient information by queue.");
        if (QUEUEs.isEmpty()) {
            System.out.println("Not found patient information");
        } else {
            System.out.println(QUEUEs.peek());
        }
        System.out.println("1 :Have you finished diagnosing the current patient? Click Yes to view the second one?");
        System.out.println("2 :Exit.");
        System.out.print("Choose your status 0 or 1 ? : ");
        typing = sc.nextInt();
        switch (typing) {
            case 2:
                System.out.println("logout doctor staff page..");
                func();
            case 1:
                QUEUEs.remove();
                System.out.println("The patient was diagnosed successfully..");
                printDoctor();
            default:
                System.out.println("Enter correct number");
        }
    }

    public void printReceptionist() {
        if (STACKs.isEmpty()) {
            System.out.println("There are no records for today");
        } else {
            System.out.println(STACKs.pop());
        }
        System.out.println("View patient information by stack.");
        System.out.println("1 :Do you want to add a new record?");
        System.out.println("2 :Do you want to find a patient?");
        System.out.println("3 :Exit.");
        System.out.print("Choose your status 0 or 1 ? : ");
        typing = sc.nextInt();
        switch (typing) {
            case 3:
                System.out.println("logout receptionist staff page..");
                func();
            case 1:
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Id : ");
                int id = scanner.nextInt();
                System.out.print("\nEnter Age : ");
                int age = scanner.nextInt();
                System.out.print("\nEnter name : ");
                String name = scanner.next();
                System.out.print("\nEnter home address : ");
                String home_address = scanner.next();
                System.out.print("\nEnter phone number : ");
                String phone_number = scanner.next();
                Patient patient = new Patient(id, age, name, home_address, phone_number, now);
                linkedlist_Patient.add(patient);
                PatientRecords PatientRecords = new PatientRecords(count, patient, now);
                count++;
                System.out.println("Patient Information added successfully.");
                STACKs.push(PatientRecords);
                QUEUEs.add(PatientRecords);
                System.out.println("add a new record successfully..");
                printReceptionist();
            case 2:
                System.out.print("Enter Id : ");
                int inputId = sc.nextInt();
                System.out.println(binarySearch(linkedlist_Patient, 0, 0, inputId));
                printReceptionist();
            default:
                System.out.println("Enter correct number");
        }
    }

    public void func() {
        printOption();
        typing = sc.nextInt();
        switch (typing) {
            case 0:
                System.out.println("Exit");
                break;
            case 1:
                System.out.println("Welcome to the reception staff page.");
                printReceptionist();
            case 2:
                System.out.println("Welcome to the doctor staff page.");
                printDoctor();
            default:
                System.out.println("Enter correct number");
        }
    }

    public static Patient binarySearch(LinkedList<Patient> linkedList, int first, int last, int key) {
        first = linkedList.getFirst().getId();
        last = linkedList.getLast().getId();

        if (last >= first) {
            int mid = first + (last - first) / 2;
            // If the element is present at the
            // middle itself
            if (linkedList.get(mid).getId() == key) {
                return linkedList.get(mid);
            }

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (linkedList.get(mid).getId() > key) {
                return binarySearch(linkedList, first, mid - 1, key);
            }

            // Else the element can only be present
            // in right subarray
            return binarySearch(linkedList, mid + 1, last, key);
        }

        // We reach here when element is not present
        // in array
        return null;
    }
}
