package orb.browser.app.di

import orb.browser.app.BrowserApp
import orb.browser.app.adblock.AssetsAdBlocker
import orb.browser.app.adblock.NoOpAdBlocker
import orb.browser.app.browser.BrowserPresenter
import orb.browser.app.browser.SearchBoxModel
import orb.browser.app.browser.TabsManager
import orb.browser.app.browser.activity.BrowserActivity
import orb.browser.app.browser.activity.ThemableBrowserActivity
import orb.browser.app.browser.fragment.BookmarksFragment
import orb.browser.app.browser.fragment.TabsFragment
import orb.browser.app.dialog.LightningDialogBuilder
import orb.browser.app.download.DownloadHandler
import orb.browser.app.download.LightningDownloadListener
import orb.browser.app.html.bookmark.BookmarkPage
import orb.browser.app.html.download.DownloadsPage
import orb.browser.app.html.history.HistoryPage
import orb.browser.app.html.homepage.StartPage
import orb.browser.app.network.NetworkConnectivityModel
import orb.browser.app.reading.activity.ReadingActivity
import orb.browser.app.search.SearchEngineProvider
import orb.browser.app.search.SuggestionsAdapter
import orb.browser.app.settings.activity.ThemableSettingsActivity
import orb.browser.app.settings.fragment.*
import orb.browser.app.utils.ProxyUtils
import orb.browser.app.view.LightningChromeClient
import orb.browser.app.view.LightningView
import orb.browser.app.view.LightningWebClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, LightningModule::class))
interface AppComponent {

    fun inject(activity: BrowserActivity)

    fun inject(fragment: BookmarksFragment)

    fun inject(fragment: BookmarkSettingsFragment)

    fun inject(builder: LightningDialogBuilder)

    fun inject(fragment: TabsFragment)

    fun inject(lightningView: LightningView)

    fun inject(activity: ThemableBrowserActivity)

    fun inject(advancedSettingsFragment: AdvancedSettingsFragment)

    fun inject(app: BrowserApp)

    fun inject(proxyUtils: ProxyUtils)

    fun inject(activity: ReadingActivity)

    fun inject(webClient: LightningWebClient)

    fun inject(activity: ThemableSettingsActivity)

    fun inject(listener: LightningDownloadListener)

    fun inject(fragment: PrivacySettingsFragment)

    fun inject(startPage: StartPage)

    fun inject(historyPage: HistoryPage)

    fun inject(bookmarkPage: BookmarkPage)

    fun inject(downloadsPage: DownloadsPage)

    fun inject(presenter: BrowserPresenter)

    fun inject(manager: TabsManager)

    fun inject(fragment: DebugSettingsFragment)

    fun inject(suggestionsAdapter: SuggestionsAdapter)

    fun inject(chromeClient: LightningChromeClient)

    fun inject(downloadHandler: DownloadHandler)

    fun inject(searchBoxModel: SearchBoxModel)

    fun inject(searchEngineProvider: SearchEngineProvider)

    fun inject(generalSettingsFragment: GeneralSettingsFragment)

    fun inject(displaySettingsFragment: DisplaySettingsFragment)

    fun inject(networkConnectivityModel: NetworkConnectivityModel)

    fun provideAssetsAdBlocker(): AssetsAdBlocker

    fun provideNoOpAdBlocker(): NoOpAdBlocker

}
