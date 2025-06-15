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
    val highest: WordType
        get() = listOf(
            Pair(quantityA, WordType.A),
            Pair(quantityB, WordType.B),
            Pair(quantityC, WordType.C),
            Pair(quantityD, WordType.D),
        )
            .maxBy { it.first }.second

    val total: Int
        get() = quantityA + quantityB + quantityC + quantityD

    val missed: Int
        get() = 25 - total

}