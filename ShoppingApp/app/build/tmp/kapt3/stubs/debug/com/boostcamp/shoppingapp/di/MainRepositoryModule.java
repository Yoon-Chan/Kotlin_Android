package com.boostcamp.shoppingapp.di;

import com.boostcamp.shoppingapp.remote.MainService;
import com.boostcamp.shoppingapp.remote.repository.MainRepository;
import com.boostcamp.shoppingapp.remote.repository.MainRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ViewModelComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/boostcamp/shoppingapp/di/MainRepositoryModule;", "", "()V", "providesMainRepository", "Lcom/boostcamp/shoppingapp/remote/repository/MainRepository;", "mainService", "Lcom/boostcamp/shoppingapp/remote/MainService;", "app_debug"})
@dagger.Module
public final class MainRepositoryModule {
    @org.jetbrains.annotations.NotNull
    public static final com.boostcamp.shoppingapp.di.MainRepositoryModule INSTANCE = null;
    
    private MainRepositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.hilt.android.scopes.ViewModelScoped
    @dagger.Provides
    public final com.boostcamp.shoppingapp.remote.repository.MainRepository providesMainRepository(@org.jetbrains.annotations.NotNull
    com.boostcamp.shoppingapp.remote.MainService mainService) {
        return null;
    }
}