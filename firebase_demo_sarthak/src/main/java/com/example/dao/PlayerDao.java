package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.config.FirebaseConfig;
import com.example.model.Player;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

public class PlayerDao {

    private Firestore db = FirebaseConfig.getFirestore();

    public void savePlayer(Player player) {

        try {

            db.collection("Players")
                    .document(player.getJerseyNo())
                    .set(player);

            System.out.println("Data Inserted");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updatePlayer(Player player) {

        try {

            db.collection("Players")
                    .document(player.getJerseyNo())
                    .set(player);

            System.out.println("Data Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePlayer(String jerseyNo) {

        try {

            db.collection("Players")
                    .document(jerseyNo)
                    .delete();

            System.out.println("Data Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Player> getPlayers() {

        List<Player> list = new ArrayList<>();

        try {

            ApiFuture<QuerySnapshot> future = db.collection("Players").get();

            QuerySnapshot snapshot = future.get();

            for (DocumentSnapshot doc : snapshot.getDocuments()) {

                Player player = doc.toObject(Player.class);

                list.add(player);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    public Player getPlayer(String jersey) {

        try {

            ApiFuture<DocumentSnapshot> future = db.collection("Players")
                    .document(jersey)
                    .get();

            DocumentSnapshot document = future.get();

            if (document.exists()) {
                return document.toObject(Player.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
