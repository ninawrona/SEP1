package view;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.basic.Session;
import model.list.*;

public class ScheduleViewController {
    //@FXML private methods here
    @FXML
    Label errorLabel;
    @FXML
    Label classNameLabel;
    @FXML
    private TableView<SessionViewModel> scheduleTable;
    @FXML
    private TableColumn<SessionViewModel, String> timeColumn;
    @FXML
    private TableColumn<SessionViewModel, String> mondayColumn;
    @FXML
    private TableColumn<SessionViewModel, String> tuesdayColumn;
    @FXML
    private TableColumn<SessionViewModel, String> wednesdayColumn;
    @FXML
    private TableColumn<SessionViewModel, String> thursdayColumn;
    @FXML
    private TableColumn<SessionViewModel, String> fridayColumn;


    private Region root;
    private ViewHandler viewHandler;
    private ScheduleViewModel scheduleViewModel;
    private ScheduleModel model;


    public ScheduleViewController() {
        // Called by FXMLLoader
    }


    public void init(ViewHandler viewHandler, ScheduleModel model, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;
        this.model = model;
        this.scheduleViewModel = new ScheduleViewModel(model);

        errorLabel.setText("");
        // reset();

        timeColumn.setText("time");
        timeColumn.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(cellData.getValue().getStartTimeProperty()));


        mondayColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper("GingerBread"));
        for (int i = 0; i < scheduleViewModel.getList().size(); i++) {
            switch (scheduleViewModel.getList().get(i).getDayOfWeekProperty()) {
                case 1: {
                    mondayColumn.setCellValueFactory(
                            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCourseProperty()));
                }
                case 2: {
                    tuesdayColumn.setCellValueFactory(
                            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCourseProperty()));
                }
                case 3: {
                    wednesdayColumn.setCellValueFactory(
                            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCourseProperty()));
                }
                case 4: {
                    thursdayColumn.setCellValueFactory(
                            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCourseProperty()));
                }
                case 5: {
                    fridayColumn.setCellValueFactory(
                            cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCourseProperty()));
                }
                default:{
                    mondayColumn.setCellValueFactory(
                            cellData -> new ReadOnlyStringWrapper("Default"));
                }
            }
        }

        scheduleTable.setItems(scheduleViewModel.getList());
        // The method below should fetch all the session to display
        // scheduleTable.setItems(viewModel.getList());
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
        // set text to ""
        errorLabel.setText("");
        if (model.getChosenClassGroup() != null) {
           // System.out.println("Tried");
            classNameLabel.setText(model.getChosenClassGroup().toString());
        } else {
          //  System.out.println("Failed");
            classNameLabel.setText("Class name");
        }
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
