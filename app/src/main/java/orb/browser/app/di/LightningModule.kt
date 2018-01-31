package orb.browser.app.di

import orb.browser.app.adblock.whitelist.SessionWhitelistModel
import orb.browser.app.adblock.whitelist.WhitelistModel
import orb.browser.app.database.bookmark.BookmarkDatabase
import orb.browser.app.database.bookmark.BookmarkRepository
import orb.browser.app.database.downloads.DownloadsDatabase
import orb.browser.app.database.downloads.DownloadsRepository
import orb.browser.app.database.history.HistoryDatabase
import orb.browser.app.database.history.HistoryRepository
import orb.browser.app.database.whitelist.AdBlockWhitelistDatabase
import orb.browser.app.database.whitelist.AdBlockWhitelistRepository
import orb.browser.app.ssl.SessionSslWarningPreferences
import orb.browser.app.ssl.SslWarningPreferences
import dagger.Binds
import dagger.Module

/**
 * Dependency injection module used to bind implementations to interfaces.
 */
@Module
abstract class LightningModule {

    @Binds
    abstract fun provideBookmarkModel(bookmarkDatabase: BookmarkDatabase): BookmarkRepository

    @Binds
    abstract fun provideDownloadsModel(downloadsDatabase: DownloadsDatabase): DownloadsRepository

    @Binds
    abstract fun providesHistoryModel(historyDatabase: HistoryDatabase): HistoryRepository

    @Binds
    abstract fun providesAdBlockWhitelistModel(adBlockWhitelistDatabase: AdBlockWhitelistDatabase): AdBlockWhitelistRepository

    @Binds
    abstract fun providesWhitelistModel(sessionWhitelistModel: SessionWhitelistModel): WhitelistModel

    @Binds
    abstract fun providesSslWarningPreferences(sessionSslWarningPreferences: SessionSslWarningPreferences): SslWarningPreferences

}