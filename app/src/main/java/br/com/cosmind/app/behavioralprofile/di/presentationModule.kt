package br.com.cosmind.app.behavioralprofile.di

import br.com.cosmind.app.behavioralprofile.ui.features.history.HistoryViewModel
import br.com.cosmind.app.behavioralprofile.ui.features.result.ResultViewModel
import br.com.cosmind.app.behavioralprofile.ui.features.test.TestViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::TestViewModel)
    viewModelOf(::ResultViewModel)
    viewModelOf(::HistoryViewModel)
}