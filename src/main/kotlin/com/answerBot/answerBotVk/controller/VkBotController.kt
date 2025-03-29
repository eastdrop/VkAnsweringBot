package com.answerBot.answerBotVk.controller

import com.answerBot.answerBotVk.dto.incoming.VkCallback
import com.answerBot.answerBotVk.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/callback")
class VkBotController(private val messageService: MessageService) {

    @PostMapping
    fun handleCallback(@RequestBody callback: VkCallback): ResponseEntity<String> {
        return when (callback.type) {
            "confirmation" -> ResponseEntity.ok(messageService.confirmationCode)
            "message_new" -> {
                callback.`object`.message?.let { messageService.handleNewMessage(it) }
                ResponseEntity.ok("ok")
            }
            else -> ResponseEntity.ok("ok")
        }
    }

}