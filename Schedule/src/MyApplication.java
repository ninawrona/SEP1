import javafx.application.Application;
import javafx.stage.Stage;
// import model and manager
import view.ViewHandler;

public class MyApplication
{
  public void start(Stage primaryStage)
  {
    // ScheduleModel model = new ScheduleModelManager();
    ViewHandler view = new ViewHandler(); // put model into ViewHandler
    // view.start(primaryStage);
  }
}
