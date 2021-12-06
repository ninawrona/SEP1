package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.list.ScheduleModel;

public class AddStudentViewController
{

  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextField studentsNameField;
  @FXML private TextField studentsViaIdField;
  @FXML private TextField classField;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private String name = null;
  private int viaId = 0;
  private String className = null;

  public AddStudentViewController()
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
    studentsNameField.setText("");
    studentsViaIdField.setText("");
    classField.setText("");
  }
  // @FXML methods here

  @FXML private void confirmAddAStudentButton()
  {
    try
    {
      name = studentsNameField.getText();
      viaId = Integer.parseInt(studentsViaIdField.getText());
      className = classField.getText();
      if (name != null && !name.equals("") && viaId != 0 && className != null
          && className.length() == 2)
      {
        //TODO add the student to the chosen course
      }
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
    viewHandler.closeView();
    viewHandler.openView("courseDetails");

  }

  @FXML private void cancelAddAStudentButton()
  {
    viewHandler.closeView();
    viewHandler.openView("courseDetails");
  }

}
