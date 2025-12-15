package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.adapters.http

import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.http.CarHttp
import org.springframework.stereotype.Service
import retrofit2.http.GET
import retrofit2.http.Query

@Service
fun interface CarHttpService {
    @GET("cars-inventory")
    suspend fun getByModel(@Query("model") model: String): List<CarHttp>
}