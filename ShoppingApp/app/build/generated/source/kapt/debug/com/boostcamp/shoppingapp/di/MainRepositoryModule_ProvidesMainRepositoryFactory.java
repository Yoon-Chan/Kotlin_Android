package com.boostcamp.shoppingapp.di;

import com.boostcamp.shoppingapp.remote.MainService;
import com.boostcamp.shoppingapp.remote.repository.MainRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("dagger.hilt.android.scopes.ViewModelScoped")
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
public final class MainRepositoryModule_ProvidesMainRepositoryFactory implements Factory<MainRepository> {
  private final Provider<MainService> mainServiceProvider;

  public MainRepositoryModule_ProvidesMainRepositoryFactory(
      Provider<MainService> mainServiceProvider) {
    this.mainServiceProvider = mainServiceProvider;
  }

  @Override
  public MainRepository get() {
    return providesMainRepository(mainServiceProvider.get());
  }

  public static MainRepositoryModule_ProvidesMainRepositoryFactory create(
      Provider<MainService> mainServiceProvider) {
    return new MainRepositoryModule_ProvidesMainRepositoryFactory(mainServiceProvider);
  }

  public static MainRepository providesMainRepository(MainService mainService) {
    return Preconditions.checkNotNullFromProvides(MainRepositoryModule.INSTANCE.providesMainRepository(mainService));
  }
}
