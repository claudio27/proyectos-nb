/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author profesor
 */
public class Ejemplo2 extends Application {
    
    private BufferedReader buffer;
    private FileReader reader;
    
    @Override
    public void start(Stage primaryStage) {
        
            Group root = new Group();
            Scene scene = new Scene(root, 500, 400);
            
            CategoryAxis ejeX = new CategoryAxis();
            ejeX.setLabel("Meses");
            NumberAxis ejeY = new NumberAxis(0, 70, 5);
            ejeY.setLabel("$");
            
            ObservableList<XYChart.Data> datosSerie = FXCollections.observableArrayList();
                try 
                {
                reader = new FileReader(new File("datos.txt"));
                buffer = new BufferedReader(reader);
            
                String linea = buffer.readLine();

                while( linea != null)
                {
                    StringTokenizer st = new StringTokenizer(linea, ":");
                    String mes = st.nextToken();
                    Double valor = Double.valueOf(st.nextToken());
                    XYChart.Data dato = new XYChart.Data<>(mes, valor);
                    datosSerie.add(dato);
                    linea = buffer.readLine();
                }
            
                } 
                catch (FileNotFoundException ex) 
                {
                    ;
                }
                catch (IOException ex) 
                {
                    ;
                }
            
                final XYChart.Series serie = new XYChart.Series( datosSerie);
                serie.setName("Ventas M$");
        
                LineChart linea = new LineChart(ejeX, ejeY);
                linea.setTitle("Ventas");
                //linea.setMaxSize(450, 350);
                
                
        
                linea.getData().add(serie);
                
                serie.getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    serie.getNode().setStyle(" -fx-stroke: red;");
                }
            });
               
                root.getChildren().add(linea);
            
                primaryStage.setTitle("Gráfico");
                primaryStage.setScene(scene);
                primaryStage.show();
        
        }
}
