package com.baladev.app

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.baladev.talentshipnews.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TalentshipApp: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@TalentshipApp)
            modules(KoinModules.appModules)
        }
    }
}