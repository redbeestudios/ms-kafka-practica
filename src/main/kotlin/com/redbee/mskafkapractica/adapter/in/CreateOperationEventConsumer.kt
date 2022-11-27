package com.redbee.mskafkapractica.adapter.`in`

import com.redbee.mskafkapractica.application.port.`in`.CreateOperationPortIn
import com.redbee.mskafkapractica.domain.Operation
import com.redbee.mskafkapractica.shared.kafka.ConsumerMessageResolver
import com.redbee.mskafkapractica.shared.kafka.KafkaMessageConsumer
import com.redbee.mskafkapractica.shared.log.CompanionLogger
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.RetryableTopic
import org.springframework.kafka.support.Acknowledgment
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.retry.annotation.Backoff
import org.springframework.stereotype.Component

@Component
class CreateOperationEventConsumer(
    private val createOperation: CreateOperationPortIn,
    consumerMessageResolver: ConsumerMessageResolver
) : KafkaMessageConsumer(consumerMessageResolver) {

    @KafkaListener(
        topics = ["created.operation"],
        groupId = "persist"
    )
    @RetryableTopic(
        attempts = "3", backoff = Backoff(delay = 3000, multiplier = 2.0),
        retryTopicSuffix = ".persist-retry", dltTopicSuffix = ".persist-dlt"
    )
    fun consume(@Payload message: String, @Header(KafkaHeaders.RECEIVED_TOPIC) topic: String, ack: Acknowledgment) =
        generateConsumerMessage<Operation>(message, topic)
            .consume(ack) {
                it.message
                    .save()
                    .log { info("Operation event processed") }
            }

    private fun Operation.save() = createOperation.execute(this)

    companion object : CompanionLogger()
}
