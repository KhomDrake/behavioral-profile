package br.com.cosmind.app.behavioralprofile.di.modules

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import br.com.cosmind.app.behavioralprofile.data.database.BehavioralDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<BehavioralDatabase> {
            val appContext = androidApplication()
            val dbFile = appContext.getDatabasePath("behavioral.db")
            Room.databaseBuilder<BehavioralDatabase>(
                context = appContext,
                name = dbFile.absolutePath
            )
                .setDriver(BundledSQLiteDriver())
                .build()
        }
    }