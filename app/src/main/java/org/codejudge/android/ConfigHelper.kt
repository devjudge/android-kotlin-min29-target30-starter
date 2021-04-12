package org.codejudge.android

import android.content.Context
import android.content.res.Resources.NotFoundException
import android.util.Log
import java.io.IOException
import java.util.*

object ConfigHelper {
    private const val TAG = "ConfigHelper"
    fun getConfigValue(context: Context, name: String?): String? {
        val resources = context.resources
        try {
            val rawResource = resources.openRawResource(R.raw.config)
            val properties = Properties()
            properties.load(rawResource)
            Log.e(TAG, properties.getProperty(name))
            return properties.getProperty(name)
        } catch (e: NotFoundException) {
            Log.e(TAG, "Unable to find the config file: " + e.message)
        } catch (e: IOException) {
            Log.e(TAG, "Failed to open config file.")
        }
        return null
    }
}