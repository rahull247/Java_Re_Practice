package sixth;

public class Student {
    private String name;
    private int age;
    private int marksMaths;
    private int marksScience;

    public Student(String name, int age, int marksMaths, int marksScience) {
        this.name = name;
        this.age = age;
        this.marksMaths = marksMaths;
        this.marksScience = marksScience;
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

    public int getMarksMaths() {
        return marksMaths;
    }

    public void setMarksMaths(int marksMaths) {
        this.marksMaths = marksMaths;
    }

    public int getMarksScience() {
        return marksScience;
    }

    public void setMarksScience(int marksScience) {
        this.marksScience = marksScience;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marksMaths=" + marksMaths +
                ", marksScience=" + marksScience +
                '}';
    }
}
