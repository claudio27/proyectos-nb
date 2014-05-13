package sistemasolar2;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcToBuilder;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.MoveToBuilder;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.util.Duration;

/**
 *
 * @author andradr
 */
public class SistemaSolar2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int ancho = 800;
        final int largo = 800;
        final double factor = 150;

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text texto = TextBuilder.create()
                .layoutX(300)
                .layoutY(80)
                .build();
        texto.setText("SISTEMA SOLAR2");
        texto.setFont(Font.font("BOLD", 36));
        texto.setEffect(ds);
        texto.setFill(Color.WHITE);

        Text texto2 = TextBuilder.create()
                .layoutX(710)
                .layoutY(780)
                .build();
        texto2.setText("By Ricardo Andrade");
        texto2.setFont(Font.font("Bold", 10));
        texto2.setEffect(ds);
        texto2.setFill(Color.WHITE);




        Circle sol = CircleBuilder.create()
                .radius(40)
                .fill(new ImagePattern(new Image("sistemasolar2/SOL.jpg")))
                .centerX(ancho / 2)
                .centerY(largo / 2)
                .effect(new GaussianBlur())
                .build();


//Mercurio

        Circle mercurio = CircleBuilder.create()
                .radius(7)
                .fill(Color.SALMON)
                .build();

        MoveTo inicio_mercurio = MoveToBuilder.create()
                .x(400)
                .y(500)
                .build();
        ArcTo arco_mercurio_1 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(300)
                .build();
        ArcTo arco_mercurio_2 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(500)
                .build();
        Path ruta_mercurio = PathBuilder.create()
                .elements(inicio_mercurio, arco_mercurio_1, arco_mercurio_2)
                .build();

        final PathTransition mercurioRotate = PathTransitionBuilder.create()
                .path(ruta_mercurio)
                .node(mercurio)
                .rate(factor / 87.97)
                .cycleCount(Timeline.INDEFINITE)
                .duration(new Duration(4000))
                .interpolator(Interpolator.LINEAR)
                .build();

// Venus     

        Circle venus = CircleBuilder.create()
                .radius(14)
                .fill(Color.BLUEVIOLET)
                .build();
        MoveTo inicio_venus = MoveToBuilder.create()
                .x(400)
                .y(550)
                .build();
        ArcTo arco_venus_1 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(250)
                .build();
        ArcTo arco_venus_2 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(550)
                .build();
        Path ruta_venus = PathBuilder.create()
                .elements(inicio_venus, arco_venus_1, arco_venus_2)
                .build();
        final PathTransition venusRotate = PathTransitionBuilder.create()
                .path(ruta_venus)
                .node(venus)
                .rate(factor / 224.7)
                .cycleCount(Timeline.INDEFINITE)
                .duration(new Duration(4000))
                .interpolator(Interpolator.LINEAR)
                .build();


//Tierra        

        Circle tierra = CircleBuilder.create()
                .radius(20)
                .fill(new ImagePattern(new Image("sistemasolar2/tierra2.jpg")))
                .effect(new GaussianBlur())
                .build();

        MoveTo inicio_tierra = MoveToBuilder.create()
                .x(400)
                .y(600)
                .build();

        ArcTo arco_tierra_1 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(200)
                .build();
        ArcTo arco_tierra_2 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(600)
                .build();

        Path ruta_tierra = PathBuilder.create()
                .elements(inicio_tierra, arco_tierra_1, arco_tierra_2)
                .build();
        final PathTransition tierraRotate = PathTransitionBuilder.create()
                .path(ruta_tierra)
                .node(tierra)
                .rate(factor / 365.22)
                .cycleCount(Timeline.INDEFINITE)
                .duration(new Duration(4000))
                .interpolator(Interpolator.LINEAR)
                .build();


//Marte          
        Circle marte = CircleBuilder.create()
                .radius(9)
                .fill(Color.RED)
                .build();
        MoveTo inicio_marte = MoveToBuilder.create()
                .x(400)
                .y(650)
                .build();

        ArcTo arco_marte_1 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(150)
                .build();

        ArcTo arco_marte_2 = ArcToBuilder.create()
                .radiusX(100)
                .radiusY(100)
                .largeArcFlag(true)
                .sweepFlag(true)
                .x(400)
                .y(650)
                .build();

        Path ruta_marte = PathBuilder.create()
                .elements(inicio_marte, arco_marte_1, arco_marte_2)
                .build();
        final PathTransition marteRotate = PathTransitionBuilder.create()
                .path(ruta_marte)
                .node(marte)
                .rate(factor / 868.98)
                .cycleCount(Timeline.INDEFINITE)
                .duration(new Duration(4000))
                .interpolator(Interpolator.LINEAR)
                .build();

        mercurioRotate.play();
        venusRotate.play();
        tierraRotate.play();
        marteRotate.play();

//Botones de control

        Button btnMercurioStart = ButtonBuilder.create()
                .layoutX(0)
                .layoutY(660)
                .visible(true)
                .textFill(Color.SALMON)
                .text("Mercurio  > PLAY")
                .build();
        Button btnMercurioStop = ButtonBuilder.create()
                .layoutX(0)
                .layoutY(690)
                .visible(true)
                .textFill(Color.SALMON)
                .text("Mercurio ■ STOP")
                .build();
        Button btnVenusStart = ButtonBuilder.create()
                .layoutX(200)
                .layoutY(660)
                .visible(true)
                .textFill(Color.BLUEVIOLET)
                .text("Venus  > Iniciar")
                .build();
        Button btnVenusStop = ButtonBuilder.create()
                .layoutX(200)
                .layoutY(690)
                .visible(true)
                .textFill(Color.BLUEVIOLET)
                .text("Venus  ■ Detener")
                .build();

        Button btnTierraStart = ButtonBuilder.create()
                .layoutX(400)
                .layoutY(660)
                .visible(true)
                .textFill(Color.BLUE)
                .text("Tierra  >  Iniciar  ")
                .build();
        Button btnTierraStop = ButtonBuilder.create()
                .layoutX(400)
                .layoutY(690)
                .visible(true)
                .textFill(Color.BLUE)
                .text("Tierra ■ Detener")
                .build();

        Button btnMarteStart = ButtonBuilder.create()
                .layoutX(600)
                .layoutY(660)
                .visible(true)
                .textFill(Color.RED)
                .text("Marte > Iniciar  ")
                .build();
        Button btnMarteStop = ButtonBuilder.create()
                .layoutX(600)
                .layoutY(690)
                .visible(true)
                .textFill(Color.RED)
                .text("Marte ■ Detener")
                .build();

        btnMercurioStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                mercurioRotate.play();
            }
        });
        btnMercurioStop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                mercurioRotate.pause();
            }
        });

        btnVenusStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                venusRotate.play();
            }
        });
        btnVenusStop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                venusRotate.pause();
            }
        });
        btnTierraStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                tierraRotate.play();
            }
        });
        btnTierraStop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                tierraRotate.pause();
            }
        });
        btnMarteStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                marteRotate.play();
            }
        });
        btnMarteStop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                marteRotate.pause();
            }
        });


        Scene scene = SceneBuilder.create()
                .width(ancho)
                .height(largo)
                .fill(new ImagePattern(new Image("sistemasolar2/universo.jpg")))
                .root(GroupBuilder.create().children(texto, texto2, sol, mercurio, venus,
                tierra, marte, btnMercurioStart, btnMercurioStop,
                btnVenusStart, btnVenusStop, btnTierraStart, btnTierraStop,
                btnMarteStart, btnMarteStop).build())
                .build();


        primaryStage.setTitle("Sistema Solar2");
        primaryStage.setScene(scene);
        primaryStage.show();




    }
}
