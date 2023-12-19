package com.boostcamp.shoppingapp.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

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
public final class RetrofitModule_ProvidesConverterFactoryFactory implements Factory<GsonConverterFactory> {
  @Override
  public GsonConverterFactory get() {
    return providesConverterFactory();
  }

  public static RetrofitModule_ProvidesConverterFactoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GsonConverterFactory providesConverterFactory() {
    return Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.providesConverterFactory());
  }

  private static final class InstanceHolder {
    private static final RetrofitModule_ProvidesConverterFactoryFactory INSTANCE = new RetrofitModule_ProvidesConverterFactoryFactory();
  }
}
