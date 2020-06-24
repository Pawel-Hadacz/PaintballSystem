package Gui;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.ArenaController;
import Model.Arena;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class FXMLController implements Initializable {

    private ArenaController arenaController = new ArenaController();
    private ObservableList<Arena> arenasList;

    @FXML
    private Label label;
    private ListView listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
       // label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }
}
