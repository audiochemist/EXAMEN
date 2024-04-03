package Specialization;

public class Neurology extends Doctor{
    public Neurology(String name, int roomNumber, SpecializationType type) {
        super(name, roomNumber, type);
    }


    private String tomography(){
    return "wrong";
    }

    public String diagnosis(){
        return "According to your analysis that went " + tomography() + ", your diagnosis is blah blah";
    }

    @Override
    public String toString() {
        return "Neurology{" +
                "name='" + name + '\'' +
                ", roomNumber=" + roomNumber +
                ", type=" + type +
                '}';
    }

}
