package sixth;

public class UserMarks {

    private String name;
    private int age;
    private int mathsMarks;

    private int scienceMarks;

    public UserMarks(String name, int age, int mathsMarks, int scienceMarks) {
        this.name = name;
        this.age = age;
        this.mathsMarks = mathsMarks;
        this.scienceMarks = scienceMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(int mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public int getScienceMarks() {
        return scienceMarks;
    }

    public void setScienceMarks(int scienceMarks) {
        this.scienceMarks = scienceMarks;
    }

    @Override
    public String toString() {
        return "UserMarks{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mathsMarks=" + mathsMarks +
                ", scienceMarks=" + scienceMarks +
                '}';
    }
}
