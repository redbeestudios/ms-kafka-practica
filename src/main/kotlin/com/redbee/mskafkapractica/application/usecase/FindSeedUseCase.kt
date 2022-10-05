package com.redbee.mskafkapractica.application.usecase

import com.redbee.mskafkapractica.application.port.`in`.FindSeedPortIn
import com.redbee.mskafkapractica.application.port.out.FindSeedPortOut
import com.redbee.mskafkapractica.shared.other.util.log.CompanionLogger
import org.springframework.stereotype.Component

@Component
class FindSeedUseCase(
    private val findSeedPortOut: FindSeedPortOut
) : FindSeedPortIn {

    companion object : CompanionLogger()
}
