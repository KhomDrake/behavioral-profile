package br.com.cosmind.app.behavioralprofile.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class BehavioralTestResultEntity(
    val selectedA: Int,
    val selectedB: Int,
    val selectedC: Int,
    val selectedD: Int,
    val name: String?,
    val date: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)