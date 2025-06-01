package br.com.cosmind.app.behavioralprofile.domain.repository

import br.com.cosmind.app.behavioralprofile.domain.model.ResultModel

interface ResultRepository {

    suspend fun getAllResults(): List<ResultModel>

}