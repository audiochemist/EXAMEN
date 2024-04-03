package Specialization;

public class Doctor {

    protected String name;
    protected int roomNumber;
    protected SpecializationType type;

    public Doctor(String name, int roomNumber, SpecializationType type) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public SpecializationType getType() {
        return type;
    }
    public String diagnosis(){
        return "Your diagnosis is ";
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "\nname='" + name + '\'' +
                "\nroomNumber=" + roomNumber +
                "\ntype=" + type +
                '}';
    }


}
