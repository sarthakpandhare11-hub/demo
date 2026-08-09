package com.example.view;

import com.example.controller.PlayerController;
import com.example.model.Player;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage extends Application {

    @Override
    public void start(Stage stage) {

        TextField txtName = new TextField();
        txtName.setPromptText("Player Name here");

        TextField txtJersey = new TextField();
        txtJersey.setPromptText("Jersey Number here");

        TextField txtCountry = new TextField();
        txtCountry.setPromptText("Player Country");

        Button btnAdd = new Button("Add Data To Firebase");

        Button btnFetchAll = new Button("Fetch All Players");

        Button btnFetch = new Button("Fetch Players");

        TextArea area = new TextArea();

        PlayerController controller = new PlayerController();

        btnAdd.setOnAction(e -> {

            controller.addPlayer(
                    txtName.getText(),
                    txtJersey.getText(),
                    txtCountry.getText());

            txtName.clear();
            txtJersey.clear();
            txtCountry.clear();

        });

        btnFetch.setOnAction(e -> {

            if (!txtJersey.getText().isEmpty()) {

                Player player = controller.getPlayer(txtJersey.getText());

                if (player != null) {

                    txtName.clear();
                    txtJersey.clear();
                    txtCountry.clear();

                    txtName.setText(player.getPlayerName());
                    txtJersey.setText(player.getJerseyNo());
                    txtCountry.setText(player.getPlayerCountry());
                }
            }
        });

        btnFetchAll.setOnAction(e -> {

            area.clear();

            for (Player player : controller.getAllPlayers()) {

                area.appendText(
                        player.getPlayerName()
                                + "   "
                                + player.getJerseyNo()
                                + "   "
                                + player.getPlayerCountry()
                                + "\n");

            }

        });

        Button btnUpdate = new Button("Update Player");

        btnUpdate.setOnAction(e -> {

            if (!txtJersey.getText().isEmpty()) {

                controller.updatePlayer(
                        txtName.getText(),
                        txtJersey.getText(),
                        txtCountry.getText());

                txtName.clear();
                txtJersey.clear();
                txtCountry.clear();
            }
        });

        Button btnDelete = new Button("Delete Player");

        btnDelete.setOnAction(e -> {
            if (!txtJersey.getText().isEmpty()) {

                controller.deletePlayer(txtJersey.getText());

                txtName.clear();
                txtJersey.clear();
                txtCountry.clear();
            }
        });

        VBox root = new VBox(10);

        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                txtName,
                txtJersey,
                txtCountry,
                btnAdd,
                btnFetch,
                btnFetchAll,
                btnUpdate,
                btnDelete,
                area);

        Scene scene = new Scene(root, 400, 450);

        stage.setScene(scene);
        stage.setTitle("Firebase Firestore");
        stage.show();

    }

}
