/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo4;

/**
 *
 * @author Lili
 */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Colors extends Application {

    ListView<String> list = new ListView<String>();
    ObservableList<String> data = FXCollections.observableArrayList(
            "chocolate", "salmon", "gold", "coral",
            "chocolate", "salmon", "gold", "coral",
            "chocolate", "salmon", "gold", "coral",
            "chocolate", "salmon", "gold", "coral");
    final Label label = new Label();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 200, 200);
        stage.setScene(scene);
        vbox.getChildren().addAll(list, label);
        VBox.setVgrow(list, Priority.ALWAYS);
        
        label.setLayoutX(10);
        label.setLayoutY(115);
        label.setFont(Font.font("Verdana", 20));
        
        list.setItems(data);
        
        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ColorRectCell();
            }
            
        });
        
        list.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {

                    @Override
                    public void changed(ObservableValue<? extends String> ov, 
                            String t, String t1) {
                        
                        label.setText(t1);
                        label.setTextFill(Color.web(t1));
                    }
                    
                });
        
        stage.show();
    }
    
    
    
    static class ColorRectCell extends ListCell<String> {

        @Override
        protected void updateItem(String t, boolean bln) {
            super.updateItem(t, bln);
            Rectangle rect = new Rectangle(100, 20);
            if (t != null) {
                rect.setFill(Color.web(t));
                setGraphic(rect);
            }
        }
    }
}
