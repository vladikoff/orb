package orb.browser.app.search.suggestions

import orb.browser.app.R
import orb.browser.app.constant.UTF8
import orb.browser.app.database.HistoryItem
import android.app.Application
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

/**
 * Search suggestions provider for Google search engine.
 */
class GoogleSuggestionsModel(application: Application) : BaseSuggestionsModel(application, UTF8) {

    private val searchSubtitle = application.getString(R.string.suggestion)

    override fun createQueryUrl(query: String, language: String): String =
            "https://suggestqueries.google.com/complete/search?output=toolbar&hl=$language&q=$query"

    @Throws(Exception::class)
    override fun parseResults(inputStream: InputStream): List<HistoryItem> {
        parser.setInput(inputStream, UTF8)

        val mutableList = mutableListOf<HistoryItem>()
        var eventType = parser.eventType
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && "suggestion" == parser.name) {
                val suggestion = parser.getAttributeValue(null, "data")
                mutableList.add(HistoryItem("$searchSubtitle \"$suggestion\"", suggestion, R.drawable.ic_search))
            }
            eventType = parser.next()
        }

        return mutableList
    }

    companion object {

        private val parser by lazy {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true

            factory.newPullParser()
        }

    }
}
