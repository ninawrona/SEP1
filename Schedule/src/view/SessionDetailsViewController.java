package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.beans.property.StringProperty;
import model.list.ScheduleModel;

public class SessionDetailsViewController
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextArea courseDetailsField;
  @FXML private TextArea classDetailsField;
  @FXML private TextArea teachersDetailsField;
  @FXML private TextArea studentsDetailsField;
  @FXML private TextArea startTimeField;
  @FXML private TextArea roomDetailsField;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;

  public SessionDetailsViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
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
  }

  // @FXML methods here

  public void courseDetailsButton(){
    viewHandler.openView("courseDetails");
    reset();
  }

  public void cancelInSessionDetailsViewButton(){
    viewHandler.openView("schedule");
    reset();
  }

}

