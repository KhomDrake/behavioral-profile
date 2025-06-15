package br.com.cosmind.app.behavioralprofile.data.repository

import behavioral_profile.composeapp.generated.resources.Res
import behavioral_profile.composeapp.generated.resources.*
import br.com.cosmind.app.behavioralprofile.domain.model.Word
import br.com.cosmind.app.behavioralprofile.domain.model.WordPage
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository
import org.jetbrains.compose.resources.StringResource

class WordRepositoryImpl: WordRepository {

    override suspend fun getWordsPage(): List<WordPage> {
        return listOf(
            createWordPage(
                a = Res.string.page_1_a,
                b = Res.string.page_1_b,
                c = Res.string.page_1_c,
                d = Res.string.page_1_d,
            ),
            createWordPage(
                a = Res.string.page_2_a,
                b = Res.string.page_2_b,
                c = Res.string.page_2_c,
                d = Res.string.page_2_d,
            ),
            createWordPage(
                a = Res.string.page_3_a,
                b = Res.string.page_3_b,
                c = Res.string.page_3_c,
                d = Res.string.page_3_d,
            ),
            createWordPage(
                a = Res.string.page_4_a,
                b = Res.string.page_4_b,
                c = Res.string.page_4_c,
                d = Res.string.page_4_d,
            ),
            createWordPage(
                a = Res.string.page_5_a,
                b = Res.string.page_5_b,
                c = Res.string.page_5_c,
                d = Res.string.page_5_d,
            ),
            createWordPage(
                a = Res.string.page_6_a,
                b = Res.string.page_6_b,
                c = Res.string.page_6_c,
                d = Res.string.page_6_d,
            ),
            createWordPage(
                a = Res.string.page_7_a,
                b = Res.string.page_7_b,
                c = Res.string.page_7_c,
                d = Res.string.page_7_d,
            ),
            createWordPage(
                a = Res.string.page_8_a,
                b = Res.string.page_8_b,
                c = Res.string.page_8_c,
                d = Res.string.page_8_d,
            ),
            createWordPage(
                a = Res.string.page_9_a,
                b = Res.string.page_9_b,
                c = Res.string.page_9_c,
                d = Res.string.page_9_d,
            ),
            createWordPage(
                a = Res.string.page_10_a,
                b = Res.string.page_10_b,
                c = Res.string.page_10_c,
                d = Res.string.page_10_d,
            ),
            createWordPage(
                a = Res.string.page_11_a,
                b = Res.string.page_11_b,
                c = Res.string.page_11_c,
                d = Res.string.page_11_d,
            ),
            createWordPage(
                a = Res.string.page_12_a,
                b = Res.string.page_12_b,
                c = Res.string.page_12_c,
                d = Res.string.page_12_d,
            ),
            createWordPage(
                a = Res.string.page_13_a,
                b = Res.string.page_13_b,
                c = Res.string.page_13_c,
                d = Res.string.page_13_d,
            ),
            createWordPage(
                a = Res.string.page_14_a,
                b = Res.string.page_14_b,
                c = Res.string.page_14_c,
                d = Res.string.page_14_d,
            ),
            createWordPage(
                a = Res.string.page_15_a,
                b = Res.string.page_15_b,
                c = Res.string.page_15_c,
                d = Res.string.page_15_d,
            ),
            createWordPage(
                a = Res.string.page_16_a,
                b = Res.string.page_16_b,
                c = Res.string.page_16_c,
                d = Res.string.page_16_d,
            ),
            createWordPage(
                a = Res.string.page_17_a,
                b = Res.string.page_17_b,
                c = Res.string.page_17_c,
                d = Res.string.page_17_d,
            ),
            createWordPage(
                a = Res.string.page_18_a,
                b = Res.string.page_18_b,
                c = Res.string.page_18_c,
                d = Res.string.page_18_d,
            ),
            createWordPage(
                a = Res.string.page_19_a,
                b = Res.string.page_19_b,
                c = Res.string.page_19_c,
                d = Res.string.page_19_d,
            ),
            createWordPage(
                a = Res.string.page_20_a,
                b = Res.string.page_20_b,
                c = Res.string.page_20_c,
                d = Res.string.page_20_d,
            ),
            createWordPage(
                a = Res.string.page_21_a,
                b = Res.string.page_21_b,
                c = Res.string.page_21_c,
                d = Res.string.page_21_d,
            ),
            createWordPage(
                a = Res.string.page_22_a,
                b = Res.string.page_22_b,
                c = Res.string.page_22_c,
                d = Res.string.page_22_d,
            ),
            createWordPage(
                a = Res.string.page_23_a,
                b = Res.string.page_23_b,
                c = Res.string.page_23_c,
                d = Res.string.page_23_d,
            ),
            createWordPage(
                a = Res.string.page_24_a,
                b = Res.string.page_24_b,
                c = Res.string.page_24_c,
                d = Res.string.page_24_d,
            ),
            createWordPage(
                a = Res.string.page_25_a,
                b = Res.string.page_25_b,
                c = Res.string.page_25_c,
                d = Res.string.page_25_d,
            )
        )
    }

    private fun createWordPage(
        a: StringResource,
        b: StringResource,
        c: StringResource,
        d: StringResource
    ): WordPage {
        return WordPage(
            words = listOf(
                Word(
                    type = WordType.A,
                    name = a
                ),
                Word(
                    type = WordType.B,
                    name = b
                ),
                Word(
                    type = WordType.C,
                    name = c
                ),
                Word(
                    type = WordType.D,
                    name = d
                ),
            )
        )
    }

}