package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.list.*;

public class ScheduleViewController
{
    //@FXML private methods here
    @FXML Label errorLabel;
    @FXML Label courseNameLabel;
    @FXML
    private TableView<ScheduleViewModel> scheduleTable;
    @FXML
    private TableColumn<ScheduleViewModel, String> timeColumn;
    @FXML
    private TableColumn<ScheduleViewModel, String> mondayColumn;
    @FXML
    private TableColumn<ScheduleViewModel, String> tuesdayColumn;
    @FXML
    private TableColumn<ScheduleViewModel, String> wednesdayColumn;
    @FXML
    private TableColumn<ScheduleViewModel, String> thursdayColumn;
    @FXML
    private TableColumn<ScheduleViewModel, String> fridayColumn;
    private Region root;
    private ViewHandler viewHandler;
    private ScheduleViewModel viewModel;
    private ScheduleModel model;


    public ScheduleViewController()
    {
        // Called by FXMLLoader
    }


    public void init(ViewHandler viewHandler, ScheduleModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = this.model;
        reset();

        timeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTimeProperty());
        mondayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getMondayProperty());
        tuesdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTuesdayProperty());
        wednesdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getWednesdayProperty());
        thursdayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getThursdayProperty());
        fridayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getFridayProperty());

        // The method below should fetch all the session to display
        // scheduleTable.setItems(viewModel.getList());
    }

    public Region getRoot()
    {
        return root;
    }

    public void reset()
    {
        // set text to ""
    }

    // @FXML methods here
    @FXML private void exitButton()
    {

    }

    @FXML private void addSessionButton()
    {

    }

    @FXML private void removeSessionButton()
    {

    }

    @FXML private void sessionDetailsButton()
    {

    }
}
