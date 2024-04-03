package Specialization;

public class Trauma extends Doctor{
    public Trauma(String name, int roomNumber, SpecializationType type) {
        super(name, roomNumber, type);
    }

    private String radiography(){
            return "okay";
    }

    public String diagnosis(){
        return "According to your analysis that went " + radiography() + ", your diagnosis is blah blah";
    }

    @Override
    public String toString() {
        return "Trauma{" +
                "name='" + name + '\'' +
                ", roomNumber=" + roomNumber +
                ", type=" + type +
                '}';
    }

}
