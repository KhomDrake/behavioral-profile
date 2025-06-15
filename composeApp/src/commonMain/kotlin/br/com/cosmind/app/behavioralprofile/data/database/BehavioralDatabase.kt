package br.com.cosmind.app.behavioralprofile.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import br.com.cosmind.app.behavioralprofile.data.database.entity.BehavioralTestResultEntity

@Database(
    entities = [
        BehavioralTestResultEntity::class
    ],
    version = 1,
    exportSchema = true
)
@ConstructedBy(BehavioralDatabaseConstructor::class)
abstract class BehavioralDatabase: RoomDatabase() {

    abstract fun behavioralTestDao(): BehavioralDao

}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BehavioralDatabaseConstructor : RoomDatabaseConstructor<BehavioralDatabase> {
    override fun initialize(): BehavioralDatabase
}