package org.yosef.cwt.network

import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface CwtApi {
    @GET( "currency2008.dat")
    suspend fun getStringResponse(): String
}