/*
 * Copyright 2014 A.C.R. Development
 */
package orb.browser.app.html.homepage

import orb.browser.app.BrowserApp
import orb.browser.app.constant.FILE
import orb.browser.app.search.SearchEngineProvider
import android.app.Application
import io.reactivex.Single
import java.io.File
import java.io.FileWriter
import javax.inject.Inject

class StartPage {

    @Inject internal lateinit var app: Application
    @Inject internal lateinit var searchEngineProvider: SearchEngineProvider

    init {
        BrowserApp.appComponent.inject(this)
    }

    fun createHomePage(): Single<String> = Single.fromCallable {
        val homePageBuilder = HomePageBuilder(app, searchEngineProvider)

        val homepage = getStartPageFile(app)

        FileWriter(homepage, false).use {
            it.write(homePageBuilder.buildPage())
        }

        return@fromCallable "$FILE$homepage"
    }

    companion object {

        const val FILENAME = "homepage.html"

        @JvmStatic
        fun getStartPageFile(application: Application): File = File(application.filesDir, FILENAME)
    }

}
