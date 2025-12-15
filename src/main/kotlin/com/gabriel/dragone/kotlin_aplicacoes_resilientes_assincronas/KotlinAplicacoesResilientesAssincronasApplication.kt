package com.gabriel.dragone.kotlin_aplicacoes_resilientes_assincronas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class KotlinAplicacoesResilientesAssincronasApplication

fun main(args: Array<String>) {
	runApplication<KotlinAplicacoesResilientesAssincronasApplication>(*args)
}
