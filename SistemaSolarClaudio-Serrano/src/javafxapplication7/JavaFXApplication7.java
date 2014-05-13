/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcToBuilder;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.MoveToBuilder;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author claudio
 */
public class JavaFXApplication7 extends Application {

    @Override
    public void start(Stage primaryStage) {

         Button tierraInicio = ButtonBuilder.create()
                .text("Tierra Inicio")
                .build();

         Button tierraParar = ButtonBuilder.create()
                .text("Tierra Parar")
                .build();

         Button venusInicio = ButtonBuilder.create()
                .text("Venus Inicio")
                .build();

         Button venusParar = ButtonBuilder.create()
                .text("Venus Parar")
                .build();
         Button mercurioInicio = ButtonBuilder.create()
                .text("Mercurio Inicio")
                .build();

        Button mercurioParar = ButtonBuilder.create()
                .text("Mercurio Parar")
                .build();
       Button marteInicio = ButtonBuilder.create()
                .text("Marte Inicio")
                .build();

        Button marteParar = ButtonBuilder.create()
                .text("Marte Parar")
                .build();

        Circle sol = CircleBuilder.create()
                .radius(40)
                .fill(Color.YELLOW)
                .layoutX(350)
                .layoutY(325)
                .build();

        Circle tierra = CircleBuilder.create()
                .radius(20)
                .fill(Color.BLUE)
                // .layoutX(188)
                // .layoutY(325)
                .build();

        MoveTo iniTierra = MoveToBuilder.create()
                .x(150)
                .y(325)
                .build();

        ArcTo arco = ArcToBuilder.create()
                .x(480)
                .y(325)
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();

        ArcTo arco2 = ArcToBuilder.create()
                .x(150)
                .y(325)
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();

        Path path = PathBuilder.create()
                .elements(iniTierra, arco, arco2)
                .build();

   final     PathTransition aniTierra = PathTransitionBuilder.create()
                .duration(new Duration(4000.0))
                .node(tierra)
                .path(path)
                .rate(0.41f)
                // .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                .interpolator(Interpolator.LINEAR)
                // .autoReverse(true)
                .cycleCount(Timeline.INDEFINITE)
                .build();


        aniTierra.play();







        Circle mercurio = CircleBuilder.create()
                .radius(7)
                .fill(Color.ORANGE)
                .build();

        MoveTo iniMer = MoveToBuilder.create()
                .x(290)
                .y(325)
                .build();

        ArcTo arcMer = ArcToBuilder.create()
                .radiusX(50)
                .radiusY(50)
                .x(410)
                .y(325)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();


        ArcTo arcMer2 = ArcToBuilder.create()
                .radiusX(50)
                .radiusY(50)
                .x(290)
                .y(325)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();

        Path pathMerc = PathBuilder.create()
                .elements(iniMer, arcMer, arcMer2)
                .build();

final        PathTransition aniMerc = PathTransitionBuilder.create()
                .duration(new Duration(4000.0))
                .node(mercurio)
                .rate(1.705f)
                .path(pathMerc)
                .interpolator(Interpolator.LINEAR)
                .cycleCount(Timeline.INDEFINITE)
                .build();


        aniMerc.play();

        Circle venus = CircleBuilder.create()
                .radius(14)
                .fill(Color.MAGENTA)
                //                .layoutX(240)
                //                .layoutY(325)
                .build();

        MoveTo iniVenus = MoveToBuilder.create()
                .x(240)
                .y(325)
                .build();

        ArcTo arcVenus = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .x(440)
                .y(325)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();


        ArcTo arcVenus2 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .x(240)
                .y(325)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();

        Path pathVenus = PathBuilder.create()
                .elements(iniVenus, arcVenus, arcVenus2)
                .build();

final        PathTransition aniVenus = PathTransitionBuilder.create()
                .duration(new Duration(4000.0))
                .node(venus)
                .rate(0.66f)
                .path(pathVenus)
                .interpolator(Interpolator.LINEAR)
                .cycleCount(Timeline.INDEFINITE)
                .build();


        aniVenus.play();

        Circle marte = CircleBuilder.create()
                .radius(10)
                .fill(Color.RED)
                //                .layoutX(100)
                //                .layoutY(325)
                .build();

        MoveTo iniMarte = MoveToBuilder.create()
                .x(90)
                .y(325)
                .build();

        ArcTo arcMarte = ArcToBuilder.create()
                .radiusX(200)
                .radiusY(200)
                .x(550)
                .y(325)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();


        ArcTo arcMarte2 = ArcToBuilder.create()
                .radiusX(200)
                .radiusY(200)
                .x(90)
                .y(325)
                .largeArcFlag(true)
                .sweepFlag(true)
                .build();

        Path pathMarte = PathBuilder.create()
                .elements(iniMarte, arcMarte, arcMarte2)
                .build();

final        PathTransition aniMarte = PathTransitionBuilder.create()
                .duration(new Duration(4000.0))
                .node(marte)
                .rate(0.17f)
                .path(pathMarte)
                .interpolator(Interpolator.LINEAR)
                .cycleCount(Timeline.INDEFINITE)
                .build();


        aniMarte.play();





        VBox btnTierra = VBoxBuilder.create()
                .children(tierraInicio, tierraParar)
                .build();

        VBox btnMercurio = VBoxBuilder.create()
                .children(mercurioInicio, mercurioParar)
                .build();

        VBox btnMarte = VBoxBuilder.create()
                .children(marteInicio, marteParar)
                .build();

        VBox btnVenus = VBoxBuilder.create()
                .children(venusInicio, venusParar)
                .build();

        HBox botonera = HBoxBuilder.create()
                .children(btnMercurio, btnVenus, btnTierra, btnMarte)
                .spacing(10)
                .layoutX(250)
                .layoutY(590)
                .build();

        Scene scene = SceneBuilder.create()
                .width(700)
                .height(650)
                .fill(Color.BLACK)
                .root(
                GroupBuilder.create()
                .children(sol, mercurio, venus, tierra, marte, botonera)
                .build())
                .build();

        primaryStage.setTitle("Sistema Solar - Claudio Serrano");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        tierraInicio.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
           
                aniTierra.play();
                
            }
        });
        
        tierraParar.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
            aniTierra.pause();
             }
         });
        
        mercurioInicio.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
            aniMerc.play();
             }
         });
        
        mercurioParar.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
            aniMerc.pause();
             }
         });
        
        venusInicio.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
            aniVenus.play();
             }
         });
        
        venusParar.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
            aniVenus.pause();
             }
         });
        
        marteInicio.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
            aniMarte.play();
             }
         });
        
        marteParar.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent t) {
            //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            aniMarte.pause();
                
             }
         });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
