package me.arun.paginglibrarysample.viewModel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import me.arun.paginglibrarysample.PagingLibraryApplication;
import me.arun.paginglibrarysample.dao.PlayerDao;
import me.arun.paginglibrarysample.model.Player;


public class MainViewModel extends AndroidViewModel
{
    private static final int INITIAL_LOAD_KEY = 0;
    private static final int PAGE_SIZE = 10;
    private static final int PREFETCH_DISTANCE = 5;
    public PagingLibraryApplication pagingLibraryApplication;
    public LivePagedListBuilder livePlyerList;
    public final LiveData<PagedList<Player>> usersList;


    public MainViewModel(@NonNull Application application)
    {
        super(application);
        pagingLibraryApplication =(PagingLibraryApplication) application;
        PlayerDao playerDao= pagingLibraryApplication.appDataBase.bookDao();
        usersList = new LivePagedListBuilder<>(
                playerDao.liveListData(), /* page size */ PAGE_SIZE).setInitialLoadKey(INITIAL_LOAD_KEY).build();
        livePlyerList=new LivePagedListBuilder(playerDao.liveListData(),new PagedList.Config.Builder().setPageSize(PAGE_SIZE).setPrefetchDistance(PREFETCH_DISTANCE).setPageSize(PAGE_SIZE).build());



//        val allCheeses = LivePagedListBuilder(dao.allCheesesByName(), PagedList.Config.Builder()
//                .setPageSize(PAGE_SIZE)
//                .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
//                .build()).build()

    }


}
