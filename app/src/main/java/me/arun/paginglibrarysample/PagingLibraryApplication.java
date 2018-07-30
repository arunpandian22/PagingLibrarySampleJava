package me.arun.paginglibrarysample;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import me.arun.paginglibrarysample.localDb.AppDataBase;
import me.arun.paginglibrarysample.model.Player;
import me.arun.paginglibrarysample.model.Players;
import me.arun.paginglibrarysample.sharedPref.AppStorage;


public class PagingLibraryApplication extends Application
{

    public AppStorage appStorage;
    public AppDataBase appDataBase;
    String TAG="ArBookApplication";

    public AppStorage getAppStorage()
    {
        return appStorage;
    }

    public void setAppStorage(AppStorage appStorage)
    {
        this.appStorage = appStorage;
    }

    public AppDataBase getAppDataBase()
    {
        return appDataBase;
    }

    public void setAppDataBase(AppDataBase appDataBase)
    {
        this.appDataBase = appDataBase;
    }

    public void onCreate()
    {
       super.onCreate();
        appDataBase=AppDataBase.getAppDatabase(getApplicationContext());
        appStorage=new AppStorage(getApplicationContext(),getString(R.string.appSharedPref));

        if (!appStorage.getBooleanDetails(getString(R.string.isDataStored)))
        {
            String json=loadJSONFromAsset();
            Log.d(TAG, "onCreate: "+json);
            Gson gson=new  GsonBuilder().create();
            if (json!=null)
            {
                Players modelBook=gson.fromJson(json,Players.class);
                if (modelBook!=null)
                {
                    Player[] books= modelBook.getPlayers().toArray(new Player[modelBook.getPlayers().size()]);
                    Log.d(TAG, "onCreate: "+books.length);
                 appDataBase.bookDao().insert(books);
                 appStorage.setBooleanDetails(getString(R.string.isDataStored),true);
                }
            }
        }
//        Log.d(TAG, "onCreate: jsondata "+loadJSONFromAsset());

    }



    public String loadJSONFromAsset()
    {
        String json = null;
        try {
            InputStream is = getAssets().open("DBData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
