import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        int patientId = 1;
        int doctorId = 1;

        while (true) {

            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient Name: ");
                    String patientName = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    hospital.addPatient(
                        new Patient(
                            patientId++,
                            patientName,
                            age,
                            disease
                        )
                    );
                    break;

                case 2:
                    hospital.displayPatients();
                    break;

                case 3:
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = sc.nextLine();

                    System.out.print("Enter Specialization: ");
                    String specialization = sc.nextLine();

                    hospital.addDoctor(
                        new Doctor(
                            doctorId++,
                            doctorName,
                            specialization
                        )
                    );
                    break;

                case 4:
                    hospital.displayDoctors();
                    break;

                case 5:
                    System.out.print("Enter Patient Name: ");
                    String pName = sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String dName = sc.nextLine();

                    if (hospital.bookAppointment(pName, dName)) {
                        System.out.println(
                            "Appointment booked successfully!"
                        );
                    } else {
                        System.out.println(
                            "Patient or Doctor not found!"
                        );
                    }
                    break;

                case 6:
                    hospital.displayAppointments();
                    break;

                case 7:
                    System.out.println(
                        "Thank you for using Hospital Management System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}