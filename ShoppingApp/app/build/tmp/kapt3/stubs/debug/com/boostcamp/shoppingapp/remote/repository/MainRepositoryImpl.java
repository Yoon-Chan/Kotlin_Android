package com.boostcamp.shoppingapp.remote.repository;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import com.boostcamp.shoppingapp.remote.MainPagingSource;
import com.boostcamp.shoppingapp.remote.MainService;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/boostcamp/shoppingapp/remote/repository/MainRepositoryImpl;", "Lcom/boostcamp/shoppingapp/remote/repository/MainRepository;", "mainService", "Lcom/boostcamp/shoppingapp/remote/MainService;", "(Lcom/boostcamp/shoppingapp/remote/MainService;)V", "loadList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/boostcamp/shoppingapp/model/ListItem;", "app_debug"})
public final class MainRepositoryImpl implements com.boostcamp.shoppingapp.remote.repository.MainRepository {
    private final com.boostcamp.shoppingapp.remote.MainService mainService = null;
    
    @javax.inject.Inject
    public MainRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.boostcamp.shoppingapp.remote.MainService mainService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.boostcamp.shoppingapp.model.ListItem>> loadList() {
        return null;
    }
}