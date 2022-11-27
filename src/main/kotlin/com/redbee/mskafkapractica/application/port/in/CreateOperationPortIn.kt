package com.redbee.mskafkapractica.application.port.`in`

import com.redbee.mskafkapractica.domain.Operation

interface CreateOperationPortIn {

    fun execute(operation: Operation): Operation
}
