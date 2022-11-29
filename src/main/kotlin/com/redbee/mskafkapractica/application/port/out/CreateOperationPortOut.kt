package com.redbee.mskafkapractica.application.port.out

import com.redbee.mskafkapractica.domain.Operation

interface CreateOperationPortOut {
    fun execute(operation: Operation): Operation
}
