/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintolabjavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.stage.Stage;

/**
 *
 * @author claudio
 */
public class LaberintoLabJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        final Circle circulo = CircleBuilder.create()
                .radius(5)
                .fill(Color.RED)
                .build();

        Group root = new Group();

        Scene scene = new Scene(root, 400, 400);




        Line lineaIzq = LineBuilder.create()
                .startX(0.0)
                .startY(200)
                .endX(100)
                .endY(200)
                .build();

        Line lineaDer = LineBuilder.create()
                .startX(400.0)
                .startY(200)
                .endX(300)
                .endY(200)
                .build();

        Line lineaMed = LineBuilder.create()
                .startX(200)
                .startY(0.0)
                .endX(200)
                .endY(350)
                .build();


        root.getChildren().addAll(circulo, lineaIzq, lineaMed, lineaDer);

        primaryStage.setTitle("Laboratorio JavaFx - Claudio Serrano");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println(scene.getWidth() / 2 + " " + scene.getHeight() / 2);

     


        circulo.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                
                
                
            }
        });
        
    }
    
   

    public static void main(String[] args) {
        launch(args);
    }
}
