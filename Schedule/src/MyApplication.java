import javafx.application.Application;
import javafx.stage.Stage;
// import model and manager
import model.list.*;
import view.ViewHandler;

public class MyApplication extends Application {
    public void start(Stage primaryStage) {
        ScheduleModel model = new ScheduleModelManager();
        ViewHandler view = new ViewHandler(model);
        view.start(primaryStage);
    }
}
