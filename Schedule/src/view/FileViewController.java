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

public class FileViewController
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextArea filePathField;//There is no such id in the FMXL file
  @FXML private TextField studentsField;
  @FXML private TextField coursesField;
  @FXML private TextField roomsField;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private FileChooser fileChooser;
  private Stage primaryStage;

  private File fileStudents = null;
  private File fileCourses = null;
  private File fileRooms = null;

  public FileViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    fileChooser = new FileChooser();
    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");
  }

  // @FXML methods here

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

  @FXML void selectCoursesFileButton()
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
        coursesField.setText(fileCourses.getName());
      }
    }
  }

  @FXML void selectRoomsFileButton()
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
        roomsField.setText(fileRooms.getName());
      }
    }
  }

  @FXML void confirmInSelectATextFileButton()
  {
    if (fileStudents != null && fileRooms != null && fileCourses != null)
    {
      ClassGroupList classGroupList = null;
      RoomList roomList = null;
      CourseList courseList = null;

      classGroupList = ReadWrite.manualReadStudents(fileStudents);
      roomList = ReadWrite.manualReadRooms(fileRooms);
      courseList = ReadWrite.manualReadCourses(fileCourses);

      //Make methods to parse this list to our system.

      for (int i = 0; i < courseList.size(); i++)
      {
        model.addCourse(courseList.get(i));
      }
      for (int i = 0; i < roomList.size(); i++)
      {
        model.setRoomList(roomList);
      }
      for (int i = 0; i < classGroupList.size(); i++)
      {
        model.addClassGroupList(classGroupList);
      }

    }
    // Do something with this button to open the file at the path
    filePathField.getText();
    viewHandler.closeView();
    viewHandler.openView("schedule");
  }

  @FXML void cancelInSelectATextFileButton()
  {
    viewHandler.openView("schedule");
  }
}

