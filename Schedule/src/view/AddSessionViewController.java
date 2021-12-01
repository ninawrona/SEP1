package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSessionViewController implements Initializable
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private ChoiceBox<> courseChoiceBoxInAddSession;
  @FXML private ChoiceBox<> startTimeChoiceBox;
  @FXML private ChoiceBox<> numberOfLessonsChoiceBox;
  @FXML private ChoiceBox<> roomsChoiceBox;
  private Region root;
  private ViewHandler viewHandler;
  //private ScheduleModel model;

  public AddSessionViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, Region root) // add model when made
  {
    this.viewHandler = viewHandler;
    this.root = root;
    // this.model = model;
    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    // set text to ""
  }

  //here we add our list of choices from an arrayList
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    courseChoiceBoxInAddSession.getItems().addAll(allCoursesArray);
    startTimeChoiceBox.getItems().addAll(timeArray);
    numberOfLessonsChoiceBox.getItems().addAll(numberOfLessonsArray); //int array I suppose
    roomsChoiceBox.getItems().addAll(roomsArray); //rooms that are currently available, we have to change
                                                  // the array after clicking find rooms
  }

  // @FXML methods here
}
