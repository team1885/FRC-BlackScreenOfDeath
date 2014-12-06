package switches;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import switches.skin.ToggleSwitchSkin;

public class ToggleSwitch extends Control {
	private Pane pane;
	private boolean toggle;
	private final int SWITCH_TIME = 100;

	public ToggleSwitch() {
		toggle = true;
		createDefaultSkin();
	}
	
	

	public Pane getPane() {
		return pane;
	}

	public void addStackPane() {
		StackPane stack = new StackPane();

		Circle clicker = new Circle(15.0, 15.0, 15.0);
		LinearGradient buttonColor = new LinearGradient(0, 0, 0, 1, true,
				CycleMethod.NO_CYCLE, new Stop[] {
						new Stop(0, Color.web("#0F0F0F")),
						new Stop(1, Color.web("#202020")), });
		clicker.setFill(buttonColor);
		clicker.setStroke(buttonColor);

		Rectangle background = new Rectangle(80, 35);
		background.setFill(Color.WHITE);
		background.setStroke(Color.BLACK);
		background.setArcHeight(40);
		background.setArcWidth(40);

		TranslateTransition tt = new TranslateTransition(Duration.millis(SWITCH_TIME),
				clicker);
		tt.setByX(50f);
		FadeTransition ft = new FadeTransition(Duration.millis(SWITCH_TIME), clicker);
		ft.setFromValue(1.0);
		ft.setToValue(0.3);

		FillTransition off = new FillTransition(Duration.millis(SWITCH_TIME),
				background, Color.WHITE, Color.DARKGRAY);
		FillTransition on = new FillTransition(Duration.millis(SWITCH_TIME),
				background, Color.DARKGRAY, Color.WHITE);

		EventHandler<MouseEvent> click = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (tt.getStatus() == Animation.Status.RUNNING) {
					tt.jumpTo(Duration.millis(SWITCH_TIME));
					tt.stop();
					off.jumpTo(Duration.millis(SWITCH_TIME));
					off.stop();
					on.jumpTo(Duration.millis(SWITCH_TIME));
					on.stop();
					ft.jumpTo(Duration.millis(SWITCH_TIME));
					ft.stop();
				}
				if (toggle) {
					ft.setFromValue(1.0);
					ft.setToValue(0.3);
					tt.setByX(-50.0);

					tt.play();
					off.play();
					toggle = false;
					System.out.println("left");
				} else {
					ft.setFromValue(0.3);
					ft.setToValue(1.0);
					tt.setByX(50.0);
					tt.play();
					on.play();
					toggle = true;
					System.out.println("right");
				}
				ft.play();
			}
		};

		// clicker.setOnMouseClicked(click);

		stack.getChildren().addAll(background, clicker);
		stack.setAlignment(Pos.CENTER_RIGHT); // Right-justify nodes in stack

		pane.getChildren().add(stack); // Add to HBox from Example 1-2
		pane.setOnMouseClicked(click);
		HBox.setHgrow(stack, Priority.ALWAYS); // Give stack any extra space
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Skin createDefaultSkin() {
        return new ToggleSwitchSkin(this);
    }


}
