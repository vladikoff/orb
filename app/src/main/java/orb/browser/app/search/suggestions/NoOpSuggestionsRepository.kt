package orb.browser.app.search.suggestions

import orb.browser.app.database.HistoryItem
import io.reactivex.Single

/**
 * A search suggestions repository that doesn't fetch any results.
 */
class NoOpSuggestionsRepository : SuggestionsRepository {

    private val emptySingle: Single<List<HistoryItem>> = Single.just(listOf())

    override fun resultsForSearch(rawQuery: String) = emptySingle
}