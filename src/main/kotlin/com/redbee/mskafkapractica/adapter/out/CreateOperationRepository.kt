package com.redbee.mskafkapractica.adapter.out

import com.redbee.mskafkapractica.application.port.out.CreateOperationPortOut
import com.redbee.mskafkapractica.domain.Operation
import com.redbee.mskafkapractica.shared.log.CompanionLogger
import org.springframework.stereotype.Component

@Component
class CreateOperationRepository(
    private val operationDbRepository: OperationDbRepository
) : CreateOperationPortOut {

    override fun execute(operation: Operation): Operation =
        operationDbRepository.save(operation)
            .log { info("Operation created") }

    companion object : CompanionLogger()
}
