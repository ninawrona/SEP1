package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.files.ReadWrite;

import model.list.ClassGroupList;
import model.list.CourseList;
import model.list.RoomList;
import model.list.ScheduleModel;

import java.io.File;

/**
 * A class allowing the user to upload text files.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class FileViewController
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextField studentsField;
  @FXML private TextField coursesField;
  @FXML private TextField roomsField;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  //Counter if the files have been already added.
  private int counter = 0;
  private File fileStudents = null;
  private File fileCourses = null;
  private File fileRooms = null;

  /**
   * A zero-argument constructor called by FXML Loader.
   */
  public FileViewController()
  {
    // Called by FXMLLoader
  }

  /**
   * A void method initializing all the non-FXML variables.
   *
   * @param viewHandler A ViewHandler object which will be used to set this class 'viewHandler' variable.
   * @param model       A ScheduleModel object which will be used to set this class 'model' variable.
   * @param root        A Region object which will be used to set this class 'root' variable.
   */
  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    fileStudents = new File("Students.txt");
    fileCourses = new File("Courses.txt");
    fileRooms = new File("Rooms.txt");
    studentsField.setText(fileStudents.getAbsolutePath());
    coursesField.setText(fileCourses.getAbsolutePath());
    roomsField.setText(fileRooms.getAbsolutePath());
    reset();
  }

  /**
   * A getter method of Region object.
   *
   * @return A Region object - 'root'.
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * A void method setting the error label to empty String.
   */
  public void reset()
  {
    errorLabel.setText("");
  }

  // @FXML methods here

  /**
   * A void FXML method controlling the button.
   * When clicked in GUI it opens a file browser.
   * It sets a text field to the absolute path of the chosen file
   */
  @FXML private void selectStudentsFileButton()
  {
    FileChooser fileChooser = new FileChooser();
    fileStudents = fileChooser.showOpenDialog(null);

    if (fileStudents != null)
    {
      char[] fileNameArray = fileStudents.getName().toCharArray();
      if (fileNameArray[fileNameArray.length - 3] == 't'
          && fileNameArray[fileNameArray.length - 2] == 'x'
          && fileNameArray[fileNameArray.length - 1] == 't')
      {
        studentsField.setText(fileStudents.getAbsolutePath());
      }
    }
  }

  /**
   * A void FXML method controlling the button.
   * When clicked in GUI it opens a file browser.
   * It sets a text field to the absolute path of the chosen file.
   */
  @FXML private void selectCoursesFileButton()
  {
    FileChooser fileChooser = new FileChooser();
    fileCourses = fileChooser.showOpenDialog(null);
    if (fileCourses != null)
    {
      char[] fileNameArray = fileCourses.getName().toCharArray();
      if (fileNameArray[fileNameArray.length - 3] == 't'
          && fileNameArray[fileNameArray.length - 2] == 'x'
          && fileNameArray[fileNameArray.length - 1] == 't')
      {
        coursesField.setText(fileCourses.getAbsolutePath());
      }
    }
  }

  /**
   * A void FXML method controlling the button.
   * When clicked in GUI it opens a file browser.
   * It sets a text field to the absolute path of the chosen file.
   */
  @FXML private void selectRoomsFileButton()
  {
    FileChooser fileChooser = new FileChooser();
    fileRooms = fileChooser.showOpenDialog(null);
    if (fileRooms != null)
    {
      char[] fileNameArray = fileRooms.getName().toCharArray();
      if (fileNameArray[fileNameArray.length - 3] == 't'
          && fileNameArray[fileNameArray.length - 2] == 'x'
          && fileNameArray[fileNameArray.length - 1] == 't')
      {
        roomsField.setText(fileRooms.getAbsolutePath());
      }
    }
  }

  /**
   * A void FXML method which confirms all the selected files
   * and updates the model with the given data.
   */
  @FXML private void confirmInSelectATextFileButton()
  {
    if (counter == 0)
    {
      if (fileStudents != null && fileRooms != null && fileCourses != null)
      {
        model.getAllClasses().manualReadStudents(fileStudents);
        model.getAllClasses().manualReadCourses(fileCourses);
        model.setRoomList(ReadWrite.manualReadRooms(fileRooms));
        model
            .setAllTeachers(ReadWrite.manualReadMasterTeacherList(fileCourses));
      }
      viewHandler.closeView();
      viewHandler.openView("schedule");
      counter++;
    }
    else
    {
      errorLabel.setText(
          "File already uploaded!\n If you want to upload the files then restart the program");
    }

  }

  /**
   * A void FXML method closing the current view and opening schedule view.
   */
  @FXML private void cancelInSelectATextFileButton()
  {
    viewHandler.openView("schedule");
  }

}

