package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.core.service

import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.model.Car
import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.ports.CarRepository
import com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.domain.ports.CarService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(
    private val carRepository: CarRepository,
): CarService {

    @Cacheable(cacheNames = ["Cars"], key = "#root.method.name")
    override fun list(model: String?): List<Car> {
        return model?.let {
            carRepository.listByModel(it)
        } ?: carRepository.listAll()
    }

    @CacheEvict(cacheNames = ["Cars"], allEntries = true)
    override fun create(car: Car) {
        car.isEligibleToUber().let { carRepository.save(it) }
    }

    @CacheEvict(cacheNames = ["Cars"], allEntries = true)
    override fun update(
        id: Long,
        car: Car
    ) {
        carRepository.update(id, car)
    }

    override fun findById(id: Long): Car {
        return carRepository.findById(id)
            ?: throw IllegalArgumentException("Car with id $id not found")
    }

    override suspend fun listByNinjaAPI(model: String): List<Car>? {
        coroutineScope {
            carHttpService
                .getByModel(model)
                .let(CarHttpToModelConverter::toModel)
        }
    }
}