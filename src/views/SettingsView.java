package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import javafx.scene.text.*;

public class SettingsView {

    private views.MazeView mazeView;
    private Label titleLabel;

    /**
     * The representation of the view that opens once the settings button is clicked
     */
    public SettingsView(views.MazeView mazeView)
    {
        this.mazeView = mazeView;

        //Title of the view
        this.titleLabel = new Label("Settings");
        this.titleLabel.setFont(new Font("Verdana", 20));
        this.titleLabel.setStyle("-fx-text-fill: #000000");

        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(mazeView.stage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #808080;");


        VBox display = new VBox(30, this.titleLabel);
        display.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(display);

        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}