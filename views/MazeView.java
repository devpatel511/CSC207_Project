package views;

import models.MazeModel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import java.awt.*;

public class MazeView {

    MazeModel model; //reference to model
    Stage stage;

    Button helpButton, settingButton, startButton, setSizeButton;
    TextField widthField, heightField;

    BorderPane borderPane;

    Canvas canvas;
    GraphicsContext gc;

    int blockWidth = 20; //width of block on display

    private double width; //height and width of canvas
    private double height;

    public MazeView(MazeModel model, Stage stage)
    {
        this.model = model;
        this.stage = stage;
        initUI();
    }

    private void initUI()
    {
        this.stage.setTitle("Maze Game");

        this.width = this.model.getWidth()*this.blockWidth + 2;
        this.height = this.model.getHeight()*this.blockWidth + 2;

        borderPane = new BorderPane();

        //add canvas
        canvas = new javafx.scene.canvas.Canvas(this.width, this.height);
        canvas.setId("Canvas");
        gc = canvas.getGraphicsContext2D();

        this.startButton = new Button("Start Game");
        startButton.setId("Start");

        this.settingButton = new Button("Settings");
        settingButton.setId("Settings");
        settingButton.setOnAction(e ->
        {
            createSettingView();
            borderPane.requestFocus();
        });

        this.helpButton = new Button("Help");
        helpButton.setId("Help");
        helpButton.setOnAction(e ->{
            createTutorialView();
            borderPane.requestFocus();
        });

        this.setSizeButton = new Button("Set Size");
        setSizeButton.setId("SetSize");
        setSizeButton.setOnAction(e -> {
            setSize();
        });

        Label widthLabel = new Label("width:");
        Label heightLabel = new Label("height:");
        this.widthField = new TextField();
        this.heightField = new TextField();
        this.widthField.setPrefWidth(40);
        this.heightField.setPrefWidth(40);

        HBox controls = new HBox(20, this.settingButton, this.startButton, this.helpButton,
                widthLabel, this.widthField, heightLabel, this.heightField, this.setSizeButton);
        controls.setPadding(new Insets(20, 20, 20, 20));
        controls.setAlignment(Pos.CENTER);

        borderPane.setBottom(controls);
        borderPane.setCenter(canvas);

        var scene = new Scene(borderPane, 800, 800);
        this.stage.setScene(scene);
        this.stage.show();
        paintBoard();
    }

    private final int yPixel(int y) {
        return (int) Math.round(this.height -1 - (y+1)*dY());
    }
    private final int xPixel(int x) {
        return (int) Math.round((x)*dX());
    }
    private final float dX() {
        return( ((float)(this.width-2)) / this.model.getBoard().getWidth() );
    }
    private final float dY() {
        return( ((float)(this.height-2)) / this.model.getBoard().getHeight() );
    }


    public void paintBoard() {

        // Draw a rectangle around the whole screen
        gc.setStroke(Color.BLACK);

        gc.fillRect(0, 0, this.width-1, this.height-1);

        // Draw the line separating the top area on the screen
        gc.setStroke(Color.RED);
        int spacerY = yPixel(this.model.getBoard().getHeight() - 1);
        gc.strokeLine(0, spacerY, this.width-1, spacerY);

        // Factor a few things out to help the optimizer
        final int dx = Math.round(dX()-2);
        final int dy = Math.round(dY()-2);
        final int bWidth = this.model.getBoard().getWidth();


    }


    /**
     * Function used to create new maze model with user desired size. It is called
     * on click of the set size button and reads from width and height fields.
     */
    public void setSize() {
        int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        System.out.println(width);
        System.out.println(height);
        this.model = new MazeModel(width, height);
    }


    private void createSettingView()
    {
        SettingsView sv = new SettingsView(this);
    }

    private void createTutorialView()
    {
        TutorialView tv = new TutorialView(this);
    }


}
