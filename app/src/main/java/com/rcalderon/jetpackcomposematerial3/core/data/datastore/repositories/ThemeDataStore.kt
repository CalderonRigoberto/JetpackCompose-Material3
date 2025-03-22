package com.rcalderon.jetpackcomposematerial3.core.data.datastore.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.rcalderon.jetpackcomposematerial3.core.domain.repositories.ThemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

private const val THEME_PREFERENCES_NAME = "theme_preferences"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = THEME_PREFERENCES_NAME
)

private val IS_DARK_THEME_ENABLED = booleanPreferencesKey("is_dark_theme_enabled")

class ThemeDataStore(private val context: Context) : ThemeRepository {
    val preferencesTheme: Flow<Boolean> = context.dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[IS_DARK_THEME_ENABLED] ?: false
        }


    override suspend fun changeTheme(isDark: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_DARK_THEME_ENABLED] = isDark
        }
    }
}