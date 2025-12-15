package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.ports

import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.model.Car

interface CarRepository {
    fun listAll(): List<Car>
    fun findById(id: Long): Car?
    fun listByModel(model: String): List<Car>
    fun save(car: Car)
    fun update(id: Long, car: Car)
}