package br.com.cosmind.app.behavioralprofile.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.cosmind.app.behavioralprofile.data.database.entity.BehavioralTestResultEntity

@Dao
interface BehavioralDao {

    @Query("SELECT * FROM results")
    suspend fun getAllResult(): List<BehavioralTestResultEntity>

    @Insert
    suspend fun insertResult(resultEntity: BehavioralTestResultEntity)

}