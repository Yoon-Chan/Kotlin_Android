package com.boostcamp.shoppingapp.remote.repository;

import com.boostcamp.shoppingapp.remote.MainService;
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
public final class MainRepositoryImpl_Factory implements Factory<MainRepositoryImpl> {
  private final Provider<MainService> mainServiceProvider;

  public MainRepositoryImpl_Factory(Provider<MainService> mainServiceProvider) {
    this.mainServiceProvider = mainServiceProvider;
  }

  @Override
  public MainRepositoryImpl get() {
    return newInstance(mainServiceProvider.get());
  }

  public static MainRepositoryImpl_Factory create(Provider<MainService> mainServiceProvider) {
    return new MainRepositoryImpl_Factory(mainServiceProvider);
  }

  public static MainRepositoryImpl newInstance(MainService mainService) {
    return new MainRepositoryImpl(mainService);
  }
}
