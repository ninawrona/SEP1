package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.list.ScheduleModel;

public class FileViewController
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextArea filePathField;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;

  public FileViewController()
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

