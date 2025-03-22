package com.rcalderon.jetpackcomposematerial3.core.domain.repositories

import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    suspend fun changeTheme(isDark: Boolean)
}