package com.redbee.mskafkapractica.shared.other.error.providers

import com.redbee.mskafkapractica.shared.other.error.model.ApiError
import com.redbee.mskafkapractica.shared.other.error.model.ApiErrorResponse
import com.redbee.mskafkapractica.shared.other.error.model.ApplicationError
import com.redbee.mskafkapractica.shared.other.util.log.CompanionLogger
import org.springframework.stereotype.Component
import java.time.OffsetDateTime

@Component
class ErrorResponseProvider(
    private val currentResourceProvider: CurrentResourceProvider,
    private val metadataProvider: ErrorResponseMetadataProvider
) {

    fun provideFor(error: ApplicationError) =
        ApiErrorResponse(
            datetime = OffsetDateTime.now(),
            errors = listOf(
                ApiError(
                    resource = getResource(),
                    message = error.message,
                    metadata = getMetadata()
                )
            )
        ).log { debug("error response provided {}", it) }

    private fun getResource() =
        currentResourceProvider.provideUri()

    private fun getMetadata() =
        metadataProvider.provide()

    companion object : CompanionLogger()
}
