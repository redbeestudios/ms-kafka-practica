package com.redbee.mskafkapractica.application.usecase

import com.redbee.mskafkapractica.application.port.`in`.CreateOperationPortIn
import com.redbee.mskafkapractica.application.port.out.CreateOperationPortOut
import com.redbee.mskafkapractica.domain.Operation
import com.redbee.mskafkapractica.shared.log.CompanionLogger
import org.springframework.stereotype.Component

@Component
class CreateOperationUseCase(
    private val createOperationPortOut: CreateOperationPortOut
) : CreateOperationPortIn {

    override fun execute(operation: Operation): Operation {
        TODO("Not yet implemented")
    }

    companion object : CompanionLogger()
}
