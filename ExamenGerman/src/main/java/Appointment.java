import Specialization.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Appointment {

    //Las citas tendrán: fecha, hora, médico asignado según la especialidad y un contador de citas.
    private String date;
    private String time;
    private Doctor doctor;

    private static int counterID = 0;
    private final int appointmentNumber;

    public Appointment(String date, String time, Doctor doctor) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        appointmentNumber = ++counterID;

    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public static int getCounterID() {
        return counterID;
    }

    public int getAppointmentNumber() {
        return appointmentNumber;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctor=" + doctor +
                ", appointmentNumber=" + appointmentNumber +
                '}';
    }


}
