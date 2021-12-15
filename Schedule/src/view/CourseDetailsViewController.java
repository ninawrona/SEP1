package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.basic.Student;
import model.basic.Teacher;
import model.list.ScheduleModel;
import model.list.StudentList;

import java.util.ArrayList;

/**
 * The CourseDetailsViewController class handles the functionality of the window wherein the planner can see and make changes to the participant of a course.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 1 - 2 December 2021
 */
public class CourseDetailsViewController {
    //@FXML private methods here
    @FXML
    private Label errorLabel;
    @FXML
    private TextArea courseNameField;
    @FXML
    private TextArea semesterField;
    @FXML
    private TextArea ectsPointsField;
    @FXML
    private ChoiceBox<Teacher> teacherChoice;
    @FXML
    private ChoiceBox<Student> studentChoice;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleModel model;

    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Teacher> teacherList = new ArrayList<>();

    /**
     * Constructor for the CourseDetailsViewController which is called by the FXMLLoader.
     */
    public CourseDetailsViewController() {
        // Called by FXMLLoader
    }

    /**
     * Method for initializing all the variables
     *
     * @param viewHandler A ViewHandler controlling what View we see. We are setting CourseDetailsViewController's viewHandler to this.
     * @param model       A ScheduleModel object that we set the CourseDetailsViewController model's to.
     * @param root        A Region root that we set CourseDetailsViewController's Region root to.
     */
    public void init(ViewHandler viewHandler, ScheduleModel model, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = model;

        System.out.println("Ects: " + model.getChosenSession().getCourse().getECTS());
        courseNameField.setText("" + model.getChosenSession().getCourse().getFullName());
        semesterField.setText("" + model.getChosenClassGroup().getSemester());
        ectsPointsField.setText("" + model.getChosenSession().getCourse().getECTS());
        reset();
    }

    /**
     * Method to get the Region root.
     *
     * @return returns Region root.
     */
    public Region getRoot() {
        return root;
    }

    public void reset() {
        errorLabel.setText("");
        //set the areas to the chosen class and course.

        studentChoice.getItems().removeAll(studentList);
        teacherChoice.getItems().removeAll(teacherList);
        studentChoice.setValue(null);
        teacherChoice.setValue(null);
        courseNameField.setText("" + model.getChosenSession().getCourse().getFullName());
        loadStudentArray();
        loadTeacherArray();

    }

    /**
     * Method for loading students array.
     * Empties the studentList and then adds the model's students to the student
     * list and loads them into the studentChoiceBox.
     */
    public void loadStudentArray() {
        studentList.removeAll(studentList);

        try {
            for (int i = 0; i < model.getChosenSession().getCourse().getStudents().size(); i++) {
                studentList.add(model.getChosenSession().getCourse().getStudents().get(i));
            }
            studentChoice.getItems().addAll(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for loading the Teachers.
     * First it empties the teacher list and then it gets the model's teachers
     * and adds them to the teacher list. Then it loads it into the TeacherChoiceBox.
     */
    public void loadTeacherArray() {
        teacherList.removeAll(teacherList);

        try {
            for (int i = 0; i < model.getChosenSession().getTeachers().size(); i++) {
                teacherList.add(model.getChosenSession().getTeachers().get(i));
            }
            teacherChoice.getItems().addAll(teacherList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // @FXML methods here

    /**
     * Method for addTeacherButton. ViewHandler closes the view and opens the
     * "add teacher" view.
     */
    @FXML
    private void addTeacherButton() {
        viewHandler.closeView();
        viewHandler.openView("addTeacher");
    }

    /**
     * Method for removeTeacherButton. Removes the selected teacher and then resets.
     */
    @FXML
    private void removeTeacherButton() {
        try {
            model.getChosenSession().getTeachers().removeTeacher(teacherChoice.getValue());
            reset();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    /**
     * Method for the addStudentButton.
     * viewHandler closes the view and then opens the "addStudent view"
     */
    @FXML
    private void addStudentButton() {
        viewHandler.closeView();
        viewHandler.openView("addStudent");
    }

    /**
     * Method for the removeStudentButton. Removes the selected student and then
     * resets;
     */
    @FXML
    private void removeStudentButton() {
        try {
            model.getChosenSession().getCourse().removeStudent(studentChoice.getValue());
            reset();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
        System.out.println("List of current students");
        System.out.println(model.getChosenSession().getCourse().getStudents().toString());
    }

    /**
     * Method for cancelButton. ViewHandler closes view and then opens "schedule"
     */
    @FXML
    private void cancelButton() {
        viewHandler.closeView();
        viewHandler.openView("schedule");
    }
}

