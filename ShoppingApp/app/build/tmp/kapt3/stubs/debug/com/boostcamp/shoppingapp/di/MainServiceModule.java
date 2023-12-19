package com.boostcamp.shoppingapp.di;

import com.boostcamp.shoppingapp.remote.MainService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/boostcamp/shoppingapp/di/MainServiceModule;", "", "()V", "providesMainService", "Lcom/boostcamp/shoppingapp/remote/MainService;", "kotlin.jvm.PlatformType", "retrofit", "Lretrofit2/Retrofit;", "app_debug"})
@dagger.Module
public final class MainServiceModule {
    @org.jetbrains.annotations.NotNull
    public static final com.boostcamp.shoppingapp.di.MainServiceModule INSTANCE = null;
    
    private MainServiceModule() {
        super();
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    public final com.boostcamp.shoppingapp.remote.MainService providesMainService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
}