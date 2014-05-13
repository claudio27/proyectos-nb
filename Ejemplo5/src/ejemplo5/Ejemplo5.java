/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Lili
 */

public class Ejemplo5 extends Application {
    
    private String[] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio"};
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);        
        
        CategoryAxis ejeXLineas = new CategoryAxis();
        ejeXLineas.setLabel("Meses");
        NumberAxis ejeYLineas = new NumberAxis(0, 10, 1);
        ejeYLineas.setLabel("Ventas M$");
        
        ObservableList<LineChart.Data> datosSerie = datosSerie = FXCollections.observableArrayList();
        
        for(int i=0;i<meses.length;i++)
        {
            LineChart.Data dato = new LineChart.Data(meses[i],i+1);
            datosSerie.add(dato);
        }
        
        LineChart graficoLineas = new LineChart(ejeXLineas,ejeYLineas);
        graficoLineas.setMaxSize(350, 300);
        graficoLineas.setTitle("Ventas por Tienda");   
        
        LineChart.Series serie = new LineChart.Series(datosSerie);
        serie.setName("Santiago");
        graficoLineas.getData().add(serie);
        
        final Label etiqueta = new Label("");
        etiqueta.setTextFill(Color.DARKORANGE);
        etiqueta.setStyle("-fx-font: 24 arial;");
        
        for(final Object dato: serie.getData())
        {
            ((XYChart.Data)dato).getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    etiqueta.setTranslateX(t.getSceneX());
                    etiqueta.setTranslateY(t.getSceneY());
                    etiqueta.setText(String.valueOf("["+ ((XYChart.Data)dato).getXValue().toString()) + "," +
                                                    ((XYChart.Data)dato).getYValue().toString() +"]");
                    
                    //TAREA: AGREGAR EVENTO QUE PERMITA ARRASTRAR UN NODO DEL GRÁFICO CON EL PUNTERO DEL MOUSE
                }
            });
        }
        
        root.getChildren().addAll(graficoLineas,etiqueta);
        
        primaryStage.setTitle("Gráficos");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
