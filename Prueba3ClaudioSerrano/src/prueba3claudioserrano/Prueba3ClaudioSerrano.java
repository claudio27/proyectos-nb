package prueba3claudioserrano;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.RotateTransition;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcToBuilder;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.EllipseBuilder;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.MoveToBuilder;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author claudio
 */
public class Prueba3ClaudioSerrano extends Application {

    @Override
    public void start(Stage primaryStage) {

//        Light.Point light = new Light.Point();
//        light.setX(320);
//        light.setY(325);
//        light.setZ(60);
//        
//        
//        Lighting lighting = new Lighting();
//        lighting.setLight(light);
//        

        Ellipse luz = EllipseBuilder.create()
                .centerX(320)
                .centerY(325)
                .opacity(0.03)
                .radiusX(160)
                .fill(javafx.scene.paint.Color.WHITE)
                .radiusY(160)
                .build();

        Ellipse sombra = EllipseBuilder.create()
                .centerX(320)
                .centerY(325)
                .opacity(0.5)
                .fill(javafx.scene.paint.Color.GREEN)
                .radiusX(200)
                .radiusY(200)
                .build();

        Shape substraccion = Path.subtract(sombra, luz);
        substraccion.setOpacity(0.7);



        Circle sol = CircleBuilder.create()
                .radius(40)
                .fill(new ImagePattern(new Image("img/sol.jpg")))
                .layoutX(350)
                .layoutY(325)
                .build();

        Circle tierra = CircleBuilder.create()
                .radius(20)
                .fill(new ImagePattern(new Image("img/tierra2.jpg")))
                // .layoutX(188)
                // .layoutY(325)
                //                .opacity(0.5)
                //.effect(lighting)
                .build();


        MoveTo iniTierraSol = MoveToBuilder.create()
                .x(150)
                .y(325)
                .build();

        ArcTo arcoSol = ArcToBuilder.create()
                .x(480)
                .y(325)
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();

        ArcTo arco2Sol = ArcToBuilder.create()
                .x(150)
                .y(325)
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();

        Path pathTierraSol = PathBuilder.create()
                .elements(iniTierraSol, arcoSol, arco2Sol)
                .build();

        final PathTransition aniTierraSol = PathTransitionBuilder.create()
                .duration(new Duration(4000.0))
                .node(tierra)
                .path(pathTierraSol)
                .rate(0.41f)
                .interpolator(Interpolator.LINEAR)
                .cycleCount(Timeline.INDEFINITE)
                .build();

        final RotateTransition rotacion = RotateTransitionBuilder.create()
                .duration(new Duration(100000))
                .node(tierra)
                .byAngle(360f)
                .cycleCount(Timeline.INDEFINITE)
                .build();



        aniTierraSol.play();
//        rotacion.play();


        Group root = GroupBuilder.create()
                .children(sol, tierra, substraccion).build();

        Scene scene = new Scene(root, 700, 600);
        scene.setFill(javafx.scene.paint.Color.BLACK);


        primaryStage.setTitle("P3 - JavaFx - Claudio Serrano");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
