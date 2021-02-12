package com.learning.fullapprxjava

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class FullAppRxjavaApplication

fun main(args: Array<String>) {
	runApplication<FullAppRxjavaApplication>(*args)
}
