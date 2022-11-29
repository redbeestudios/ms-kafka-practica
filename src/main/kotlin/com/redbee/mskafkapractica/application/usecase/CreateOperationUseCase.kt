package com.redbee.mskafkapractica.application.usecase

import com.redbee.mskafkapractica.application.port.`in`.CreateOperationPortIn
import com.redbee.mskafkapractica.application.port.out.CreateOperationPortOut
import com.redbee.mskafkapractica.domain.Operation
import com.redbee.mskafkapractica.shared.log.CompanionLogger
import org.springframework.stereotype.Component

@Component
class CreateOperationUseCase(
    private val operationRepository: CreateOperationPortOut
) : CreateOperationPortIn {

    override fun execute(operation: Operation) =
        operationRepository.execute(operation)
            .log { info("Operation created") }

    companion object : CompanionLogger()
}
