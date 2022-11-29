package com.redbee.mskafkapractica.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Operation(
    @Id
    val id: Int,
    val amount: String,
    val name: String
)
