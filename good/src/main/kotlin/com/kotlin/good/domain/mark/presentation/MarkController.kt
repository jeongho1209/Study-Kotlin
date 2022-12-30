package com.kotlin.good.domain.mark.presentation

import com.kotlin.good.domain.mark.presentation.dto.response.AddMarkingResponse
import com.kotlin.good.domain.mark.service.AddMarkingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/mark")
@RestController
class MarkController(
    private val addMarkingService: AddMarkingService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{item-id}")
    fun addMark(@PathVariable("item-id") itemId: UUID): AddMarkingResponse {
        return addMarkingService.execute(itemId)
    }

}