package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
// import model.ScheduleModel;

public class ViewHandler {
    private Scene currentScene;
    private Stage primaryStage;
    // private ScheduleModel model;
    private AddSessionViewController addSessionViewController;
    private AddStudentViewController addStudentViewController;
    private AddTeacherViewController addTeacherViewController;
    private ClassSelectViewController classSelectViewController;
    private ConfirmationViewController confirmationViewController;
    private CourseDetailsViewController courseDetailsViewController;
    private FileViewController fileViewController;
    private ScheduleViewController scheduleViewController;
    private SessionDetailsViewController sessionDetailsViewController;
    // more controllers here

  /* public ViewHandler(ScheduleModel model)
  {
    this.currentScene = new Scene(new Region());
    this.model = model;
  }

   */

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        //openview("schedule");
        addSessionViewController.reset();
        Image icon = new Image("gingerbread.png");
        //Icon made By jocularityart
        primaryStage.getIcons().add(icon);
        // More controllers here
    }

    // View strings: add, classSelect, confirmation, courseDetails, fileView, schedule, sessionDetails
    public void openView(String id) {
        Region root = null;
        switch (id) {
            case "addSession":
                root = loadAddSessionLView("AddSessionView.fxml");
                break;
            case "classSelect":
                root = loadClassSelectView("ClassSelectView.fxml");
                break;
            case "confirmation":
                root = loadConfirmationView("ConfirmationView.fxml");
                break;
            case "courseDetails":
                root = loadCourseDetailsView("CourseDetailsView.fxml");
                break;
            case "fileView":
                root = loadFileView("FileView.fxml");
                break;
            case "schedule":
                root = loadScheduleView("ScheduleView.fxml");
                break;
            case "sessionDetails":
                root = loadSessionDetailsView("SessionDetailsView.fxml");
                break;
            case "addStudent":
                root = loadSessionDetailsView("AddStudent.fxml");
                break;
            case "addTeacher":
                root = loadSessionDetailsView("AddTeacher.fxml");
                break;
        }

        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null) {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    private Region loadAddSessionLView(String fxmlFile) {
        if (addSessionViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addSessionViewController = loader.getController();
                // loadClassSelectViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            addSessionViewController.reset();
        }
        return addSessionViewController.getRoot();
    }

    private Region loadSessionDetailsView(String fxmlFile) {
        if (sessionDetailsViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                sessionDetailsViewController = loader.getController();
                // loadClassSelectViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            sessionDetailsViewController.reset();
        }
        return sessionDetailsViewController.getRoot();
    }

    private Region loadScheduleView(String fxmlFile) {
        if (scheduleViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                scheduleViewController = loader.getController();
                // loadClassSelectViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            scheduleViewController.reset();
        }
        return scheduleViewController.getRoot();
    }

    private Region loadFileView(String fxmlFile) {
        if (fileViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                fileViewController = loader.getController();
                // loadClassSelectViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            fileViewController.reset();
        }
        return fileViewController.getRoot();
    }

    private Region loadCourseDetailsView(String fxmlFile) {
        if (courseDetailsViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                courseDetailsViewController = loader.getController();
                // loadClassSelectViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            courseDetailsViewController.reset();
        }
        return courseDetailsViewController.getRoot();

    }

    public void closeView() {
        primaryStage.close();
    }


    private Region loadConfirmationView(String fxmlFile) {
        if (confirmationViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                confirmationViewController = loader.getController();
                // loadClassSelectViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            confirmationViewController.reset();
        }
        return confirmationViewController.getRoot();
    }

    private Region loadClassSelectView(String fxmlFile) {
        if (classSelectViewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                classSelectViewController = loader.getController();
                // loadClassSelectViewController.init(this, model, root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            classSelectViewController.reset();
        }
        return classSelectViewController.getRoot();
    }


}
