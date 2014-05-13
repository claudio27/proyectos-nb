/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eventosgrafico;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author profesor
 */
public class EventosGrafico extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400);
        
        CategoryAxis ejeX = new CategoryAxis();
        ejeX.setLabel("Meses");
        NumberAxis ejeY = new NumberAxis(0, 10, 1);
        ejeY.setLabel("$");
        
        ObservableList<XYChart.Data> datosSerie = FXCollections.observableArrayList();
        
        String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio"};
        
        for(int i=0 ; i<meses.length ; i++)
        {  
           XYChart.Data dato = new XYChart.Data<>(meses[i],i+1);
           datosSerie.add(dato);
        }
        
        XYChart.Series serie = new XYChart.Series( datosSerie);
//        serie.getData().add(datosSerie);
        serie.setName("Ventas M$");
        
        LineChart linea = new LineChart(ejeX, ejeY);
        linea.setTitle("Ventas");
        linea.setMaxSize(450, 350);
        
        linea.getData().add(serie);
        
 
        
//        final Label nodo = new Label("");
        
        root.getChildren().addAll(linea);
        
        for(final Object data : serie.getData())
        {
            ((XYChart.Data)data).getNode().addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Node nodo = ((XYChart.Data)data).getNode();
//                    String texto = (((XYChart.Data)data).getXValue().toString())
//                            + " - " + (((XYChart.Data)data).getYValue().toString());
                    Tooltip tp = new Tooltip();
//                    tp.setText(texto);
                    GridPane grid = new GridPane();
                    Label mes = new Label(((XYChart.Data)data).getXValue().toString());
                    Label valor = new Label(((XYChart.Data)data).getYValue().toString());
                    GridPane.setConstraints(mes, 1, 1);
                    GridPane.setConstraints(valor, 1, 2);
                    grid.getChildren().addAll(mes,valor);
                    tp.setGraphic(grid);
                    Tooltip.install(nodo, tp);
//                    nodo.setTranslateX(t.getSceneX());
//                    nodo.setTranslateY(t.getSceneY());
//                    nodo.setText(texto);
//                    System.out.println(t.getSceneX());
                    // TAREA: MOVER EL NODO CON EL PUNTERO EL RATÓN
                    
                }
            });
        }
        primaryStage.setTitle("Gráfico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
