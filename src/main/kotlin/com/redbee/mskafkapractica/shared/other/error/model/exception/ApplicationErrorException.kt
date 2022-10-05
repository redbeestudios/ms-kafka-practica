package com.redbee.mskafkapractica.shared.other.error.model.exception

import com.redbee.mskafkapractica.shared.other.error.model.ApplicationError

class ApplicationErrorException(
    val error: ApplicationError
) : RuntimeException()
