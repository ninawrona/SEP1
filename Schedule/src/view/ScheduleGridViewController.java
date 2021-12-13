package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.basic.Date;
import model.basic.Session;
import model.basic.Time;
import model.files.ReadWrite;
import model.files.XMLParser;
import model.list.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class ScheduleGridViewController
{
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private Region root;
  private ScheduleViewModel scheduleViewModel;
  private int chosenWeekNumber;
  // private AddSessionViewController addSessionViewController;

  //@FXML
  //private Label weekLabel;

  @FXML private Label weekLabel;
  @FXML private Label errorLabel;
  @FXML private Label classNameLabel;
  @FXML private Label label11;
  @FXML private Label label12;
  @FXML private Label label13;
  @FXML private Label label14;
  @FXML private Label label15;
  @FXML private Label label20;
  @FXML private Label label30;
  @FXML private Label label40;
  @FXML private Label label50;
  @FXML private Label label60;
  @FXML private Label label70;
  @FXML private Label label80;
  @FXML private Label label90;
  @FXML private Label label100;
  @FXML private Label label110;
  @FXML private Label label120;
  @FXML private GridPane gridPane;

  public ScheduleGridViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    this.scheduleViewModel = new ScheduleViewModel(model);
    // This gridpane is already set above.
    // this.gridPane = new GridPane();
    // this.addSessionViewController = new AddSessionViewController();

    label11.setText("Monday");
    label12.setText("Tuesday");
    label13.setText("Wednesday");
    label14.setText("Thursday");
    label15.setText("Friday");
    label20.setText("8:20");
    label30.setText("9:15");
    label40.setText("10:10");
    label50.setText("11:05");
    label60.setText("12:00");
    label70.setText("12:45");
    label80.setText("13:40");
    label90.setText("14:35");
    label100.setText("15:30");
    label110.setText("16:25");
    label120.setText("17:20");
    weekLabel.setText("Select week");
    reset();
    // Commented out for debugging - CF
            /*try{
                Label label = (Label) getNodeByRowColumnIndex(1, 1, gridPane);
                System.out.println(label);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("sth is wrong again, but does it work?");
            }

             */

    //label01.setText(addSessionViewController.timeArray.get(0));
        /*
        // Testing adding a button
        Button test1 = new Button();
        test1.setText("Test");
        gridPane.add(test1, 4, 4, 1, 1);
        System.out.println("I just tried to add the test");

         */

    //populate the grid pane for the first time
        /* moving to reset
        for (int i = 0; i < scheduleViewModel.getList().size(); i++) {
            StringProperty courseName = scheduleViewModel.getList().get(i).getCourseProperty();
            Label labelTest = new Label();
            labelTest.setText(courseName.get());
            int startTimeInt = scheduleViewModel.getList().get(i).getStartTimeIntProperty();
            int numberOfLessonsInt = scheduleViewModel.getList().get(i).getNumberOfLessonsProperty().intValue();
            int dayOfWeek = scheduleViewModel.getList().get(i).getDayOfWeekProperty().getValue();


            gridPane.add(labelTest, dayOfWeek, startTimeInt, 1, numberOfLessonsInt);
            gridPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //Node nodeHandler = getNodeByRowColumnIndex(dayOfWeek, startTimeInt, gridPane);
                    System.out.println(gridPane.getChildren());
                    //gets the X and Y of where you clicked
                    double clickX = Math.floor(mouseEvent.getX());
                    double clickY = Math.floor(mouseEvent.getY());

                    //Prints out the nodes x/y so that we can see location. the plan is to get the XY of the node we want and compare it to the X Y of where we clicked?
                    System.out.println("X:" + clickX + "\nY:" + clickY);
                    for (int i = 0; i < gridPane.getChildren().size(); i++){
                        System.out.println("X:" + gridPane.getChildren().get(i).getLayoutX() + "\nY:" + gridPane.getChildren().get(i).getLayoutY());
                    }
                    //tried to remove at x,y but they are not the same as row and column
                   // gridPane.getChildren().remove(getNodeByRowColumnIndex((int)clickY,(int)clickX,gridPane));

                    //when you print out properties it says what row and column and span the session is
                    /*
                    for (int i = 0; i < gridPane.getChildren().size(); i++){
                    Object node = gridPane.getChildren().get(i).getProperties().get(getNodeByRowColumnIndex((int)clickY,(int)clickX,gridPane));
                    System.out.println(gridPane.getChildren().get(i).getProperties());
                    }

                     */
    // gridPane.getChildren().remove(gridPane.getChildren().getLayoutX(), startTimeInt));
  }

  public Node getNodeByRowColumnIndex(final int row, final int column,
      GridPane gridPane)
  {
    Node result = null;
    ObservableList<Node> childrens = gridPane.getChildren();

    if (childrens.size() != 0)
    {

      for (Node node : childrens)
      {
        if (gridPane.getRowIndex(node) == row
            && gridPane.getColumnIndex(node) == column)
        {
          result = node;
          break;
        }
      }
    }
    return result;
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    System.out.println("I am resetting the schedule grid window");
    // set text to ""
    if (model.getChosenWeekNumber() != 0)
    {
      Date monday = model.getChosenMonday();
      Date friday = monday.copy();
      friday.stepForward(4);
      weekLabel.setText(
          "Week " + model.getChosenWeekNumber() + ": " + " " + monday.getDay()
              + "/" + monday.getMonth() + " - " + friday.getDay() + "/" + friday
              .getMonth());
      //weekLabel.setText("Test");
    }
    else
    {
      //The week set to the week of today's date, if it is Saturday or Sunday
      //It is moved to next week
      Date today = new Date();
      if (today.getWeekday().equals("SATURDAY"))
      {
        today.stepForward(2);
      }
      else if (today.getWeekday().equals("SUNDAY"))
      {
        today.stepForwardOneDay();
      }
      LocalDate date = LocalDate
          .of(today.getYear(), today.getMonth(), today.getDay());
      chosenWeekNumber = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
      model.setChosenWeekNumber(chosenWeekNumber);
      System.out
          .println("I just set the week to " + model.getChosenWeekNumber());
      // Holder
      System.out.println("I'm finding the monday");
      LocalDate mondayHolder = date;
      while (mondayHolder.getDayOfWeek().getValue() != 1)
      {
        System.out.println(mondayHolder);
        mondayHolder = mondayHolder.minusDays(1);
        System.out.println("I just moved back one day");
        System.out.println("Holder is now " + mondayHolder);
      }
      Date monday = new Date(mondayHolder.getDayOfMonth(),
          mondayHolder.getMonthValue(), mondayHolder.getYear());
      model.setChosenMonday(monday);
      System.out.println("I just set the Monday to " + monday);

      Date friday = monday.copy();
      friday.stepForward(4);
      weekLabel.setText(
          "Week " + model.getChosenWeekNumber() + ": " + " " + monday.getDay()
              + "/" + monday.getMonth() + " - " + friday.getDay() + "/" + friday
              .getMonth());

    }
    errorLabel.setText("Please upload the text files.");
    if (model.getAllTeachers().size()!=0)
    {

      errorLabel.setText("Please select a Class or a Teacher.");
      if(model.getChosenClassGroup()!=null)
      {
        classNameLabel
            .setText("Class: " + model.getChosenClassGroup().toString());
        errorLabel.setText("");
      }
    }
    /*
    else
    {
      classNameLabel.setText("Class: ");
      errorLabel.setText("Please select a class");
    }

     */

    // Clear the grid
    for (int i = 0; i < gridPane.getChildren().size(); i++)
    {
      // System.out.println("I'm looking at " + gridPane.getChildren().get(i));
      if (gridPane.getChildren().get(i).getId() != null)
      {
        // System.out.println("The id is " + gridPane.getChildren().get(i).getId());
        if (gridPane.getChildren().get(i).getId().contains("session"))
        {
          // System.out.println("removing");
          gridPane.getChildren().remove(i);
          i--;
        }
      }
    }
    // This is a practice for finding sessions by class group and date
    // The goal is to find all sessions from monday to Friday for a given class

    scheduleViewModel.update();
    // Populate the grid
    try
    {
      for (int i = 0;
           i < scheduleViewModel.getListByDateAndClassGroup().size(); i++)
      {
        StringProperty courseName = scheduleViewModel
            .getListByDateAndClassGroup().get(i).getCourseProperty();
        Label labelTest = new Label();
        labelTest.setText(courseName.get());
        // String nodeId = "session" + i;
        labelTest.setId("session" + i);

        // Adds a background color to the session on the grid
        String backColor = "lavender";
        String courseHolder =
            "" + scheduleViewModel.getListByDateAndClassGroup().get(i)
                .getCourseProperty();
        if (courseHolder.contains("RWD"))
        {
          backColor = "lightblue";
        }
        if (courseHolder.contains("DMA"))
        {
          backColor = "lightseagreen";
        }
        if (courseHolder.contains("SDJ"))
        {
          backColor = "burlywood";
        }
        if (courseHolder.contains("SEP"))
        {
          backColor = "indianred";
        }
        labelTest.setBackground(new Background(
            new BackgroundFill(Paint.valueOf(backColor), null, null)));

        int startTimeInt = scheduleViewModel.getListByDateAndClassGroup().get(i)
            .getStartTimeIntProperty();
        int numberOfLessonsInt = scheduleViewModel.getListByDateAndClassGroup()
            .get(i).getNumberOfLessonsProperty().intValue();
        int dayOfWeek = scheduleViewModel.getListByDateAndClassGroup().get(i)
            .getDayOfWeekProperty().getValue();

        labelTest.setMinHeight(
            (double) (numberOfLessonsInt * 21) + (4.6 * numberOfLessonsInt
                - 5));
        labelTest.setTextOverrun(OverrunStyle.CLIP);
        labelTest.setMinWidth(98.5);
        labelTest.setTextAlignment(TextAlignment.CENTER);
        labelTest.setAlignment(Pos.CENTER);

        gridPane.add(labelTest, dayOfWeek, startTimeInt, 1, numberOfLessonsInt);
        // System.out.println("I just added this label");
        System.out.println(labelTest);
        // Move the label like 1 pixel to the right to make it centered
        labelTest.setTranslateX(0.7);
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

    //HOLIDAY WEEKS BEING SET TO SOME COLOR.
    try
    {
      if (model.getHolidayWeeks() != null)
      {
        for (int i = 0; i < model.getHolidayWeeks().size(); i++)
        {
          if (model.getHolidayWeeks().get(i) == model.getChosenWeekNumber())
          {
            for (int j = 1; j <= 5; j++)
            {
              StringProperty courseName = new SimpleStringProperty("HOLIDAYS");
              Label labelTest = new Label();
              labelTest.setText(courseName.get());
              // String nodeId = "session" + i;
              labelTest.setId("sessionHol" + i);

              // Adds a background color to the session on the grid
              String backColor = "DARKSALMON";
              String courseHolder = "HOLIDAYS";
        /*
        if (courseHolder.contains("RWD"))
        {
          backColor = "lightblue";
        }
        if (courseHolder.contains("DMA"))
        {
          backColor = "lightseagreen";
        }
        if (courseHolder.contains("SDJ"))
        {
          backColor = "burlywood";
        }
        if (courseHolder.contains("SEP"))
        {
          backColor = "indianred";
        }


         */
              labelTest.setBackground(new Background(
                  new BackgroundFill(Paint.valueOf(backColor), null, null)));

              labelTest.setMinHeight(276.6);
              labelTest.setMinWidth(98.5);
              labelTest.setTextAlignment(TextAlignment.CENTER);
              labelTest.setAlignment(Pos.CENTER);

              gridPane.add(labelTest, j, 2, 1, 11);
              labelTest.setTranslateX(0.7);
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

    //

    // System.out.println("Here are the current gridPane children");
    // for (int i = 0; i < gridPane.getChildren().size(); i++) {
    //   System.out.println(gridPane.getChildren().get(i));
    // }

    // Chris attempts remove on click
    gridPane.setOnMouseClicked(new EventHandler<MouseEvent>()
    {
      @Override public void handle(MouseEvent mouseEvent)
      {
        String selected = mouseEvent.getTarget().toString();
        System.out.println("I just selected" + selected);
        Object target = mouseEvent.getTarget();
        String compare = "";
        if (target instanceof Text)
        {
          Text targetTextObject = (Text) target;
          compare = targetTextObject.getText();
        }
        else if (target instanceof Label)
        {
          Label targetLabel = (Label) target;
          compare = targetLabel.getText();
        }

        // Choosing the session by clicking
        for (int j = 0;
             j < model.getSessionsByClassGroup(model.getChosenClassGroup())
                 .size(); j++)
        {
          if (model.getSessionsByClassGroup(model.getChosenClassGroup()).get(j)
              .shortString().equals(compare))
          {
            // System.out.println("Found the target in the list in model");
            // System.out.println("Setting to chosen session");
            model.setChosenSession(
                model.getSessionsByClassGroup(model.getChosenClassGroup())
                    .get(j));
            System.out.println(
                "TEST* The chosen session is: " + model.getChosenSession());
            viewHandler.openView("sessionDetails");
          }
        }

          /* slow version
          // System.out.println("I found text!");
          for (int i = 0; i < gridPane.getChildren().size(); i++)
          {
            // System.out.println("I am looking at child " + i);
            if (gridPane.getChildren().get(i) instanceof Label)
            {
              Label labelToRead = (Label) gridPane.getChildren().get(i);
              if (labelToRead.getText().equals(((Text) target).getText()))
              {
                System.out.println(
                    "Found my target. Trying to remove it from grid pane");
                gridPane.getChildren().remove(gridPane.getChildren().get(i));
                for (int j = 0; j < model.getSessionsByClassGroup(
                    model.getChosenClassGroup()).size(); j++)
                {
                  if (model.getSessionsByClassGroup(model.getChosenClassGroup())
                      .get(j).shortString().equals(labelToRead.getText()))
                  {
                    System.out.println("Found the target in the list in model");
                    System.out.println("Removing from the list");
                    model.removeSession(model.getSessionsByClassGroup(
                        model.getChosenClassGroup()).get(j));
                  }
                }
                break;
              }
            }

          }

           */
      }
    });

    /*
    gridPane.setOnMouseClicked(new EventHandler<MouseEvent>())


      @Override public void handle(MouseEvent mouseEvent)
      {
        //Node nodeHandler = getNodeByRowColumnIndex(dayOfWeek, startTimeInt, gridPane);
        System.out.println(gridPane.getChildren());
        //gets the X and Y of where you clicked
        double clickX = Math.floor(mouseEvent.getX());
        double clickY = Math.floor(mouseEvent.getY());

        //Prints out the nodes x/y so that we can see location. the plan is to get the XY of the node we want and compare it to the X Y of where we clicked?
        System.out.println("X:" + clickX + "\nY:" + clickY);
        for (int i = 0; i < gridPane.getChildren().size(); i++)
        {
          System.out.println(
              "X:" + gridPane.getChildren().get(i).getLayoutX() + "\nY:"
                  + gridPane.getChildren().get(i).getLayoutY());
        }
        //tried to remove at x,y but they are not the same as row and column
        // gridPane.getChildren().remove(getNodeByRowColumnIndex((int)clickY,(int)clickX,gridPane));

        //when you print out properties it says what row and column and span the session is
                    /*
                    for (int i = 0; i < gridPane.getChildren().size(); i++){
                    Object node = gridPane.getChildren().get(i).getProperties().get(getNodeByRowColumnIndex((int)clickY,(int)clickX,gridPane));
                    System.out.println(gridPane.getChildren().get(i).getProperties());
                    }

                     */
    // gridPane.getChildren().remove(gridPane.getChildren().getLayoutX(), startTimeInt);
    //}

    //});
  }

  // @FXML methods here

  @FXML private void chooseClassButton()
  {
    if (model.getChosenTeacher() == null)
    {
      viewHandler.openView("classSelect");
    }
    else
    {
      errorLabel.setText("You cannot select both class and a teacher.");
    }
  }

  @FXML private void uploadFilesButton()
  {
    viewHandler.openView("fileView");
  }

  @FXML void chooseWeekButton()
  {
    if (model.getChosenClassGroup() != null)
    {
      if (model.getChosenClassGroup().getStudents().size() == 0)
      {
        errorLabel.setText("Please upload the text files");
      }
      else
      {
        viewHandler.openView("chooseWeek");
      }
    }
    else
    {
      errorLabel.setText("Please select a class");
    }
  }

  @FXML private void addSessionButton()
  {
    if (model.getChosenClassGroup() == null)
    {
      errorLabel.setText("Please select a class before adding sessions");
    }
    else
    {
      model.setChosenClassGroup(model.getChosenClassGroup());
      viewHandler.openView("addSession");
    }
  }

  @FXML private void mimicScheduleButton()
  {
    if (model.getSessionsByClassGroup(model.getChosenClassGroup()) == null)
    {
      System.out.println("Sessions empty for classgroup");
      errorLabel.setText("No sessions to mimic for the chosen classgroup");
    }
    else
    {
      viewHandler.openView("mimicSchedule");
    }
  }

  @FXML private void toXML()
  {
    SessionList allAddedSessions = new SessionList();

    for (int j = 0;
         j < model.getSessionsByClassGroup(model.getChosenClassGroup())
             .size(); j++)
    {

      allAddedSessions.addSession(
          model.getSessionsByClassGroup(model.getChosenClassGroup()).get(j),
          model.getSessionsByClassGroup(model.getChosenClassGroup()).get(j)
              .getRoom());
    }

    // XMLParser.toXML(allAddedSessions,"SessionList.XML");
    ReadWrite.manualWriteSessionList(allAddedSessions, new String(
        model.getChosenClassGroup().getSemester() + model.getChosenClassGroup()
            .getClassName()));
    //  System.out.println(allAddedSessions);
  }

  @FXML private void exitButton()
  {
    viewHandler.closeView();
  }

  @FXML private void chooseTeacherButton()
  {
    if (model.getChosenClassGroup() == null)
    {
      viewHandler.openView("selectTeacher");
    }
    else
    {
      errorLabel.setText("You cannot select both class and a teacher.");
    }
  }
}
