package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
// import model.ScheduleModel;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  // private ScheduleModel model;
  private AddSessionViewController addSessionViewController;
  // more controllers here

  /* public ViewHandler(ScheduleModel model)
  {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

   */

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    //openview("schedule");
    addSessionViewController.reset();
    // More controllers here
  }

  // View strings: schedule, add,
}
