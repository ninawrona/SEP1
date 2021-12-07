package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.layout.Region;
import model.basic.Time;
import model.list.*;

public class ScheduleViewController
{
  //@FXML private methods here
  @FXML Label errorLabel;
  @FXML Label classNameLabel;
  @FXML private TableView<SessionViewModel> scheduleTable;
  @FXML private TableColumn<SessionViewModel, String> timeColumn;
  @FXML private TableColumn<SessionViewModel, String> mondayColumn;
  @FXML private TableColumn<SessionViewModel, String> tuesdayColumn;
  @FXML private TableColumn<SessionViewModel, String> wednesdayColumn;
  @FXML private TableColumn<SessionViewModel, String> thursdayColumn;
  @FXML private TableColumn<SessionViewModel, String> fridayColumn;

  private Region root;
  private ViewHandler viewHandler;
  private ScheduleViewModel scheduleViewModel;
  private ScheduleModel model;

  public ScheduleViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.scheduleViewModel = new ScheduleViewModel(model);

    errorLabel.setText("");
    System.out.println("Model List: " + scheduleViewModel.getList().toString());

    System.out.println("We entered the creation of table.");
    timeColumn.setCellValueFactory(cellData -> cellData.getValue().getStartTimeProperty());
    /*switch (scheduleViewModel.getList().getDayOfWeekProperty())
        {
          case 1:
          {
            mondayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getCourseProperty());
          }
          case 2:
          {
            tuesdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getCourseProperty());
          }
          case 3:
          {
            wednesdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getCourseProperty());
          }
          case 4:
          {
            thursdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getCourseProperty());
          }
          case 5:
          {
            fridayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getCourseProperty());
          }
          default:
          {
            mondayColumn.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper("Default"));
          }
    }*/

      mondayColumn.setCellValueFactory(cellData -> cellData.getValue().getCourseProperty());
      //scheduleTable.setItems();
      scheduleTable.setItems(scheduleViewModel.getList());
      // The method below should fetch all the session to display
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    // set text to ""
    errorLabel.setText("");
    if (model.getChosenClassGroup() != null)
    {
      // System.out.println("Tried");
      classNameLabel.setText("Class: " + model.getChosenClassGroup().toString());
      scheduleViewModel.update();
    }
    else
    {
      //  System.out.println("class not chosen yet");
      classNameLabel.setText("Class: ");
      errorLabel.setText("Please select a class");
    }

  }

  // @FXML methods here

  @FXML private void chooseClassButton()
  {
    viewHandler.openView("classSelect");
  }

  @FXML private void uploadFilesButton()
  {
    viewHandler.openView("fileView");
  }

  @FXML private void addSessionButton()
  {
    model.setChosenClassGroup(model.getChosenClassGroup());
    viewHandler.openView("addSession");
  }

  @FXML private void removeSessionButton()
  {
    viewHandler.openView("removeSession");
  }

  @FXML private void sessionDetailsButton()
  {
    viewHandler.openView("courseDetails");
  }

  @FXML private void exitButton()
  {
    viewHandler.closeView();
  }

}
