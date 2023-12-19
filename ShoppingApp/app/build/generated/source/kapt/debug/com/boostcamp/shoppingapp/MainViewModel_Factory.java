package com.boostcamp.shoppingapp;

import com.boostcamp.shoppingapp.remote.repository.MainRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<MainRepository> mainRepositoryProvider;

  public MainViewModel_Factory(Provider<MainRepository> mainRepositoryProvider) {
    this.mainRepositoryProvider = mainRepositoryProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(mainRepositoryProvider.get());
  }

  public static MainViewModel_Factory create(Provider<MainRepository> mainRepositoryProvider) {
    return new MainViewModel_Factory(mainRepositoryProvider);
  }

  public static MainViewModel newInstance(MainRepository mainRepository) {
    return new MainViewModel(mainRepository);
  }
}
