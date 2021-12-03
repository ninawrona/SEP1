package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.files.ReadWrite;
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
    File file = fileChooser.showOpenDialog(null);

    if (file != null) {
      char[] fileNameArray = file.getName().toCharArray();
      if( fileNameArray[fileNameArray.length-3]=='t' && fileNameArray[fileNameArray.length-2]=='x' && fileNameArray[fileNameArray.length-1]=='t')
      {
        studentsField.setText(file.getAbsolutePath());

      }
    }
  }


  @FXML void selectCoursesFileButton()
  {
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      coursesField.setText(file.getName());

    }
  }

  @FXML void selectRoomsFileButton()
  {
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      roomsField.setText(file.getName());
    }
  }

  @FXML void confirmInSelectATextFileButton()
  {
    // Do something with this button to open the file at the path
    filePathField.getText();
    viewHandler.openView("schedule");
  }

  @FXML void cancelInSelectATextFileButton()
  {
    viewHandler.openView("schedule");
  }
}

