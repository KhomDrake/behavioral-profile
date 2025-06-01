package br.com.cosmind.app.behavioralprofile.data.repository

import androidx.annotation.StringRes
import br.com.cosmind.app.behavioralprofile.R
import br.com.cosmind.app.behavioralprofile.domain.model.Word
import br.com.cosmind.app.behavioralprofile.domain.model.WordPage
import br.com.cosmind.app.behavioralprofile.domain.model.WordType
import br.com.cosmind.app.behavioralprofile.domain.repository.WordRepository

class WordRepositoryImpl: WordRepository {

    override suspend fun getWordsPage(): List<WordPage> {
        return listOf(
            createWordPage(
                a = R.string.page_1_a,
                b = R.string.page_1_b,
                c = R.string.page_1_c,
                d = R.string.page_1_d,
            ),
            createWordPage(
                a = R.string.page_2_a,
                b = R.string.page_2_b,
                c = R.string.page_2_c,
                d = R.string.page_2_d,
            ),
            createWordPage(
                a = R.string.page_3_a,
                b = R.string.page_3_b,
                c = R.string.page_3_c,
                d = R.string.page_3_d,
            ),
            createWordPage(
                a = R.string.page_4_a,
                b = R.string.page_4_b,
                c = R.string.page_4_c,
                d = R.string.page_4_d,
            ),
            createWordPage(
                a = R.string.page_5_a,
                b = R.string.page_5_b,
                c = R.string.page_5_c,
                d = R.string.page_5_d,
            ),
            createWordPage(
                a = R.string.page_6_a,
                b = R.string.page_6_b,
                c = R.string.page_6_c,
                d = R.string.page_6_d,
            ),
            createWordPage(
                a = R.string.page_7_a,
                b = R.string.page_7_b,
                c = R.string.page_7_c,
                d = R.string.page_7_d,
            ),
            createWordPage(
                a = R.string.page_8_a,
                b = R.string.page_8_b,
                c = R.string.page_8_c,
                d = R.string.page_8_d,
            ),
            createWordPage(
                a = R.string.page_9_a,
                b = R.string.page_9_b,
                c = R.string.page_9_c,
                d = R.string.page_9_d,
            ),
            createWordPage(
                a = R.string.page_10_a,
                b = R.string.page_10_b,
                c = R.string.page_10_c,
                d = R.string.page_10_d,
            ),
            createWordPage(
                a = R.string.page_11_a,
                b = R.string.page_11_b,
                c = R.string.page_11_c,
                d = R.string.page_11_d,
            ),
            createWordPage(
                a = R.string.page_12_a,
                b = R.string.page_12_b,
                c = R.string.page_12_c,
                d = R.string.page_12_d,
            ),
            createWordPage(
                a = R.string.page_13_a,
                b = R.string.page_13_b,
                c = R.string.page_13_c,
                d = R.string.page_13_d,
            ),
            createWordPage(
                a = R.string.page_14_a,
                b = R.string.page_14_b,
                c = R.string.page_14_c,
                d = R.string.page_14_d,
            ),
            createWordPage(
                a = R.string.page_15_a,
                b = R.string.page_15_b,
                c = R.string.page_15_c,
                d = R.string.page_15_d,
            ),
            createWordPage(
                a = R.string.page_16_a,
                b = R.string.page_16_b,
                c = R.string.page_16_c,
                d = R.string.page_16_d,
            ),
            createWordPage(
                a = R.string.page_17_a,
                b = R.string.page_17_b,
                c = R.string.page_17_c,
                d = R.string.page_17_d,
            ),
            createWordPage(
                a = R.string.page_18_a,
                b = R.string.page_18_b,
                c = R.string.page_18_c,
                d = R.string.page_18_d,
            ),
            createWordPage(
                a = R.string.page_19_a,
                b = R.string.page_19_b,
                c = R.string.page_19_c,
                d = R.string.page_19_d,
            ),
            createWordPage(
                a = R.string.page_20_a,
                b = R.string.page_20_b,
                c = R.string.page_20_c,
                d = R.string.page_20_d,
            ),
            createWordPage(
                a = R.string.page_21_a,
                b = R.string.page_21_b,
                c = R.string.page_21_c,
                d = R.string.page_21_d,
            ),
            createWordPage(
                a = R.string.page_22_a,
                b = R.string.page_22_b,
                c = R.string.page_22_c,
                d = R.string.page_22_d,
            ),
            createWordPage(
                a = R.string.page_23_a,
                b = R.string.page_23_b,
                c = R.string.page_23_c,
                d = R.string.page_23_d,
            ),
            createWordPage(
                a = R.string.page_24_a,
                b = R.string.page_24_b,
                c = R.string.page_24_c,
                d = R.string.page_24_d,
            ),
            createWordPage(
                a = R.string.page_25_a,
                b = R.string.page_25_b,
                c = R.string.page_25_c,
                d = R.string.page_25_d,
            )
        )
    }

    private fun createWordPage(
        @StringRes
        a: Int,
        @StringRes
        b: Int,
        @StringRes
        c: Int,
        @StringRes
        d: Int
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