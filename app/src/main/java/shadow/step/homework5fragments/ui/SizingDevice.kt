package shadow.step.homework5fragments.ui

import android.content.Context
import android.content.res.Configuration

object SizingDevice {
    fun isTablet(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }
}