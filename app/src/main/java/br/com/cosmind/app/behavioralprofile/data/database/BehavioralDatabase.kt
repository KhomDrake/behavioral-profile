package br.com.cosmind.app.behavioralprofile.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.cosmind.app.behavioralprofile.data.database.entity.BehavioralTestResultEntity

@Database(
    entities = [
        BehavioralTestResultEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class BehavioralDatabase: RoomDatabase() {

    abstract fun behavioralTestDao(): BehavioralDao

}