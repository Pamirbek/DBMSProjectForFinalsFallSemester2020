package sample;

public class Student {
    private String name;
    private String surname;
    private int id;
    private String groupName;

    public Student(String name, String surname, int id, String groupName) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

