package com.answerBot.answerBotVk.service

import com.answerBot.answerBotVk.dto.incoming.VkMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MessageService(private val vkApiService: VkApiService) {
    @Value("\${vk.bot.confirmation}")
    lateinit var confirmationCode: String

    fun handleNewMessage(message: VkMessage){
        val quotedText = "> ${message.text}/n/n${message.text}"
        vkApiService.sendMessage(message.peer_id, quotedText)
    }
}