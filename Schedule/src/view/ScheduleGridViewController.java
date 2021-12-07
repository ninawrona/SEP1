package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.basic.Time;
import model.list.*;



public class ScheduleGridViewController {
    private ViewHandler viewHandler;
    private ScheduleModel model;
    private Region root;
    private ScheduleViewModel scheduleViewModel;
    private AddSessionViewController addSessionViewController;

    @FXML
    Label errorLabel;
    @FXML
    Label classNameLabel;
    @FXML
    Label label11;
    @FXML
    Label label12;
    @FXML
    Label label13;
    @FXML
    Label label14;
    @FXML
    Label label15;
    @FXML
    private Label label02;
    @FXML
    private Label label03;
    @FXML
    private Label label04;
    @FXML
    private Label label05;
    @FXML
    private Label label06;
    @FXML
    private Label label07;
    @FXML
    private Label label08;
    @FXML
    private Label label09;
    @FXML
    private Label label010;
    @FXML
    private Label label011;
    @FXML
    private Label label012;

    @FXML
    private GridPane gridPane;

    public ScheduleGridViewController() {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, ScheduleModel model, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = model;
        this.scheduleViewModel = new ScheduleViewModel(model);
        // This gridpane is already set above.
        // this.gridPane = new GridPane();
        this.addSessionViewController = new AddSessionViewController();

        reset();
        label11.setText("Monday");
        label12.setText("Tuesday");
        label13.setText("Wednesday");
        label14.setText("Thursday");
        label15.setText("Friday");
        label02.setText("8:20");
        label03.setText("9:15");
        label04.setText("10:10");
        label05.setText("11:05");
        label06.setText("12:00");
        label07.setText("12:45");
        label08.setText("13:40");
        label09.setText("14:35");
        label010.setText("15:30");
        label011.setText("16:25");
        label012.setText("17:20");
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
        for (int i = 0; i < scheduleViewModel.getList().size(); i++) {
            StringProperty courseName = scheduleViewModel.getList().get(i).getCourseProperty();
            Label labelTest = new Label();
            labelTest.setText(courseName.get());
            int startTimeInt = scheduleViewModel.getList().get(i).getStartTimeIntProperty();
            int numberOfLessonsInt = scheduleViewModel.getList().get(i).getNumberOfLessonsProperty().intValue();
            int dayOfWeek = scheduleViewModel.getList().get(i).getDayOfWeekProperty().getValue();


            gridPane.add(labelTest, dayOfWeek, startTimeInt, 1, numberOfLessonsInt);
            System.out.println(gridPane.getChildren().get(0));
        }

        gridPane.setOnMouseClicked(new EventHandler<MouseEvent>(){
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

                for(int i = 0; i<gridPane.getColumnCount(); i++){
                    for(int j = 0; j<gridPane.getRowCount();j++)
                    gridPane.getChildren().remove(i, j);
                }

            }
        });
    }

    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }


    public Region getRoot() {
        return root;
    }

    public void reset() {
        // set text to ""
        errorLabel.setText("");
        if (model.getChosenClassGroup() != null) {
            // System.out.println("Tried");
            classNameLabel.setText("Class: " + model.getChosenClassGroup().toString());
        } else {
            //  System.out.println("class not chosen yet");
            classNameLabel.setText("Class: ");
            errorLabel.setText("Please select a class");
        }

        scheduleViewModel.update();
    }

    // @FXML methods here

    @FXML
    private void chooseClassButton() {
        viewHandler.openView("classSelect");
    }

    @FXML
    private void uploadFilesButton() {
        viewHandler.openView("fileView");
    }

    @FXML
    private void addSessionButton() {
        model.setChosenClassGroup(model.getChosenClassGroup());
        viewHandler.openView("addSession");
    }

    @FXML
    private void removeSessionButton() {
        viewHandler.openView("removeSession");
    }

    @FXML
    private void sessionDetailsButton() {
        viewHandler.openView("courseDetails");
    }

    @FXML
    private void exitButton() {
        viewHandler.closeView();
    }

}
