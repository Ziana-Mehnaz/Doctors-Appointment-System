
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentSystem {
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public AppointmentSystem() {
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void displayDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor.getName() + " - " + doctor.getSpecialty());
        }
    }

    public void displayDoctorAvailability(String doctorName) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(doctorName)) {
                System.out.println(doctor.getName() + " - Available time slots:");
                for (String timeSlot : doctor.getTimeSlots()) {
                    System.out.println(timeSlot);
                }
                break;
            }
        }
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void displayAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println("Date: " + appointment.getDate() + " | Time: " + appointment.getTime() + " | Doctor: " +
                    appointment.getDoctorName() + " | Patient: " + appointment.getPatientName());
        }
    }

    public void cancelAppointment(String patientName) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatientName().equalsIgnoreCase(patientName)) {
                appointments.remove(i);
                System.out.println("Appointment for " + patientName + " has been cancelled.");
                return;
            }
        }
        System.out.println("No appointment found for " + patientName + ".");
    }

    public static void main(String[] args) {
        AppointmentSystem system = new AppointmentSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Doctor doctor1 = new Doctor("Dr. Smith", "Cardiology", new String[]{"9:00am", "10:00am", "11:00am"});
        Doctor doctor2 = new Doctor("Dr. Johnson", "Dermatology", new String[]{"1:00pm", "2:00pm", "3:00pm"});
        system.addDoctor(doctor1);
        system.addDoctor(doctor2);

        while (running) {
            System.out.println("What would you like to do?");
            System.out.println("1. View available doctors and specialties");
            System.out.println("2. Schedule an appointment");
            System.out.println("3. View scheduled appointments");
            System.out.println("4. Cancel an appointment");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    system.displayDoctors();
                    break;
                case 2:
                    System.out.println("Which doctor would you like to see? (Enter name)");
                    String doctorName = scanner.nextLine();
                    system.displayDoctorAvailability(doctorName);
                    System.out.println("Enter a date (MM/DD/YYYY):");
                    String date = scanner.nextLine();
                    System.out.println("Enter a time slot:");
                    String time = scanner.nextLine();
                    System.out.println("Enter your name:");
                    String patientName = scanner.nextLine();
                    Appointment appointment = new Appointment(date, time, patientName, doctorName);
                    system.addAppointment(appointment);
                    System.out.println("Appointment has been scheduled for " + date + " at " + time + " with " +
                            doctorName + ".");
                    break;

                case 3:
                    system.displayAppointments();
                    break;
                case 4:
                    System.out.println("Enter the name of the patient whose appointment you would like to cancel:");
                    String patientNameToCancel = scanner.nextLine();
                    system.cancelAppointment(patientNameToCancel);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1-5.");
                    break;
            }
        }

        System.out.println("Exiting program...");
        scanner.close();
    }
}
