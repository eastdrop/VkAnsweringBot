package com.answerBot.answerBotVk.service

import com.answerBot.answerBotVk.dto.outgoing.VkMessaggeSendRequest
import com.answerBot.answerBotVk.exceprionHandler.VkApiException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class VkApiService(private val restTemplate: RestTemplate) {

    @Value("\${vk.bot.token}")
    private lateinit var botToken: String

    @Value("\${vk.api.version}")
    private lateinit var apiVersion: String

    private val vkApiUrl = "https://api.vk.com/method"
    private val objectMapper = ObjectMapper().registerModule(kotlinModule())

    fun sendMessage(peerId: Long, text: String) {
        val request = VkMessaggeSendRequest(peerId, text)
        val url = "$vkApiUrl/messages.send?access_token=$botToken&v=$apiVersion"

        try {
            val response = restTemplate.postForObject(
                url,
                objectMapper.writeValueAsString(request),
                String::class.java
            )
            if (response?.contains("error") == true) {
                throw VkApiException("VK API ERROR: $response")
            }
        } catch (e: Exception) {
            throw VkApiException(
                "ERROR SENDING MESSAGE: ${
                    e.message
                }"
            )
        }
    }
}