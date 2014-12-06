import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import switches.ToggleSwitch;

public class Test extends Application {

	@Override
	public void start(Stage primaryStage) {

		BorderPane borderpane = new BorderPane();
		VBox left = new VBox();
		left.setBackground(new Background(new BackgroundFill(Color.web("#2D4052"), CornerRadii.EMPTY, Insets.EMPTY)));
		left.setMinWidth(100.0);

		HBox bottom = new HBox();
		bottom.setBackground(new Background(new BackgroundFill(
				Color.web("#542022"), CornerRadii.EMPTY, Insets.EMPTY)));
		bottom.setMinHeight(100.0);

		HBox center = new HBox();
		center.setBackground(new Background(new BackgroundFill(Color.CYAN,
				CornerRadii.EMPTY, Insets.EMPTY)));
		ToggleSwitch john = new ToggleSwitch();
		ToggleSwitch phil = new ToggleSwitch();
		ToggleSwitch steeve = new ToggleSwitch();
		ToggleSwitch albert = new ToggleSwitch();
		left.getChildren().addAll(john, phil,
				steeve, albert);

		
		
		borderpane.setLeft(left);
		borderpane.setBottom(bottom);
		borderpane.setCenter(center);

		Scene scene = new Scene(borderpane, 500, 500);
		
		primaryStage.setTitle("Thing Thang");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
