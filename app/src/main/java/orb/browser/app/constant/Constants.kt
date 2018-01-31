/*
 * Copyright 2014 A.C.R. Development
 */
@file:JvmName("Constants")

package orb.browser.app.constant

// Hardcoded user agents
const val DESKTOP_USER_AGENT = "Mozilla/5.0 (Android 7.1.2; Pixel Build/NHG47L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 ⏀OrbReader/1.0.0.0 Safari/537.36"
const val MOBILE_USER_AGENT =  "Mozilla/5.0 (Android 7.1.2; Pixel Build/NHG47L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 ⏀OrbReader/1.0.0.0 Mobile Safari/537.36"
const val ORB_AGENT = " ⏀OrbReader/1.0.0.0"

// URL Schemes
const val HTTP = "http://"
const val HTTPS = "https://"
const val FILE = "file://"
const val ABOUT = "about:"
const val FOLDER = "folder://"

// Custom local page schemes
const val SCHEME_HOMEPAGE = "${ABOUT}home"
const val SCHEME_BLANK = "${ABOUT}blank"
const val SCHEME_BOOKMARKS = "${ABOUT}bookmarks"

const val LOAD_READING_URL = "ReadingUrl"

const val NO_PROXY = 0
const val PROXY_ORBOT = 1
const val PROXY_I2P = 2
const val PROXY_MANUAL = 3

const val UTF8 = "UTF-8"

// Default text encoding we will use
const val DEFAULT_ENCODING = UTF8

// Allowable text encodings for the WebView
@JvmField
val TEXT_ENCODINGS = arrayOf("ISO-8859-1", UTF8, "GBK", "Big5", "ISO-2022-JP", "SHIFT_JS", "EUC-JP", "EUC-KR")

const val INTENT_ORIGIN = "URL_INTENT_ORIGIN"
