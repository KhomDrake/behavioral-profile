package br.com.cosmind.app.behavioralprofile.di.modules

import br.com.cosmind.app.behavioralprofile.domain.usecase.FinishTestUseCase
import br.com.cosmind.app.behavioralprofile.domain.usecase.GetNextPageUseCase
import br.com.cosmind.app.behavioralprofile.domain.usecase.GetResultHistoryUseCase
import br.com.cosmind.app.behavioralprofile.domain.usecase.SelectWordUseCase
import br.com.cosmind.app.behavioralprofile.domain.usecase.StartTestUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::FinishTestUseCase)
    factoryOf(::StartTestUseCase)
    factoryOf(::SelectWordUseCase)
    factoryOf(::GetNextPageUseCase)
    factoryOf(::GetResultHistoryUseCase)
}