package orb.browser.app.search.suggestions

import orb.browser.app.R
import orb.browser.app.constant.UTF8
import orb.browser.app.database.HistoryItem
import orb.browser.app.extensions.map
import orb.browser.app.utils.FileUtils
import android.app.Application
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

/**
 * The search suggestions provider for the DuckDuckGo search engine.
 */
class DuckSuggestionsModel(application: Application) : BaseSuggestionsModel(application, UTF8) {

    private val searchSubtitle = application.getString(R.string.suggestion)

    override fun createQueryUrl(query: String, language: String): String =
            "https://duckduckgo.com/ac/?q=$query"

    @Throws(Exception::class)
    override fun parseResults(inputStream: InputStream): List<HistoryItem> {
        val content = FileUtils.readStringFromStream(inputStream, UTF8)
        val jsonArray = JSONArray(content)

        return jsonArray
                .map { it as JSONObject }
                .map { it.getString("phrase") }
                .map { HistoryItem("$searchSubtitle \"$it\"", it, R.drawable.ic_search) }
    }

}
