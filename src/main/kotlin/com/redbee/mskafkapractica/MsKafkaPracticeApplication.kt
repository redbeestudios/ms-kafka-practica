package com.redbee.mskafkapractica

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan("com.redbee")
@SpringBootApplication(scanBasePackages = ["com.redbee"])
class MsKafkaPracticeApplication

fun main(args: Array<String>) {
    runApplication<MsKafkaPracticeApplication>(*args)
}
