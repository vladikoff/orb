/*
 * Copyright 2018 Orb Development
 */
package orb.browser.app.crawl

interface CrawlingCallback {
    fun onPageCrawlingComplete();

    fun onPageCrawlingFailed(url: String, errorCode: Int);

    fun onCrawlingCompleted();
}