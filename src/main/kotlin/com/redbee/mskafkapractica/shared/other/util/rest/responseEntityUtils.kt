package com.redbee.mskafkapractica.shared.other.util.rest

import arrow.core.Either
import com.redbee.mskafkapractica.shared.other.error.model.ApplicationError
import com.redbee.mskafkapractica.shared.other.error.model.exception.ApplicationErrorException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun <T> Pair<T, HttpStatus>.asResponseEntity() =
    ResponseEntity(
        first, second
    )

fun <R> Either<ApplicationError, R>.throwIfLeft(): R =
    fold(
        ifLeft = { throw ApplicationErrorException(it) },
        ifRight = { it }
    )
