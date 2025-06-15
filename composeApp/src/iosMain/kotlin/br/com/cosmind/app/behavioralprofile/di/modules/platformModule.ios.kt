package br.com.cosmind.app.behavioralprofile.di.modules

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import br.com.cosmind.app.behavioralprofile.data.database.BehavioralDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual val platformModule: Module
    get() = module {
        single<BehavioralDatabase> {
            getDatabaseBuilder()
                .setDriver(BundledSQLiteDriver())
                .build()
        }

    }

fun getDatabaseBuilder(): RoomDatabase.Builder<BehavioralDatabase> {
    val dbFilePath = documentDirectory() + "/behavioral.db"
    return Room.databaseBuilder<BehavioralDatabase>(
        name = dbFilePath
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}