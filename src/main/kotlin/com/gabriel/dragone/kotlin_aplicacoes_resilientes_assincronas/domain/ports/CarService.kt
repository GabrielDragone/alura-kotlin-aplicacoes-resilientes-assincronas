package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.ports

import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.model.Car

interface CarService {
    fun list(model: String?): List<Car>
    fun create(car: Car)
    fun update(id: Long, car: Car)
    fun findById(id: Long): Car
    suspend fun listByNinjaAPI(model: String): List<Car>?
}