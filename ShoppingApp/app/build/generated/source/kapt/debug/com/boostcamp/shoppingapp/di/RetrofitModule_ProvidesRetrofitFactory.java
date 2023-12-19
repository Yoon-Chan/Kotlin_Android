package com.boostcamp.shoppingapp.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
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
public final class RetrofitModule_ProvidesRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient.Builder> clientProvider;

  private final Provider<GsonConverterFactory> gsonConverterFactoryProvider;

  public RetrofitModule_ProvidesRetrofitFactory(Provider<OkHttpClient.Builder> clientProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider) {
    this.clientProvider = clientProvider;
    this.gsonConverterFactoryProvider = gsonConverterFactoryProvider;
  }

  @Override
  public Retrofit get() {
    return providesRetrofit(clientProvider.get(), gsonConverterFactoryProvider.get());
  }

  public static RetrofitModule_ProvidesRetrofitFactory create(
      Provider<OkHttpClient.Builder> clientProvider,
      Provider<GsonConverterFactory> gsonConverterFactoryProvider) {
    return new RetrofitModule_ProvidesRetrofitFactory(clientProvider, gsonConverterFactoryProvider);
  }

  public static Retrofit providesRetrofit(OkHttpClient.Builder client,
      GsonConverterFactory gsonConverterFactory) {
    return Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.providesRetrofit(client, gsonConverterFactory));
  }
}
