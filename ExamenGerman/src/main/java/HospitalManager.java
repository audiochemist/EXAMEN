import Exceptions.NoAppointmentFound;
import Exceptions.NoPatientFound;
import Specialization.Doctor;
import Specialization.SpecializationType;
import Specialization.Trauma;

import java.util.ArrayList;

public class HospitalManager {

    private static ArrayList<Patient> patients;
    private static ArrayList<Doctor> doctors;

    public HospitalManager() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        doctors.add(new Doctor("Steve", 76, SpecializationType.TRAUMA));
        doctors.add(new Doctor("Martha", 433, SpecializationType.GENERAL));
        doctors.add(new Doctor("German", 43, SpecializationType.NEUROLOGY));
    }

    public void start() {
        int option;
        do {
            option = menu();
            boolean valid = false;
            while (!valid) {
                try {
                    handleOption(option);
                    valid = true;
                } catch (NoPatientFound e) {
                    System.err.println("Error: " + e.getMessage() + "\nPlease enter a valid patient name");
                } catch (NoAppointmentFound e) {
                    System.err.println("Error: " + e.getMessage() + "\nPlease enter a valid index appointment");
                } catch (Exception e) {
                    System.err.println("An unexpected error occurred:" + e.getMessage());
                }
            }
        } while (option != 0);
    }

    private static void handleOption(int option) throws Exception {
        switch (option) {
            case 0:
                System.out.println("Goodbye");
                break;
            case 1:
                assignAppointment();
                break;
            case 2:
                cancelAppointment();
                break;
            case 3:
                showDoctorAppointments();
                break;
            case 4:
                showPatientAppointments();
                break;
            case 5:
                registerPatient();
                break;
        }
    }

    public static int menu() {

        int menuOption;

        menuOption = Input.readInt("\nMenu: " +
                "\n0. Exit App" +
                "\n1. Assign an appointment" +
                "\n2. Cancel appointment" +
                "\n3. Show doctor's appointments" +
                "\n4. Show patient's appointments" +
                "\n5. Register a patient");

        return menuOption;

    }

    public static void assignAppointment() throws NoPatientFound {
        String name = Input.readString("Enter the name of the patient you would like to assign an appointment to");
        int index = searchPatients(name);

        if (index == -1) {
            throw new NoPatientFound("No patient registered under this name was found");
        } else {
            String specializationType = Input.readString("What medicine specialization?:");
            switch (specializationType) {
                case "GENERAL":
                    Appointment newAppointment = new Appointment(
                            Input.readString("Enter the date"), Input.readString("Enter the time"), doctors.get(1));
                    patients.get(index).getAppointments().add(newAppointment);
                    break;
                case "NEUROLOGY":
                    Appointment newAppointment2 = new Appointment(
                            Input.readString("Enter the date"), Input.readString("Enter the time"), doctors.get(0));
                    patients.get(index).getAppointments().add(newAppointment2);
                    break;
                case "TRAUMA":
                    Appointment newAppointment3 = new Appointment(
                            Input.readString("Enter the date"), Input.readString("Enter the time"), doctors.get(2));
                    patients.get(index).getAppointments().add(newAppointment3);
                    break;
            }
            System.out.println("Appointment was scheduled successfully");
        }
    }


    public static void cancelAppointment() throws NoAppointmentFound, NoPatientFound {
        showPatientAppointments();

        String name = Input.readString("Enter the name of the patient you would like to assign an appointment to");
        int indexPatient = searchPatients(name);

        if (indexPatient == -1) {
            throw new NoPatientFound("No patient registered under this name was found");
        }else {
            int index = Input.readInt("Which index of appointment would you like to cancel?");
            if (searchAppointments(index) == -1) {
                throw new NoAppointmentFound("This appointment was not found");
            } else {
            patients.get(indexPatient).getAppointments().remove(index);
            }
        }
    }

    public static void showDoctorAppointments() {
//TODO No funciona - hay que mejorar, queremos mostrar por doctores
        showDoctors();

        int index = Input.readInt("Enter the index of doctor you want to see the appointmets of");
        System.out.println("Doctor's appointments:");
        int count = 0;
        switch (index){
            case 0:
                count = 0;
                for (Patient patient : patients){
                    if (patient.getAppointments().get(count).getDoctor().getName().equalsIgnoreCase("Steve")){
                System.out.println(patients.get(count).getAppointments().get(count));
                count++;
            }
                }
                break;
            case 1:
                int count2 = 0;
                for (Patient patient : patients){
                    if (patient.getAppointments().get(count).getDoctor().getName().equalsIgnoreCase("Martha")){
                        System.out.println(patients.get(count).getAppointments().get(count));
                        count++;
                    }
                }
                break;
            case 2:
                int count3 = 0;
                for (Patient patient : patients){
                    if (patient.getAppointments().get(count).getDoctor().getName().equalsIgnoreCase("German")){
                        System.out.println(patients.get(count).getAppointments().get(count));
                        count++;
                    }
                }
                break;
        }

    }

    public static void showPatientAppointments() {
        showPatients();

        int index = searchPatients(Input.readString("Enter the name of the patient you want to see the appointmets of"));
        System.out.println("Patient's appointments:");

        for (int i = 0; i < patients.get(index).getAppointments().size(); i++) {
            System.out.println(patients.get(index).getAppointments().get(i).toString());
        }
    }

    public static void registerPatient() {
        Patient newPatient = new Patient(Input.readString("Enter the name of the patient"), Input.readString("Enter your ID"));
        patients.add(newPatient);
    }

    public static int searchPatients(String name) {
        int foundIndex = -1;
        boolean coincidence = false;
        int i = 0;

        while (i < patients.size() && !coincidence) {
            if ((patients.get(i).getName().equalsIgnoreCase(name))) {
                coincidence = true;
                foundIndex = i;
            }
            i++;

        }
        return foundIndex;
    }
    public static int searchAppointments(int index) {
        int foundIndex = -1;
        boolean coincidence = false;
        int i = 0;

        while (i < patients.size() && !coincidence) {
            if ((i == index)) {
                coincidence = true;
                foundIndex = i;
            }
            i++;

        }
        return foundIndex;
    }

    public static void showPatients(){
        System.out.println("Patients");
        int count = 0;
        for (Patient patient : patients) {
                System.out.println("\n" + count + ". " + patient.getName());
                count++;
            }
        }

        public static void showDoctors(){
            System.out.println("Doctors");
            int count = 0;
            for (Doctor doctor : doctors) {
                System.out.println(count + ". " + doctor.toString());
                count++;
            }
        }

    }