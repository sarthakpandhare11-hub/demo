package com.example.controller;

import java.util.List;

import com.example.dao.PlayerDao;
import com.example.model.Player;

public class PlayerController {

    PlayerDao dao = new PlayerDao();

    public void addPlayer(String name,
            String jersey,
            String country) {

        Player player = new Player(name, jersey, country);

        dao.savePlayer(player);

    }

    public void updatePlayer(String name,
            String jersey,
            String country) {

        Player player = new Player(name, jersey, country);

        dao.updatePlayer(player);

    }

    public void deletePlayer(String jerseyNo) {

        dao.deletePlayer(jerseyNo);
    }

    public List<Player> getAllPlayers() {

        return dao.getPlayers();

    }

    public Player getPlayer(String jerseyNo) {

        return dao.getPlayer(jerseyNo);
    }

}
