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

  // View strings: add, classSelect, confirmation, courseDetails, fileView, schedule, sessionDetails
  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "add":
        // root = loadAddSessionLView(filepath);
        break;
      case "classSelect":
        // root = loadClassSelectView(filepath);
        break;
      case "confirmation":
        // root = loadConfirmationView(filepath);
        break;
      case "courseDetails":
        // root = loadCourseDetailsView(filepath);
        break;
      case "fileView":
        // root = loadFileView(filepath);
        break;
      case "schedule":
        // root = loadScheduleView(filepath);
        break;
      case "sessionDetails":
        // root = loadSessionDetailsView(filepath);
        break;
    }

    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadAddSessionView(String fxmlFile)
  {
    if (addSessionViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addSessionViewController = loader.getController();
        // addSessionViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addSessionViewController.reset();
    }
    return addSessionViewController.getRoot();
  }
}
