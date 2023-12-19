package com.boostcamp.shoppingapp.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

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
public final class RetrofitModule_ProvidesOkHttpClientFactory implements Factory<OkHttpClient.Builder> {
  @Override
  public OkHttpClient.Builder get() {
    return providesOkHttpClient();
  }

  public static RetrofitModule_ProvidesOkHttpClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OkHttpClient.Builder providesOkHttpClient() {
    return Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.providesOkHttpClient());
  }

  private static final class InstanceHolder {
    private static final RetrofitModule_ProvidesOkHttpClientFactory INSTANCE = new RetrofitModule_ProvidesOkHttpClientFactory();
  }
}
