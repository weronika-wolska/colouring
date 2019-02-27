/*
    A simple JavaFX application to play around with
    shapes and the drawing on canvas features in JavaFX
 */

package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.Canvas;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        StackPane stackPane = new StackPane();
        primaryStage.setTitle("Colour the pattern");
        Scene scene = new Scene(stackPane, 700,700);
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(700,700);

        // create the "brush" and set its initial colour to black and initial width to 1
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        // when the user changes the colour on the ColorPicker, the colour of the brush
        // strokes also change

        ColorPicker picker = new ColorPicker();
        picker.setValue(Color.BLACK);
        picker.setOnAction(e -> gc.setStroke(picker.getValue()));

        // creating a slider to allow the user to change the width of the brush
        // with the initial width set to 1
        Slider slider = new Slider();
        slider.setMin(1);
        slider.setMax(20);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener(e -> gc.setLineWidth(slider.getValue()));

        // enabling the user to draw on the canvas
        scene.setOnMouseClicked(e -> {
            gc.beginPath();
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();
        });

        scene.setOnMouseDragged(e -> {
            gc.lineTo(e.getSceneX(), e.getSceneY());
            gc.stroke();
        });


        // organising the picker and slider at the top of the window
        GridPane grid = new GridPane();
        grid.addRow(2, picker, slider);
        grid.setHgap(20);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(20,0,0,0));



        // drawing different shapes
        Rectangle rectangle = new Rectangle(100,120,500,500);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        Rectangle rectangle2 = new Rectangle(150,170, 400, 400);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setFill(Color.WHITE);

        Rectangle rectangle3 = new Rectangle(200,220, 300, 300);
        rectangle3.setStroke(Color.BLACK);
        rectangle3.setFill(Color.WHITE);

        Rectangle rectangle4 = new Rectangle(250,270, 200, 200);
        rectangle4.setStroke(Color.BLACK);
        rectangle4.setFill(Color.WHITE);

        Rectangle rectangle5 = new Rectangle(300,320, 100, 100);
        rectangle5.setStroke(Color.BLACK);
        rectangle5.setFill(Color.WHITE);

        Circle circle1 = new Circle(350, 370, 200);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);


        Line line1 = new Line();
        line1.setStartX(100);
        line1.setStartY(120);
        line1.setEndX(600);
        line1.setEndY(620);

        Line line2 = new Line();
        line2.setStartX(600);
        line2.setStartY(120);
        line2.setEndX(100);
        line2.setEndY(620);

        Line line3 = new Line();
        line3.setStartX(350);
        line3.setStartY(120);
        line3.setEndX(350);
        line3.setEndY(620);

        Line line4 = new Line();
        line4.setStartX(100);
        line4.setStartY(370);
        line4.setEndX(600);
        line4.setEndY(370);



        stackPane.getChildren().addAll(rectangle, rectangle2,circle1, rectangle3, rectangle4,
                rectangle5, line1, line2, line3, line4, canvas, grid);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
