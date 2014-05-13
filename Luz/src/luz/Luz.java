/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package luz;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author claudio
 */
public class Luz extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        Light.Point light = new Light.Point();
        light.setX(100);
        light.setY(100);
        light.setZ(50);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);
        Text text = new Text();
        text.setText("Point");
        text.setFill(Color.STEELBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 80));
        text.setX(10.0);
        text.setY(10.0);
        text.setTextOrigin(VPos.TOP);
        
        
        Circle cir = CircleBuilder.create()
                .radius(20)
                .layoutX(10)
                .layoutY(10)
.fill(Color.STEELBLUE).build();
        Rectangle rect = new Rectangle(400, 400);
        rect.setFill(Color.ALICEBLUE);
        rect.setEffect(lighting);
        text.setEffect(lighting);

        
        Group root = new Group();
        root.getChildren().addAll(rect, cir);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
