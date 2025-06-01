package br.com.cosmind.app.behavioralprofile.di

import br.com.cosmind.app.behavioralprofile.data.WordRepositoryImpl
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::WordRepositoryImpl).bind<WordRepository>()
}