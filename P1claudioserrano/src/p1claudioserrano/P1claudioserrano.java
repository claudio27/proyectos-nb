package p1claudioserrano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author claudio
 */
public class P1claudioserrano extends Application {
    
    private LineChart lineas;
    public FileReader reader;
    public BufferedReader buffer;
    public XYChart.Series selectedSeries;
    public DropShadow ds = new DropShadow();
    int num = 1;
    
    
    @Override
    public void start(Stage stage) {


// Use a border pane as the root for scene
        BorderPane border = new BorderPane();
        
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setCenter(addVBox());
     
        
        
       

        Scene scene = new Scene(border,700,500);
        stage.setScene(scene);
        stage.setTitle("P1 Electivo V - Claudio Serrano");
        stage.show();
    }

    
    public HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");

     Button agregar = new Button();
        agregar.setText("Agregar");
        agregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
               // arreglar la manipulacion de eventos
                 lineas.getData().addAll(getSerie());
                 
                
            }
        });
       
   
        
        Button quitar = new Button();
        quitar.setText("Quitar");
        quitar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                
            }
        });
   
        
        // llama  a color picker para asignar color
        // es necesario captar la linea de la serie correspondiente para usarla para cambiar los datos
        
        final ColorPicker colorPicker = new ColorPicker();
     
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                
                 if (selectedSeries != null) {

                     Color value = colorPicker.getValue();
                     String strColor = value.toString();
                     String color = strColor.substring(2);
                     
                     System.out.println("Cambio color"+color);
                    selectedSeries.getNode().setStyle("-fx-stroke:#"+color+";");
                }
                //text.setFill(colorPicker.getValue());
            }
        });
   
        
        // muestra o oculta los simbolos de la serie
        Button mostrarOcultar = new Button();
        mostrarOcultar.setText("Mostrar Ocultar");
        mostrarOcultar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if (selectedSeries != null) {
                
                     lineas.setCreateSymbols(false);
                     
                 
                 }
            }
        });
   
        
        
        Button cambiaEscala = new Button();
        cambiaEscala.setText("Cambiar Escala");
        cambiaEscala.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
          
                
                
                
            }
        });
   
        
           
        
        
        
        hbox.getChildren().addAll(agregar,quitar, colorPicker, mostrarOcultar, cambiaEscala);
        
        return hbox;
    }
    

    public VBox addVBox() {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes

        
        //--------------------Grafico--------------------------------
        
        CategoryAxis ejeXLineas = new CategoryAxis();
        ejeXLineas.setLabel("Meses");
        NumberAxis ejeYLineas = new NumberAxis(0, 20, 2);
        ejeYLineas.setLabel("Ventas M$");
  
       
        
        lineas = getGraficoLineas(ejeXLineas,ejeYLineas);
        
        vbox.getChildren().add(lineas);

        
        return vbox;
    }

    public LineChart getGraficoLineas(CategoryAxis ejeXLineas, NumberAxis ejeYLineas) {
        
        LineChart graficoLineas = new LineChart(ejeXLineas, ejeYLineas);
        graficoLineas.setMaxSize(400, 400);
        graficoLineas.setTitle("Ventas por Tienda");
        
        XYChart.Series serie1 = new XYChart.Series();
        serie1.setName("Santiago Centro");
        serie1.getData().add(new XYChart.Data("Enero", 2));
        serie1.getData().add(new XYChart.Data("Febrero", 4));
        serie1.getData().add(new XYChart.Data("Marzo", 6));
        serie1.getData().add(new XYChart.Data("Abril", 8));
        
        XYChart.Series serie2 = new XYChart.Series();
        serie2.setName("La Florida");
        serie2.getData().add(new XYChart.Data("Enero", 1));
        serie2.getData().add(new XYChart.Data("Febrero", 3));
        serie2.getData().add(new XYChart.Data("Marzo", 9));
        serie2.getData().add(new XYChart.Data("Abril", 11));
       
        graficoLineas.getData().addAll(serie1,serie2);
        applyMouseEvents(serie1);
        applyMouseEvents(serie2);
        
       
        return graficoLineas;
    }
    
     public void applyMouseEvents(final XYChart.Series series) {

        final Node node = series.getNode();

        node.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                node.setEffect(ds);
                node.setCursor(Cursor.HAND);
            }
        });

        node.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                node.setEffect(null);
                node.setCursor(Cursor.DEFAULT);
            }
        });

        node.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                  
                    // Set as selected
                    selectedSeries = series;
                    System.out.println("Selected Series data " + selectedSeries.getData());
                }
            }
        });
    }

    
    public XYChart.Series getSerie(){

        ObservableList<XYChart.Data> datosSerie = FXCollections.observableArrayList();
                
        
                
                String nombre = "datos";
                String ext = ".txt";
                
                String file = nombre + num + ext;
                 
                try 
                {
                reader = new FileReader(new File(file));
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
                    System.out.println(ex);
                }
                catch (IOException ex) 
                {
                    System.out.println(ex);
                }
                
//                 control de archivo, se pueden agregar 3 series
               if(num <= 3 ){
                
                ++num;
                }
               System.out.println(file);
                
             XYChart.Series serien = new XYChart.Series(datosSerie);
        serien.setName("Serie Nueva");
        //applyMouseEvents(serien);
                
        
        return serien;
        }
    
     public XYChart.Series borraSerie(){

        ObservableList<XYChart.Data> datosSerie = FXCollections.observableArrayList();
                
        
                
                 
                try 
                {
                reader = new FileReader(new File("borra.txt"));
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
                    System.out.println(ex);
                }
                catch (IOException ex) 
                {
                    System.out.println(ex);
                }
                
              
                
             XYChart.Series serien = new XYChart.Series(datosSerie);
        serien.setName("Serie Nueva");
        //applyMouseEvents(serien);
                
        
        return serien;
        }

}
