package br.com.cosmind.app.behavioralprofile.domain.model


data class ResultModel(
    val id: Long,
    val quantityA: Int,
    val quantityB: Int,
    val quantityC: Int,
    val quantityD: Int,
    val date: String,
    val name: String? = null
) {
    val total: Int
        get() = quantityA + quantityB + quantityC + quantityD

    val missed: Int
        get() = 25 - total

}