package view;

import javafx.fxml.FXML;
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

    @FXML
    javafx.scene.control.Label errorLabel;
    @FXML
    Label classNameLabel;
    @FXML private GridPane gridPane;

        public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
        {
            this.viewHandler = viewHandler;
            this.root = root;
            this.model = model;
            this.scheduleViewModel = new ScheduleViewModel(model);
            this.gridPane = new GridPane();

            //creating label email
            Text text1 = new Text("Email");

            //creating label password
            Text text2 = new Text("Password");

            //Arranging all the nodes in the grid
            gridPane.add(text1, 0, 0);
            gridPane.add(text2, 0, 1);


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
