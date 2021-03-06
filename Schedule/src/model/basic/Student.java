package model.basic;

/**
 * A class representing a student.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class Student {
    private String name;
    private int viaId;
    private int semester;

    /**
     * Three-argument constructor. The semester has to be a positive integer, the name cannot be null
     * and the VIA ID has to be an integer with a length of 6.
     *
     * @param semester the semester in which the student is enrolled in.
     * @param name     the name of the student.
     * @param viaId    the VIA ID of the student.
     */
    public Student(int semester, String name, int viaId) {
        if (semester < 1) {
            throw new IllegalArgumentException("The semester has to be 1 or higher!");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
        if (String.valueOf(viaId).length() < 6) {
            throw new IllegalArgumentException("The VIA ID has to be 6 digits long!");
        }
        this.semester = semester;
        this.name = name;
        this.viaId = viaId;
    }

    /**
     * Two-argument Constructor for Student object.
     * @param name String with the student's name
     * @param viaId int with the student's via ID
     */
    public Student(String name, int viaId) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
        if (String.valueOf(viaId).length() < 6) {
            throw new IllegalArgumentException("The VIA ID has to be 6 digits long!");
        }
        this.semester = 0;
        this.name = name;
        this.viaId = viaId;
    }

    /**
     * A getter method returning the name of the student.
     *
     * @return the name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method returning the semester in which the student is enrolled in.
     *
     * @return the semester of the student.
     */
    public int getSemester() {
        return semester;
    }

    /**
     * A getter method returning the VIA ID of the student.
     *
     * @return the VIA ID of the student.
     */
    public int getViaId() {
        return viaId;
    }

    /**
     * A method returning the String representation of the Student object.
     *
     * @return A string containing the name, the semester, and the VIA ID of the Student object.
     */
    public String toString() {
        return "\nName:" + name + "\nSemester:" + semester + "\nVia ID:" + viaId
                + "\n";
    }

    /**
     * A method comparing two Student objects.
     *
     * @param obj an object representing the other object to be compared.
     * @return "True" if the compared Student objects are the same, or "False" if they are different objects.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return name.equals(other.name) && viaId == other.viaId
                && semester == other.semester;
    }
}
