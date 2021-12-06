package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.basic.Time;
import model.list.*;



public class ScheduleGridViewController{
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
    @FXML private GridPane gridPane;

        public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
        {
            this.viewHandler = viewHandler;
            this.root = root;
            this.model = model;
            this.scheduleViewModel = new ScheduleViewModel(model);
            this.gridPane = new GridPane();
            this.addSessionViewController = new AddSessionViewController();

            reset();
            label11.setText("Monday");
            label12.setText("Tuesday");
            label13.setText("Wednesday");
            label14.setText("Thursday");
            label15.setText("Friday");
            try{
                Label label = (Label) getNodeByRowColumnIndex(1, 1, gridPane);
                System.out.println(label);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("sth is wrong again, but does it work?");
            }

            //label01.setText(addSessionViewController.timeArray.get(0));
        }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }


        public Region getRoot() {
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
        }
        else
        {
            //  System.out.println("class not chosen yet");
            classNameLabel.setText("Class: ");
            errorLabel.setText("Please select a class");
        }

        scheduleViewModel.update();
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
