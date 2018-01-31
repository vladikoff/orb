package orb.browser.app.search.suggestions

import orb.browser.app.R
import orb.browser.app.constant.UTF8
import orb.browser.app.database.HistoryItem
import orb.browser.app.extensions.map
import orb.browser.app.utils.FileUtils
import android.app.Application
import org.json.JSONArray
import java.io.InputStream

/**
 * The search suggestions provider for the Baidu search engine.
 */
class BaiduSuggestionsModel(
        application: Application
) : BaseSuggestionsModel(application, UTF8) {

    private val searchSubtitle = application.getString(R.string.suggestion)
    private val inputEncoding = "GBK"

    // see http://unionsug.baidu.com/su?wd=encodeURIComponent(U)
    // see http://suggestion.baidu.com/s?wd=encodeURIComponent(U)&action=opensearch
    override fun createQueryUrl(query: String, language: String): String =
            "http://suggestion.baidu.com/s?wd=$query&action=opensearch"

    @Throws(Exception::class)
    override fun parseResults(inputStream: InputStream): List<HistoryItem> {
        val content = FileUtils.readStringFromStream(inputStream, inputEncoding)
        val responseArray = JSONArray(content)
        val jsonArray = responseArray.getJSONArray(1)

        return jsonArray
                .map { it as String }
                .map { HistoryItem("$searchSubtitle \"$it\"", it, R.drawable.ic_search) }
    }

}
