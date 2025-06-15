package br.com.cosmind.app.behavioralprofile

import androidx.compose.ui.window.ComposeUIViewController
import br.com.cosmind.app.behavioralprofile.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}