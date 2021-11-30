import javafx.stage.Stage;
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
