package me.arun.paginglibrarysample;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.amitshekhar.DebugDB;

import me.arun.paginglibrarysample.adapter.PlayerAdapter;
import me.arun.paginglibrarysample.model.Player;
import me.arun.paginglibrarysample.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    RecyclerView recyclerView;
    MainViewModel mainViewModel;
    PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: "+ DebugDB.getAddressLog());
        recyclerView=(RecyclerView)findViewById(R.id.rvPlayers);
        playerAdapter=new PlayerAdapter(this);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.usersList.observe(this,pagedList->playerAdapter.submitList(pagedList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(playerAdapter);



    }
}
