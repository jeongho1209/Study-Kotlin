package com.kotlin.good.domain.delivery.domain.repository

import com.kotlin.good.domain.delivery.domain.Delivery
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DeliveryRepository : CrudRepository<Delivery, UUID> {
}