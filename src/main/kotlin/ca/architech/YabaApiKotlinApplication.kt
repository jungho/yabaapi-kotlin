package ca.architech

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties
class YabaApiKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(YabaApiKotlinApplication::class.java, *args)
}


