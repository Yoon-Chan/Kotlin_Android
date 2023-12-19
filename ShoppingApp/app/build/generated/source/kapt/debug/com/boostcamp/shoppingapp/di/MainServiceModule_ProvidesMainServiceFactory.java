package com.boostcamp.shoppingapp.di;

import com.boostcamp.shoppingapp.remote.MainService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MainServiceModule_ProvidesMainServiceFactory implements Factory<MainService> {
  private final Provider<Retrofit> retrofitProvider;

  public MainServiceModule_ProvidesMainServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MainService get() {
    return providesMainService(retrofitProvider.get());
  }

  public static MainServiceModule_ProvidesMainServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new MainServiceModule_ProvidesMainServiceFactory(retrofitProvider);
  }

  public static MainService providesMainService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(MainServiceModule.INSTANCE.providesMainService(retrofit));
  }
}
