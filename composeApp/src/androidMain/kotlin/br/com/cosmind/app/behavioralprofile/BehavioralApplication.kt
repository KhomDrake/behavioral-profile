package br.com.cosmind.app.behavioralprofile

import android.app.Application
import br.com.cosmind.app.behavioralprofile.di.initKoin
import org.koin.android.ext.koin.androidContext

class BehavioralApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BehavioralApplication)
        }
    }

}