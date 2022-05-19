package org.yosef.cwt.repository

import org.yosef.cwt.data.DataOrException
import org.yosef.cwt.network.CwtApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: CwtApi) {
    private val dataOrException = DataOrException<String, Boolean, Exception>()

    suspend fun getData(): DataOrException<String, Boolean, Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getStringResponse()
        } catch (e: Exception){
            dataOrException.e = e
        }

        dataOrException.loading = false
        return dataOrException
    }
}