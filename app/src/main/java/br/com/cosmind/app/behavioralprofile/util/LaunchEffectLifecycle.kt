package br.com.cosmind.app.behavioralprofile.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun LaunchEffectLifecycleEvent(
    onClick: () -> Unit,
    lifecycleEvent: Lifecycle.Event,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if(lifecycleEvent == event) {
                onClick.invoke()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            println("DisposableEffect: onDispose - Removing observer")
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}