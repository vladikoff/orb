package orb.browser.app.browser

import orb.browser.app.database.HistoryItem

interface BookmarksView {

    fun navigateBack()

    fun handleUpdatedUrl(url: String)

    fun handleBookmarkDeleted(item: HistoryItem)

}
