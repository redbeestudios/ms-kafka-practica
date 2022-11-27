package com.redbee.mskafkapractica.adapter.out

import com.redbee.mskafkapractica.application.port.out.CreateOperationPortOut
import com.redbee.mskafkapractica.shared.log.CompanionLogger
import org.springframework.stereotype.Component

@Component
class CreateOperationClient : CreateOperationPortOut {

    companion object : CompanionLogger()
}
