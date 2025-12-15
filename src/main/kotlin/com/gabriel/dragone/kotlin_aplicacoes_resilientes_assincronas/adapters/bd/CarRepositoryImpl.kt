package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.adapters.bd

import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.model.Car
import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.ports.CarRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CarRepositoryImpl(
    private val jdbcTemplate: JdbcTemplate
): CarRepository {

    override fun listAll(): List<Car> {
        return jdbcTemplate.query("SELECT * FROM car", CarMapper())
    }

    override fun findById(id: Long): Car? {
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id = ?", CarMapper(), id)
    }

    override fun listByModel(model: String): List<Car> {
        return jdbcTemplate.query("SELECT * FROM car WHERE model = ?", CarMapper(), model)
    }

    override fun save(car: Car) {
        jdbcTemplate.update(
            "INSERT INTO car(name, model, year_car, is_eligible) VALUES(?,?,?,?)",
            car.name,
            car.model,
            car.year,
            car.isEligible
        )
    }

    override fun update(
        id: Long,
        car: Car
    ) {
        jdbcTemplate.update(
            "UPDATE car SET name = ?, model = ?, year_car = ? WHERE id = ?",
            car.name,
            car.model,
            car.year,
            id
        )
    }
}