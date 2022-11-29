package com.redbee.mskafkapractica.adapter.out

import com.redbee.mskafkapractica.domain.Operation
import org.springframework.data.mongodb.repository.MongoRepository

interface OperationDbRepository : MongoRepository<Operation, Int>
