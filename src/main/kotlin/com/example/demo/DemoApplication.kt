package com.example.demo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
