package com.axiagroups.jettrivia.di

import com.axiagroups.jettrivia.data.remote.MyApi
import com.axiagroups.jettrivia.data.remote.QuestionsApi
import com.axiagroups.jettrivia.data.repository.MyRepositoryImpl
import com.axiagroups.jettrivia.data.repository.QuestionRepository
import com.axiagroups.jettrivia.di.diUtil.Constants
import com.axiagroups.jettrivia.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Ahsan Habib on 5/19/2024.
 * shehanuk.ahsan@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://hacker-news.firebaseio.com/v0/")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi) : MyRepository {
        return MyRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideQuestionRepository(api: QuestionsApi) =
            QuestionRepository(api)

    @Provides
    @Singleton
    fun provideQuestionApi(): QuestionsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionsApi::class.java)
    }
}