/*
 * para el boton agregar un observable list, y dentro el boton
 * 
 */
package ejemplo4;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// CANDLESTICK CHART, HACER EJERCICIO DE LA DIAPOSITIVA

public class Ejemplo4 extends Application {
    
    private BarChart barras;
    private LineChart lineas;
    private ScatterChart dispersion;
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 400);
        
        scene.getStylesheets().add("css/chart.css");
        
        
        GridPane grid = new GridPane();
        
   
        
       
        
        CategoryAxis ejeXBarras = new CategoryAxis();
        ejeXBarras.setLabel("Meses");
        NumberAxis ejeYBarras = new NumberAxis(0, 20, 2);
        ejeYBarras.setLabel("Ventas M$");
        
        barras = getGraficoBarras(ejeXBarras, ejeYBarras);
        GridPane.setConstraints(barras, 1, 1);
        
        CategoryAxis ejeXLineas = new CategoryAxis();
        ejeXLineas.setLabel("Meses");
        NumberAxis ejeYLineas = new NumberAxis(0, 20, 2);
        ejeYLineas.setLabel("Ventas M$");
        
        lineas = getGraficoLineas(ejeXLineas,ejeYLineas);
        GridPane.setConstraints(lineas, 2, 1);
        
        
        CategoryAxis ejeXDispersion = new CategoryAxis();
        ejeXDispersion.setLabel("Meses");
        NumberAxis ejeYDispersion = new NumberAxis(0, 20, 2);
        ejeYDispersion.setLabel("Ventas M$");
        
        dispersion = getGraficoDispersion(ejeXDispersion, ejeYDispersion);
        GridPane.setConstraints(dispersion, 3, 1);
        
        
        ///
        grid.getChildren().addAll(barras,lineas,dispersion);
        
        root.getChildren().add(grid);
        
        primaryStage.setTitle("Ejemplo Gráficos");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
    
    private BarChart getGraficoBarras(CategoryAxis ejeX, NumberAxis ejeY)
    {
        BarChart graficoBarras = new BarChart(ejeX, ejeY);
        graficoBarras.setMaxSize(350, 300);
        graficoBarras.setTitle("Ventas por Ciudad");
        
        XYChart.Series serie1 = new XYChart.Series();
        serie1.setName("Santiago");
        serie1.getData().add(new XYChart.Data("Enero", 2));
        serie1.getData().add(new XYChart.Data("Febrero", 4));
        serie1.getData().add(new XYChart.Data("Marzo", 6));
        serie1.getData().add(new XYChart.Data("Abril", 8));
        
        XYChart.Series serie2 = new XYChart.Series();
        serie2.setName("Antofagasta");
        serie2.getData().add(new XYChart.Data("Enero", 1));
        serie2.getData().add(new XYChart.Data("Febrero", 3));
        serie2.getData().add(new XYChart.Data("Marzo", 9));
        serie2.getData().add(new XYChart.Data("Abril", 11));
        
        graficoBarras.getData().addAll(serie1,serie2);
        
        return graficoBarras;
    }

    private LineChart getGraficoLineas(CategoryAxis ejeXLineas, NumberAxis ejeYLineas) {
        
        LineChart graficoLineas = new LineChart(ejeXLineas, ejeYLineas);
        graficoLineas.setMaxSize(350, 300);
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
        
        return graficoLineas;
    }
    
        private ScatterChart getGraficoDispersion(CategoryAxis ejeXLineas, NumberAxis ejeYLineas) {
        
        ScatterChart graficoDispersion = new ScatterChart(ejeXLineas, ejeYLineas);
        graficoDispersion.setMaxSize(350, 300);
        graficoDispersion.setTitle("Ventas por Tienda");
        
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
        
        graficoDispersion.getData().addAll(serie1,serie2);
        
        return graficoDispersion;
    }
}
