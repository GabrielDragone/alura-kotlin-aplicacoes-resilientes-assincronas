package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas.core.converter

object CarHttpToModelConverter {
    fun toModel(carsHttp: List<CarHttp>) =
        carsHttp.map { carHttp ->
            Car(
                id = Long.MAX_VALUE,
                name = carHttp.model,
                model = carHttp.make,
                year = carHttp.year
            ).isEligibleToUber()
        }
}