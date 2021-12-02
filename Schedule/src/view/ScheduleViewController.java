package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class ScheduleViewController
{
    //@FXML private methods here
    @FXML Label errorLabel;
    @FXML Label courseNameLabel;
    @FXML
    private TableView<GradeViewModel> scheduleTable;
    @FXML
    private TableColumn<GradeViewModel, Number> timeColumn;
    @FXML
    private TableColumn<GradeViewModel, String> mondayColumn;
    @FXML
    private TableColumn<GradeViewModel, String> tuesdayColumn;
    @FXML
    private TableColumn<GradeViewModel, String> wednesdayColumn;
    @FXML
    private TableColumn<GradeViewModel, String> thursdayColumn;
    @FXML
    private TableColumn<GradeViewModel, String> fridayColumn;
    private Region root;
    private ViewHandler viewHandler;
    //private ScheduleModel model;


    public ScheduleViewController()
    {
        // Called by FXMLLoader
    }

    public void init(ViewHandler viewHandler, Region root) // add model when made
    {
        this.viewHandler = viewHandler;
        this.root = root;
        // this.model = model;
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
                cellData -> cellData.getValue().getThusdayProperty());
        fridayColumn.setCellValueFactory(
                cellData -> cellData.getValue().getFridayProperty());

        scheduleTable.setItems(viewModel.getList());
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
}
