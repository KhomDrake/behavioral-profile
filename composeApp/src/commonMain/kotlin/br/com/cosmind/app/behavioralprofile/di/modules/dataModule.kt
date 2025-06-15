package br.com.cosmind.app.behavioralprofile.di.modules

import br.com.cosmind.app.behavioralprofile.data.database.BehavioralDatabase
import br.com.cosmind.app.behavioralprofile.data.repository.BehavioralTestRepositoryImpl
import br.com.cosmind.app.behavioralprofile.data.repository.ResultRepositoryImpl
import br.com.cosmind.app.behavioralprofile.data.repository.WordRepositoryImpl
import br.com.cosmind.app.behavioralprofile.domain.repository.BehavioralTestRepository
import br.com.cosmind.app.behavioralprofile.domain.repository.ResultRepository
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single {
        get<BehavioralDatabase>().behavioralTestDao()
    }
    singleOf(::BehavioralTestRepositoryImpl).bind<BehavioralTestRepository>()
    factoryOf(::WordRepositoryImpl).bind<WordRepository>()
    factoryOf(::ResultRepositoryImpl).bind<ResultRepository>()
}