/** ArrayList Library for storing shapes */
import java.util.ArrayList;

/** FX Graphics Library - Template */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Implementation of the PaintApp class where all graphics
 * and effects take place alongside mouse events and special methods
 */
public class PaintApp extends Application
{
    /** GraphicsContext Type for adding design to the Graphical Interface */
    GraphicsContext gc;

    /** ArrayList<GeometricObject> Type for adding and subtracing visual shapes to and from it's array */
    private ArrayList<GeometricObject> shapes = new ArrayList<>();

    /** check if shape is either a circle or square */
    private boolean isCircle = true;

    /** Label Types for spawning text on the screen */
    Label topLabel, paddingBackground, locationLabel, sizeLabel, colorLabel, errorLabel;

    /** Button Types for spawning functional buttons on the screen */
    Button circleButton, squareButton, drawButton, undrawButton, clearButton;

    /** TextField Types for allowing user input into individual boxes */
    TextField locationX, locationY, sizeInput, colorBox1, colorBox2, colorBox3;

    /**
     * Given Location - [x, y] creates/spawns a shape, either Circle or Square in area
     * @param ae
     */
    private void drawLocation(ActionEvent ae) {
        if (isCircle) {
            try {
                if (errorChecker()) return; // Checks errorChecker method if any errors occured within drawing

                /** Creation of the Circle Object followed by parameters indicating specified color and location */
                Circle circle = new Circle(Double.parseDouble(locationX.getText()), Double.parseDouble(locationY.getText()), 
                    Color.rgb(Integer.parseInt(colorBox1.getText()), Integer.parseInt(colorBox2.getText()), 
                    Integer.parseInt(colorBox3.getText())), Integer.parseInt(sizeInput.getText()));

                circle.draw(gc); // Draw Circle
                shapes.add(circle); // Add Circle Object to ArrayList

                /** update error label */
                errorLabel.setTextFill(Color.GREEN);
                errorLabel.setText("No Errors");
            
            } catch (Exception e) {
                /** update error label */
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText(e.getMessage());
            }
        }
        else {
            try {
                if (errorChecker()) return; // Checks errorChecker method if any errors occured within drawing

                /** Creation of the Square Object followed by parameters indicating specified color and location */
                Square square = new Square(Double.parseDouble(locationX.getText()), Double.parseDouble(locationY.getText()),
                    Color.rgb(Integer.parseInt(colorBox1.getText()), Integer.parseInt(colorBox2.getText()),
                    Integer.parseInt(colorBox3.getText())), Integer.parseInt(sizeInput.getText()));

                square.draw(gc); // Draw Square
                shapes.add(square); // Add Square Object to ArrayList

                /** update error label */
                errorLabel.setTextFill(Color.GREEN);
                errorLabel.setText("No Errors");
            
            } catch (Exception e) {
                /** update error label */
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText(e.getMessage());
            }
        }

        // check if shapes array is empty
        if (!shapes.isEmpty()) {
            undrawButton.setDisable(false);
        }
    }

    /**
     * Draws a Shape depending on where cursor lays within the canvas
     * @param me
     */
    private void drawHandler(MouseEvent me) {
        if (isCircle) {
            try {
                if (errorChecker()) return; // Checks errorChecker method if any errors occured within drawing

                Circle circle = new Circle(me.getX(), me.getY(), Color.rgb(Integer.parseInt(colorBox1.getText()), 
                    Integer.parseInt(colorBox2.getText()), Integer.parseInt(colorBox3.getText())),
                    Integer.parseInt(sizeInput.getText()));
                            
                circle.draw(gc); // Add Circle Object to ArrayList
                shapes.add(circle); // Add Circle Object to ArrayList

                /** update error label */
                errorLabel.setTextFill(Color.GREEN);
                errorLabel.setText("No Errors");
            
            } catch (Exception e) {
                /** update error label */
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText(e.getMessage());
            }
        }
        else {
            try {
                if (errorChecker()) return; // Checks errorChecker method if any errors occured within drawing

                Square square = new Square(me.getX(), me.getY(), Color.rgb(Integer.parseInt(colorBox1.getText()), Integer.parseInt(colorBox2.getText()), 
                    Integer.parseInt(colorBox3.getText())), Integer.parseInt(sizeInput.getText()));

                square.draw(gc); // Add Square Object to ArrayList
                shapes.add(square); // Add Square Object to ArrayList

                /** update error label */
                errorLabel.setTextFill(Color.GREEN);
                errorLabel.setText("No Errors");
            
            } catch (Exception e) {
                /** update error label */
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText(e.getMessage());
            }
        }

        // check if shapes array is empty
        if (!shapes.isEmpty()) {
            undrawButton.setDisable(false);
        }
    }

    /**
     * checks all boxes for invalid or empty input
     * @return true/false
     */
    public boolean errorChecker() {
        errorLabel.setTextFill(Color.RED);

        /** check if location [x] box is empty */
        if (locationX.getText().isEmpty()) {
            errorLabel.setText("Location [X] box is Empty");
            return true;
        }
        /** check if location [x] box contains an invalid character */
        if (!locationX.getText().matches("[0-9]+")) {
            errorLabel.setText("Location [X] contains an Invalid Character");
            return true;
        }

        /** check if location [y] box is empty */
        if (locationY.getText().isEmpty()) {
            errorLabel.setText("Location [Y] box is Empty");
            return true;
        }
        /** check if location [y] box contains an invalid character */
        if (!locationY.getText().matches("[0-9]+")) {
            errorLabel.setText("Location [Y] contains an Invalid Character");
            return true;
        }

        /** check if size box is empty */
        if (sizeInput.getText().isEmpty()) {
            errorLabel.setText("Size Box is Empty");
            return true;
        }
        /** check if size box contains an invalid character */
        if (!sizeInput.getText().matches("[0-9]+")) {
            errorLabel.setText("[Size] Box contains an Invalid Character");
            return true;
        }

        /** check if color box 1 is empty */
        if (colorBox1.getText().isEmpty()) {
            errorLabel.setText("Color Box [Red] is Empty");
            return true;
        }
        /** check if color 1 box contains an invalid character */
        if (!colorBox1.getText().matches("[0-9]+")) {
            errorLabel.setText("[Red] Box contains an Invalid Character");
            return true;
        }

        /** check if color box 2 is empty */
        if (colorBox2.getText().isEmpty()) {
            errorLabel.setText("Color Box [Green] is Empty");
            return true;
        }
        /** check if color 2 box contains an invalid character */
        if (!colorBox2.getText().matches("[0-9]+")) {
            errorLabel.setText("[Green] Box contains an Invalid Character");
            return true;
        }

        /** check if color box 3 is empty */
        if (colorBox3.getText().isEmpty()) {
            errorLabel.setText("Color Box [Blue] is Empty");
            return true;
        }
        /** check if color 3 box contains an invalid character */
        if (!colorBox3.getText().matches("[0-9]+")) {
            errorLabel.setText("[Blue] Box contains an Invalid Character");
            return true;
        }
        return false;
    }

    /**
     * Start method instead of main
     * 
     * @param stage The FX Stage to draw on
     * @throws Exception
     */
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();
        Scene scene = new Scene(root, 880, 520);
        Canvas canvas = new Canvas(880, 520); // Set Width & Height of Canvas
        stage.setTitle("Draw Board"); // Set Title
        stage.setScene(scene);

        /** label at Top Center - Indicating either Circle or Square */
        topLabel = new Label("Press Draw or Click Canvas for a Circle");
        topLabel.setPrefWidth(880);
        topLabel.setStyle("-fx-background-color: #E8E8E8; -fx-alignment: CENTER");
        topLabel.setFont(new Font("serif", 16));

        /** adds background to panel at the bottom */
        paddingBackground = new Label();
        paddingBackground.setTranslateY(435);
        paddingBackground.setPrefWidth(880);
        paddingBackground.setPrefHeight(100);
        paddingBackground.setStyle("-fx-background-color: #E8E8E8");

        /** circle button for creating a circle */
        circleButton = new Button("Circle");
        circleButton.setMinWidth(75);
        circleButton.setTranslateY(440);

        /** square button for creating a square */
        squareButton = new Button("Square");
        squareButton.setMinWidth(75);
        squareButton.relocate(75, 440);

        /** 'location' label */
        locationLabel = new Label("Location:");
        locationLabel.relocate(170, 440);

        /** textfield box to indicate spawn location (X-Axis) */
        locationX = new TextField();
        locationX.setPromptText("X-Axis");
        locationX.setPrefWidth(55);
        locationX.setAlignment(Pos.CENTER);
        locationX.relocate(220, 440);

        /** textfield box to indicate spawn location (Y-Axis) */
        locationY = new TextField();
        locationY.setPromptText("Y-Axis");
        locationY.setPrefWidth(55);
        locationY.setAlignment(Pos.CENTER);
        locationY.relocate(275, 440);

        /** 'size' label */
        sizeLabel = new Label("Size:");
        sizeLabel.relocate(340, 440);

        /** textfield box to indicate size of shape */
        sizeInput = new TextField();
        sizeInput.setPrefWidth(55);
        sizeInput.setAlignment(Pos.CENTER);
        sizeInput.relocate(365, 440);

        /** 'color' label */
        colorLabel = new Label("Color:");
        colorLabel.relocate(430, 440);

        /** textfield box to indicate red */
        colorBox1 = new TextField();
        colorBox1.setPrefWidth(55);
        colorBox1.setAlignment(Pos.CENTER);
        colorBox1.relocate(465, 440);

        /** textfield box to indicate green */
        colorBox2 = new TextField();
        colorBox2.setPrefWidth(55);
        colorBox2.setAlignment(Pos.CENTER);
        colorBox2.relocate(520, 440);

        /** textfield box to indicate blue */
        colorBox3 = new TextField();
        colorBox3.setPrefWidth(55);
        colorBox3.setAlignment(Pos.CENTER);
        colorBox3.relocate(575, 440);

        /** draw button to create shape */
        drawButton = new Button("Draw");
        drawButton.setMinWidth(75);
        drawButton.relocate(640, 440);

        /** undraw button to erase last shape in array */
        undrawButton = new Button("Undraw");
        undrawButton.setMinWidth(75);
        undrawButton.relocate(715, 440);

        /** clear button to erase all content on the screen */
        clearButton = new Button("Clear");
        clearButton.setMinWidth(75);
        clearButton.relocate(790, 440);

        /** 'No Errors' label */
        errorLabel = new Label("No Errors");
        errorLabel.setFont(new Font("serif", 15));
        errorLabel.setTranslateY(485);
        errorLabel.setPrefWidth(880);
        errorLabel.setStyle(
                "-fx-background-color: #A8A8A8;" +
                "-fx-text-fill: darkgreen;" +
                "-fx-alignment: CENTER"
        );

        /** Create GraphicsContext Object for Canvas */
        gc = canvas.getGraphicsContext2D();

        /** Mouse Events listening for Mouse being Pressed & Dragged */
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::drawHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::drawHandler);

        /** Adds all Buttons/Labels/TextField to Graphical Interface*/
        root.getChildren().addAll(canvas, topLabel, paddingBackground, circleButton,
            squareButton, locationLabel, locationX, locationY, 
            sizeLabel, sizeInput, colorLabel, colorBox1,
            colorBox2, colorBox3, drawButton, undrawButton, 
            clearButton, errorLabel);
            
        /** Set Action for Circle Button to changed to Circle */
        circleButton.setOnAction((event) -> {
            isCircle = true;
            topLabel.setText("Press Draw or Click Canvas for a Circle");
        });

        /** Set Action for Square Button to changed to Square */
        squareButton.setOnAction((event) -> {
            isCircle = false;
            topLabel.setText("Press Draw or Click Canvas for a Square");
        });

        /** Set Draw Button to drawLocation() Method */
        drawButton.setOnAction(this::drawLocation);

        /** Undraw Button Event */
        undrawButton.setOnAction((event) -> {
            gc.clearRect(0, 0, 880, 520); // Clear Screen
            try {
                shapes.remove(shapes.size() - 1); // Remove last element from ArrayList

            } catch (Exception e) {
                undrawButton.setDisable(true); // disables undraw button
                return;
            }

            /** re-draw all shapes from ArrayList on screen */
            for (int i = 0; i < shapes.size(); i++) {
                try {
                    ((Circle)shapes.get(i)).draw(gc); // Re-Draw Circle Object
    
                } catch (ClassCastException e) {
                    ((Square)shapes.get(i)).draw(gc); // Re-Draw Square Object
                }
            }
        });
        clearButton.setOnAction((event) -> {
            gc.clearRect(0, 0, 880, 520); // clears canvas
            shapes.clear(); // clears entire array of shapes
        });
        stage.show(); // Display GUI
    }

    public static void main(String[] args) { launch(args); } // Unused
}