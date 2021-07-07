package com.example.testmvi.viewmodel.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testmvi.data.api.ApiHelper
import com.example.testmvi.data.api.ApiHelperImpl
import com.example.testmvi.data.repository.MainRepository
import com.example.testmvi.intent.GetUserInteractor
import com.example.testmvi.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory
{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
        {
            return MainViewModel(GetUserInteractor(MainRepository(apiHelper))) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}