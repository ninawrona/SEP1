package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.beans.property.StringProperty;
import model.list.ScheduleModel;
import model.basic.*;

/**
 * A class handling the display of the details of the chosen Session object.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class SessionDetailsViewController
{
  //@FXML private methods here
  @FXML private Label errorLabel;
  @FXML private TextArea courseDetailsField;
  @FXML private TextArea classDetailsField;
  @FXML private TextArea startTimeField;
  @FXML private TextArea endTimeField;
  @FXML private TextArea roomDetailsField;
  private Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private Session chosenSession;

  /**
   * A zero-argument constructor called by FXML Loader.
   */
  public SessionDetailsViewController()
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
    this.chosenSession = model.getChosenSession();
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
   * A void method setting the error label to empty String and all fields to chosen session details.
   */
  public void reset()
  {
    chosenSession = model.getChosenSession();
    errorLabel.setText("");
    courseDetailsField.setText("" + chosenSession.getCourse().getFullName());
    classDetailsField.setText("" + chosenSession.getCourse().getClassGroup());
    startTimeField.setText("" + chosenSession.getStartTimeString());
    endTimeField.setText("" + chosenSession.getEndTimeString());
    roomDetailsField.setText("" + chosenSession.getRoom());
  }

  // @FXML methods here

  /**
   * A void FXML method removing the chosen session from the model and opening the schedule view.
   */
  @FXML private void removeSessionButton()
  {
    model.removeSession(chosenSession);
    viewHandler.openView("schedule");
  }

  /**
   * A void FXML opening the course details view for the chosen session's view.
   */
  @FXML private void courseDetailsButton()
  {
    viewHandler.openView("courseDetails");
  }

  /**
   * A void FXML method closing the current view and opening schedule view.
   */
  @FXML private void cancelInSessionDetailsViewButton()
  {
    viewHandler.openView("schedule");
  }

}

