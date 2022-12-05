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

/**
 * The maze UI class which visualizes the maze. The maze can be reset once a visualization begins
 * and has the ability to toggle between two colours.
 * The receiver of the commands.
 */
public class MazeView {

    MazeModel model; //reference to model
    Stage stage;

    Button helpButton, settingButton, startButton, setSizeButton, toggleColour;
    TextField widthField, heightField;

    BorderPane borderPane;
    Timeline timeline;

    Canvas canvas;
    GraphicsContext gc;

    int blockWidth = 20; //width of block on display

    private double width; //height and width of canvas
    private double height;

    private int state = 0; // toggle between state 0 and 1 to identify colour
    private boolean toggle = false;

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

        //timeline structures the animation, and speed between application "ticks"
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        this.startButton = new Button("Reset");
        startButton.setId("Start");
        startButton.setOnAction(e -> {
            this.reset();
        });

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

        this.toggleColour = new Button("☀️");
        toggleColour.setOnAction(e -> {
            colourChange();
        });

        Label widthLabel = new Label("width:");
        Label heightLabel = new Label("height:");
        this.widthField = new TextField();
        this.heightField = new TextField();
        this.widthField.setPrefWidth(40);
        this.heightField.setPrefWidth(40);
        this.widthField.setText("25");
        this.heightField.setText("25");

        HBox controls = new HBox(20, this.toggleColour, this.settingButton, this.startButton, this.helpButton,
                widthLabel, this.widthField, heightLabel, this.heightField, this.setSizeButton);
        controls.setPadding(new Insets(20, 20, 20, 20));
        controls.setAlignment(Pos.CENTER);

        borderPane.setBottom(controls);
        borderPane.setCenter(canvas);
        borderPane.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent k) {
                //TO DO
                if (k.getCode() == KeyCode.LEFT) {
                    model.moveCharacter(MazeModel.MoveType.LEFT);
                } else if (k.getCode() == KeyCode.RIGHT) {
                    model.moveCharacter(MazeModel.MoveType.RIGHT);
                } else if (k.getCode() == KeyCode.DOWN) {
                    model.moveCharacter(MazeModel.MoveType.DOWN);
                } else if (k.getCode() == KeyCode.UP) {
                    model.moveCharacter(MazeModel.MoveType.UP);
                }
                toggle = true;
                paintBoard();
                borderPane.requestFocus();
            }
        });

        var scene = new Scene(borderPane, 600, 600);
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
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Draw a rectangle around the whole screen
        if (this.state == 0) {
            gc.setFill(Color.BLACK);
        } else {
            gc.setFill(Color.ANTIQUEWHITE);
        }

        gc.fillRect(0, 0, this.width-1, this.height-1);

        // vertical lines
        gc.setStroke(Color.BLUE);
        for(int i = 1 ; i < this.width ; i+=this.width/this.model.getBoard().getWidth()){
            gc.strokeLine(i, 0, i, this.height);
        }

        // horizontal lines
        gc.setStroke(Color.BLUE);
        for(int i = 1 ; i < this.height ; i+=this.height/this.model.getBoard().getHeight()){
            gc.strokeLine(0, i, this.width, i);
        }

        if (this.toggle) {
            this.toggle = false;
        } else {
            this.model.getBoard().setPath();
            this.model.getBoard().makeWalls();
        }
        int width = this.model.getBoard().getWidth();
        int height = this.model.getBoard().getHeight();
        int[][] board = this.model.getBoard().getMazeGrid();
        double deltaX = this.width / width;
        double deltaY = this.height / height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[i][j] == 2) {
                    gc.setFill(Color.YELLOW);
                    gc.fillRect(1 + deltaX * i, 1 + deltaY * j, deltaX, deltaY);
                } else if (board[i][j] == 3) {
                    gc.setFill(Color.LIGHTGREEN);
                    gc.fillRect(1 + deltaX * i, 1 + deltaY * j, deltaX, deltaY);
                } else if (board[i][j] == 4) {
                    gc.setFill(Color.LIGHTGREEN);
                    gc.fillRect(1 + deltaX * i, 1 + deltaY * j, deltaX, deltaY);
                    gc.setFill(Color.BLUE);
                    gc.fillRect((1 + deltaX * i)+(deltaX/4), (1 + deltaY * j)+(deltaY/4),
                            deltaX/2, deltaY/2);
                }
            }
        }
        gc.setFill(Color.RED);
        gc.fillRect(1 + deltaX*(width-1), 1 + deltaY*(height-1), deltaX, deltaY);
    }


    /**
     * Function used to create new maze model with user desired size. It is called
     * on click of the set size button and reads from width and height fields.
     */
    public void setSize() {
        int width = Integer.parseInt(widthField.getText());
        int height = Integer.parseInt(heightField.getText());
        this.model = new MazeModel(width, height);
        paintBoard();
    }

    /**
     * Reset the maze to begin new visualization.
     */
    public void reset() {
        this.model = new MazeModel(this.model.getBoard().getWidth(), this.model.getBoard().getHeight());
        this.paintBoard();
    }

    /**
     * Change the colour of the maze.
     */
    public void colourChange() {
        this.state = (this.state == 0) ? 1 : 0;
        this.toggle = true;
        this.paintBoard();
    }

    /**
     * Create the view that shows up once the settings button is pressed
     */
    private void createSettingView()
    {
        SettingsView sv = new SettingsView(this);
    }

    /**
     * Create the view that shows up once the tutorial button is pressed
     */
    private void createTutorialView()
    {
        TutorialView tv = new TutorialView(this);
    }
}
