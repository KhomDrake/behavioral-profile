package br.com.cosmind.app.behavioralprofile.di

import br.com.cosmind.app.behavioralprofile.di.modules.dataModule
import br.com.cosmind.app.behavioralprofile.di.modules.domainModule
import br.com.cosmind.app.behavioralprofile.di.modules.platformModule
import br.com.cosmind.app.behavioralprofile.di.modules.uiModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(platformModule, dataModule, domainModule, uiModule)
    }
}