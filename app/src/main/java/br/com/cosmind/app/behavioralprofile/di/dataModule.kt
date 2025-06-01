package br.com.cosmind.app.behavioralprofile.di

import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.cosmind.app.behavioralprofile.data.database.BehavioralDatabase
import br.com.cosmind.app.behavioralprofile.data.repository.BehavioralTestRepositoryImpl
import br.com.cosmind.app.behavioralprofile.data.repository.ResultRepositoryImpl
import br.com.cosmind.app.behavioralprofile.data.repository.WordRepositoryImpl
import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository
import br.com.cosmind.app.behavioralprofile.domain.repository.ResultRepository
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            BehavioralDatabase::class.java,
            "behavioral_database"
        )
            .fallbackToDestructiveMigration(true)
            .build()
    }
    single {
        get<BehavioralDatabase>().behavioralTestDao()
    }
    singleOf(::BehavioralTestRepositoryImpl).bind<BehavioralTestRepository>()
    factoryOf(::WordRepositoryImpl).bind<WordRepository>()
    factoryOf(::ResultRepositoryImpl).bind<ResultRepository>()
}