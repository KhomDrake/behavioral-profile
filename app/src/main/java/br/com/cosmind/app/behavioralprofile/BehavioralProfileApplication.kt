package br.com.cosmind.app.behavioralprofile

import android.app.Application
import br.com.cosmind.app.behavioralprofile.di.dataModule
import br.com.cosmind.app.behavioralprofile.di.domainModule
import br.com.cosmind.app.behavioralprofile.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BehavioralProfileApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BehavioralProfileApplication)
            modules(
                listOf(
                    presentationModule,
                    domainModule,
                    dataModule
                )
            )
        }
    }

}