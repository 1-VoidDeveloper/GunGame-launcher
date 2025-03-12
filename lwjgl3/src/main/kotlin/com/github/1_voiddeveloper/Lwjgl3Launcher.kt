@file:JvmName("Lwjgl3Launcher")

package com.github.`1_voiddeveloper`

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowAdapter
import dev.ultreon.launcher.*

/** Launches the desktop (LWJGL3) application. */
fun main() {
  // This handles macOS support and helps on Windows.
  if (StartupHelper.startNewJvmIfRequired())
    return

  NAME = "GunGame"
  NAME_ID = "GunGame"
  IDENTIFIER = "gun-game"
  ARTIFACT = "com.github.1_voiddeveloper.GunGame"
  GH_REPO = "1-VoidDeveloper/GunGame"

  LANG = Lang.Python
  SDK_VERSION = "3.13.2+20250212"

  availableChannels.add("main")
  channelPrefix = ""

  mainFile = "maingame.py"

  Lwjgl3Application(Launcher, Lwjgl3ApplicationConfiguration().apply {
    setTitle("GunGame Launcher")
    setWindowedMode(1280, 640)
    setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    setResizable(false)

    setWindowListener(object : Lwjgl3WindowAdapter() {
      override fun closeRequested(): Boolean {
        return Launcher.handleClose()
      }
    })
  })
}
