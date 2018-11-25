package ru.tinkoff.uiautomator.application

import android.util.Log
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import ru.tinkoff.uiautomator.util.*
import java.util.concurrent.TimeUnit


private const val ICON_SEARCH_DESC = "Search"
private const val INPUT_SEARCH_ID = "com.google.android.youtube:id/search_edit_text"
private const val RESULT_TITLE_ID = "com.google.android.youtube:id/title"
private const val TIME_BAR_ID = "com.google.android.youtube:id/time_bar_current_time"
private const val PLAY_BUTTON_ID = "com.google.android.youtube:id/player_control_play_pause_replay_button"
private const val PLAYER_ID = "com.google.android.youtube:id/player_overlays"
private const val SKIP_AD_ID = "com.google.android.youtube:id/skip_ad_button"

class YouTube : AbstractApplication("com.google.android.youtube") {

    fun clickSearch() {
        byContentDesc(ICON_SEARCH_DESC).waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        byStringRes(INPUT_SEARCH_ID).waitFindObject().text = text
    }

    fun click(text: String) {
        byStringRes(RESULT_TITLE_ID)
            .text(text)
            .waitFindObject()
            .click()
    }

    fun waitTime(seconds: Long) {
//        val text: String =
//            TimeUnit.SECONDS.toMinutes(seconds).toString() + ":" + TimeUnit.SECONDS.toSeconds(seconds).toString()
//        byStringRes(TIME_BAR_ID)
//            .text(text)
//            .waitFindObject(seconds + ((seconds * 5) / 10))
//        clickPlayButton(false)
        TimeUnit.SECONDS.sleep(10)
    }

    fun clickPlayButton(isPlay: Boolean) {
//        val currState: String = byStringRes(PLAY_BUTTON_ID).waitFindObject().contentDescription
//        if (isPlay && currState.contentEquals("Play video")) {
//            byStringRes(PLAY_BUTTON_ID).waitFindObject().click()
//        }
//        if (!isPlay && currState.contentEquals("Pause video")) {
//            byStringRes(PLAY_BUTTON_ID).waitFindObject().click()
//        }
        byStringRes("com.google.android.youtube:id/fast_forward_rewind_triangles").waitFindObject().click()
        byStringRes(PLAY_BUTTON_ID).waitFindObject().click()
    }

    fun skipAd() {
        if(getDevice().findObjects(byStringRes(SKIP_AD_ID)).size > 0) {
            byStringRes(SKIP_AD_ID).waitFindObject().wait(Until.clickable(true), TimeUnit.SECONDS.toMillis(60))
            byStringRes(SKIP_AD_ID).waitFindObject().click()
        }

    }

    fun clickText(text: String) {
        byStringText(text).waitFindObject().click()
    }


}