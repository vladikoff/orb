package orb.browser.app.extensions

import orb.browser.app.dialog.BrowserDialog
import android.support.v7.app.AlertDialog

/**
 * Ensures that the dialog is appropriately sized and displays it.
 */
fun AlertDialog.Builder.resizeAndShow() = BrowserDialog.setDialogSize(context, this.show())