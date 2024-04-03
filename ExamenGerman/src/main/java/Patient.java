import java.util.ArrayList;

public class Patient {

    private static ArrayList<String> diagnostics;
    private String DNI;
    private String name;
    private ArrayList<Appointment> appointments;
    private final String HOSPITALNUMBER = "0098766H";

    public Patient(String name, String DNI) {
        diagnostics = new ArrayList<>();
        appointments = new ArrayList<>();
        this.name = name;
        this.DNI = DNI;
    }

    public static ArrayList<String> getDiagnostics() {
        return diagnostics;
    }

    public String getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public String toString() {
        return "Patient:" +
                "\nDNI='" + DNI + '\'' +
                "\nname='" + name + '\'' +
                "\nappointments=" + appointments +
                "\nHOSPITALNUMBER='" + HOSPITALNUMBER + '\'' +
                '}';
    }
}
