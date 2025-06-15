package br.com.cosmind.app.behavioralprofile.di.modules

import br.com.cosmind.app.behavioralprofile.ui.features.history.HistoryViewModel
import br.com.cosmind.app.behavioralprofile.ui.features.result.ResultViewModel
import br.com.cosmind.app.behavioralprofile.ui.features.test.TestViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::TestViewModel)
    viewModelOf(::ResultViewModel)
    viewModelOf(::HistoryViewModel)
}