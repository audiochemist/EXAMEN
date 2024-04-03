package Specialization;

public class General extends Doctor {
    public General(String name, int roomNumber, SpecializationType type) {
        super(name, roomNumber, type);
    }

    @Override
    public String toString() {
        return "General{" +
                "name='" + name + '\'' +
                ", roomNumber=" + roomNumber +
                ", type=" + type +
                '}';
    }

    public String diagnosis(){
        return "Your diagnosis is blah blah";
    }


}
