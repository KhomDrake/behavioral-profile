package br.com.cosmind.app.behavioralprofile.di

import br.com.cosmind.app.behavioralprofile.domain.usecase.GetRandomWordPagesUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomWordPagesUseCase)
}