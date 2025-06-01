package br.com.cosmind.app.behavioralprofile.data.repository

import br.com.cosmind.app.behavioralprofile.data.database.BehavioralDao
import br.com.cosmind.app.behavioralprofile.data.database.entity.BehavioralTestResultEntity
import br.com.cosmind.app.behavioralprofile.domain.model.ResultModel
import br.com.cosmind.app.behavioralprofile.domain.repository.ResultRepository

class ResultRepositoryImpl(
    private val dao: BehavioralDao
): ResultRepository {

    override suspend fun getAllResults(): List<ResultModel> {
        return dao.getAllResult().map { resultEntity ->
            resultEntity.toResultModel()
        }
    }

}

fun BehavioralTestResultEntity.toResultModel(): ResultModel {
    return ResultModel(
        quantityA = this.selectedA,
        quantityB = this.selectedB,
        quantityC = this.selectedC,
        quantityD = this.selectedD,
        name = this.name,
        date = this.date,
        id = this.id
    )
}