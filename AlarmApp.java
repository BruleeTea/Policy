import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class AlarmApp extends Application {

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();
        aPane.setStyle("-fx-background-color: white; " +
                "-fx-border-color: gray; " +
                "-fx-padding: 4 4;");
        primaryStage.setTitle("Alarm App"); // Set window title

        Pane rTime = new Pane();
        rTime.setStyle("-fx-background-color: white; " + "-fx-border-color: gray; " + "-fx-padding: 4 4;");
        rTime.relocate(10, 10);
        rTime.setPrefSize(200, 90);
        Label titleLabel1 = new Label();
        titleLabel1.setText("Remaining Time:");
        titleLabel1.relocate(1, 0);

        Label time = new Label();
        time.setText("00:00:00");
        time.setTextFill(Color.DARKGREEN);

        time.setFont(Font.font("System", 48));
        time.relocate(10, 20);
        titleLabel1.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");

        Pane cTime = new Pane();
        cTime.relocate(220, 10);
        cTime.setPrefSize(200, 40);
        cTime.setStyle("-fx-background-color: white; " + "-fx-border-color: gray; " + "-fx-padding: 4 4;");

        Label titleLabel2 = new Label();
        titleLabel2.setText("Current Time:");
        titleLabel2.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        titleLabel2.relocate(1, 0);

        TextField current = new TextField();
        current.setText("01:54:16 PM");
        current.setFont(Font.font("System", 15));
        current.setAlignment(Pos.BOTTOM_RIGHT);
        current.relocate(5, 7);
        current.setPrefSize(190, 25);

        Pane aTime = new Pane();
        aTime.setStyle("-fx-background-color: white; " + "-fx-border-color: gray; " + "-fx-padding: 4 4;");
        aTime.setPrefSize(200, 40);
        aTime.relocate(220, 60);

        Label titleLabel3 = new Label();
        titleLabel3.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        titleLabel3.setText("Alarm Time:");
        titleLabel3.relocate(1, 0);

        TextField Alarm = new TextField();
        Alarm.setText("10:30:00 AM");
        Alarm.setFont(Font.font("System", 15));
        Alarm.setAlignment(Pos.BOTTOM_RIGHT);
        Alarm.relocate(5, 7);
        Alarm.setPrefSize(190, 25);

        ObservableList<String> day = FXCollections.observableArrayList("Weekday", "Saturday", "Sunday");
        final ComboBox SelectAlarm = new ComboBox(day);
        SelectAlarm.setPromptText("Select Alarm");
        SelectAlarm.setPrefSize(410, 30);
        SelectAlarm.relocate(10, 110);

        ToggleGroup alarm = new ToggleGroup();
        ToggleButton[] buttons = new ToggleButton[3];
        RadioButton[] Radbtn = new RadioButton[2];
        String[] buttonsLbl = {"New Alarm", "Edit", "Delete"};
        String[] RadLbl = {"ON", "OFF"};
        for (int i = 0; i < 3; i++) {
            buttons[i] = new ToggleButton(buttonsLbl[i]);
            if (i == 0) {
                buttons[i].setPrefSize(100, 30);
                buttons[i].relocate(10, 150);
            } else {
                buttons[i].setPrefSize(80, 30);
                buttons[i].relocate(80 * i + i * 10 + 30, 150);
            }
            aPane.getChildren().addAll(buttons[i]);
            buttons[i].setToggleGroup(alarm);
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    int buttonNumber = 0;
                    for (buttonNumber = 0; buttonNumber < 2; buttonNumber++) {
                        if (Radbtn[buttonNumber] == event.getSource())
                            break;
                    }
                }
            });
        }
        for (int i = 0; i < 2; i++) {
            Radbtn[i] = new RadioButton(RadLbl[i]);
            Radbtn[i].relocate(310 + (i * 50), 150);
            Radbtn[i].setPrefSize(50, 30);
            aPane.getChildren().addAll(Radbtn[i]);
            Radbtn[i].setToggleGroup(alarm);
            Radbtn[i].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    int buttonNumber = 0;
                    for (buttonNumber = 0; buttonNumber < 2; buttonNumber++) {
                        if (Radbtn[buttonNumber] == event.getSource())
                            break;
                    }
                }
            });

        }


        rTime.getChildren().addAll(time, titleLabel1);
        aTime.getChildren().addAll(titleLabel3, Alarm);
        cTime.getChildren().addAll(titleLabel2, current);
        aPane.getChildren().addAll(rTime, cTime, aTime, SelectAlarm);
        primaryStage.setScene(new Scene(aPane, 430, 190));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Get everything going (call this exactly once)

    }

}
