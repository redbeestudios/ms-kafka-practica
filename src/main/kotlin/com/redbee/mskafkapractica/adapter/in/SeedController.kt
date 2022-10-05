package com.redbee.mskafkapractica.adapter.`in`

import com.redbee.mskafkapractica.application.port.`in`.FindSeedPortIn
import com.redbee.mskafkapractica.shared.other.util.log.CompanionLogger
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seeds")
class SeedController(
    private val findSeed: FindSeedPortIn
) {

    companion object : CompanionLogger()
}
