package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import model.list.ScheduleModel;

/**
 * A class handling all the occurring views in the system.
 *
 * @author Christian Foyer, Kamil Fischbach, Martin Rosendahl, Nina Wrona, Robert Barta
 * @version 3-10 December 2021
 */
public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ScheduleModel model;
  private AddSessionViewController addSessionViewController;
  private AddStudentViewController addStudentViewController;
  private AddTeacherViewController addTeacherViewController;
  private ClassSelectViewController classSelectViewController;
  private CourseDetailsViewController courseDetailsViewController;
  private FileViewController fileViewController;
  private SessionDetailsViewController sessionDetailsViewController;
  private ScheduleGridViewController scheduleGridViewController;
  private ChooseWeekViewController chooseWeekViewController;
  private SelectTeacherViewController selectTeacherViewController;
  private MimicScheduleViewController mimicScheduleViewController;
  // more controllers here

  /**
   * A one argument constructor intializing currentScene and setting the variable model to given model.
   *
   * @param model A ScheduleModel object which is used to set ViewHandler's model variable.
   */
  public ViewHandler(ScheduleModel model)
  {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

  /**
   * A void method starting the system and setting the primary stage variable to given primaryStage.
   * Icon made By jocularityart.
   *
   * @param primaryStage a Stage object which is used to set ViewHandler's primaryStage variable.
   */
  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("schedule");
    Image icon = new Image("gingerbread.png");
    primaryStage.getIcons().add(icon);
    scheduleGridViewController.reset();
  }

  /**
   * A void method opening the view with the given name. Legal names are:[addSession, addStudent, addTeacher, chooseWeek, classSelect, courseDetails, fileView, mimicSchedule, schedule, selectTeacher, sessionDetails]
   *
   * @param name a String object
   */
  public void openView(String name)
  {
    Region root = null;
    switch (name)
    {
      case "addSession":
        root = loadAddSessionView("AddSessionView.fxml");
        break;
      case "classSelect":
        root = loadClassSelectView("ClassSelectView.fxml");
        break;
      case "fileView":
        root = loadFileView("FileView.fxml");
        break;
      case "schedule":
        root = loadScheduleGridView("ScheduleGridView.fxml");
        break;
      case "sessionDetails":
        root = loadSessionDetailsView("SessionDetailsView.fxml");
        break;
      case "addStudent":
        root = loadAddStudentView("AddStudent.fxml");
        break;
      case "addTeacher":
        root = loadAddTeacherView("AddTeacher.fxml");
        break;
      case "courseDetails":
        root = loadCourseDetailsView("CourseDetailsView.fxml");
        break;
      case "chooseWeek":
        root = loadChooseWeekView("ChooseWeekView.fxml");
        break;

      case "selectTeacher":
        root = loadSelectTeacherView("SelectTeacher.fxml");
        break;

      case "mimicSchedule":
        root = loadMimicScheduleView("MimicScheduleView.fxml");
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

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadSelectTeacherView(String fxmlFile)
  {
    if (selectTeacherViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        selectTeacherViewController = loader.getController();
        selectTeacherViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      selectTeacherViewController.reset();
    }
    return selectTeacherViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
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
        addSessionViewController.init(this, model, root);
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

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadScheduleGridView(String fxmlFile)
  {
    if (scheduleGridViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        scheduleGridViewController = loader.getController();
        scheduleGridViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      scheduleGridViewController.reset();
    }
    return scheduleGridViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadSessionDetailsView(String fxmlFile)
  {
    if (sessionDetailsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        sessionDetailsViewController = loader.getController();
        sessionDetailsViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      sessionDetailsViewController.reset();
    }
    return sessionDetailsViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadFileView(String fxmlFile)
  {
    if (fileViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        fileViewController = loader.getController();
        fileViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      fileViewController.reset();
    }
    return fileViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadCourseDetailsView(String fxmlFile)
  {
    if (courseDetailsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        courseDetailsViewController = loader.getController();
        courseDetailsViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      courseDetailsViewController.reset();
    }
    return courseDetailsViewController.getRoot();

  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadClassSelectView(String fxmlFile)
  {
    if (classSelectViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        classSelectViewController = loader.getController();
        classSelectViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      classSelectViewController.reset();
    }
    return classSelectViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadAddStudentView(String fxmlFile)
  {
    if (addStudentViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addStudentViewController = loader.getController();
        addStudentViewController.init(this, root, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addStudentViewController.reset();
    }
    return addStudentViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadAddTeacherView(String fxmlFile)
  {
    if (addTeacherViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addTeacherViewController = loader.getController();
        addTeacherViewController.init(this, root, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addTeacherViewController.reset();
    }
    return addTeacherViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadChooseWeekView(String fxmlFile)
  {
    if (chooseWeekViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        chooseWeekViewController = loader.getController();
        chooseWeekViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      chooseWeekViewController.reset();
    }
    return chooseWeekViewController.getRoot();
  }

  /**
   * A method loading a view by given String object name of the file.
   *
   * @param fxmlFile A String object which is a name of the file.
   * @return A Region Object of this specific view.
   */
  private Region loadMimicScheduleView(String fxmlFile)
  {
    if (mimicScheduleViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        mimicScheduleViewController = loader.getController();
        mimicScheduleViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      mimicScheduleViewController.reset();
    }
    return mimicScheduleViewController.getRoot();
  }

  /**
   * A void method closing the current view.
   */
  public void closeView()
  {
    primaryStage.close();
  }

}
