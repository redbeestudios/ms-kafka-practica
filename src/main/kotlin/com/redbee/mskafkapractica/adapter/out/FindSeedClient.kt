package com.redbee.mskafkapractica.adapter.out

import com.redbee.mskafkapractica.application.port.out.FindSeedPortOut
import com.redbee.mskafkapractica.shared.other.util.log.CompanionLogger
import org.springframework.stereotype.Component

@Component
class FindSeedClient : FindSeedPortOut {

    companion object : CompanionLogger()
}
