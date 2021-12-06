package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.list.ScheduleModel;

public class AddTeacherViewController
{
  //@FXML private methods here
  @FXML private TextField teachersViaIdField;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;

  public AddTeacherViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, Region root, ScheduleModel model)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    errorLabel.setText("");
    teachersViaIdField.setText("");
  }

  // @FXML methods here
  @FXML private void confirmAddATeacherButton()
  {
    //TODO confirm
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }

  @FXML private void cancelAddATeacherButton()
  {
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }

}
