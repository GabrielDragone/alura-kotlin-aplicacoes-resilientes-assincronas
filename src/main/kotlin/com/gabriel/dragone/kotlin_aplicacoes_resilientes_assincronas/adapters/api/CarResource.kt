package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.adapters.api

import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.model.Car
import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.ports.CarService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cars")
class CarResource(
    private val carService: CarService
) {

    @GetMapping
    fun list(@RequestParam(required = false) model: String?) = carService.list(model)

    @PostMapping
    fun create(@RequestBody car: Car) = carService.create(car)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody car: Car) = carService.update(id, car)
}