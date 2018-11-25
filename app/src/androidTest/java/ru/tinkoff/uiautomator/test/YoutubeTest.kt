package ru.tinkoff.uiautomator.test

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.uiautomator.application.YouTube
import ru.tinkoff.uiautomator.util.getDevice

@RunWith(AndroidJUnit4::class)
class YoutubeTest : AbstractApplicationTest<YouTube>(YouTube()) {

    @Test
    fun pauseVideoYoutube() {
        app.open()
        app.clickSearch()
        app.typeToSearch("топчик из чернобыля смешные коты")
        getDevice().pressEnter()
        app.click("Смешные коты!!!! Ржака!!!!")
        app.skipAd()
        app.waitTime(10)
        app.clickPlayButton(true)
    }
}