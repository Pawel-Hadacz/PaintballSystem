package Gui;

import Config.DatabaseConfig;
import Controller.ArenaController;
import Model.Arena;
import Model.Rent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AvailableArenasController implements Initializable {
    private ArenaController arenaController = new ArenaController();

    @FXML
    private ObservableList<Arena> arenasList;
    @FXML
    private ObservableList<Rent> rents;
    @FXML
    private ListView arenaList;
    @FXML
    private ListView rentsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arenaController.createSampleData();
        arenasList = FXCollections.observableArrayList();
        arenasList.addAll(arenaController.findAllArenasCriteriaQuery());
        arenaList.setItems(arenasList);
        arenaList.getSelectionModel().getSelectedItem();

    }
    @FXML void handleClickListView(){
        Arena selectedArena = (Arena) arenaList.getSelectionModel().getSelectedItem();
        rents = FXCollections.observableArrayList();
        rents.addAll(selectedArena.getRents());
        rentsList.setItems(rents);
    }
}
