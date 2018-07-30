package me.arun.paginglibrarysample.dao;

import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import me.arun.paginglibrarysample.model.Player;


@Dao
public interface PlayerDao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Player... players);
    @Query("Select * FROM player WHERE pid== :id")
    Player select(String id);



    @Query("SELECT * FROM player ORDER BY pid ASC")
    DataSource.Factory<Integer,Player> liveListData();


}
