package org.yosef.cwt.screns

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.yosef.cwt.data.DataOrException
import org.yosef.cwt.repository.Repository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    suspend fun getData(): DataOrException<String, Boolean, Exception>{
        return repository.getData()
    }
}