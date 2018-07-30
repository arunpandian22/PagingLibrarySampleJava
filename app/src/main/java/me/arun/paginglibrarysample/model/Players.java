
package me.arun.paginglibrarysample.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Players {

    @SerializedName("players")
    private List<Player> mPlayers;

    public List<Player> getPlayers() {
        return mPlayers;
    }

    public void setPlayers(List<Player> players) {
        mPlayers = players;
    }

}
