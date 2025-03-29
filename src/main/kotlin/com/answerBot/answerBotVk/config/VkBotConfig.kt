package com.answerBot.answerBotVk.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class VkBotConfig {
    @Value("\${vk.bot.token}")
    lateinit var botToken: String

    @Value("\${vk.bot.confirmation}")
    lateinit var confirmationCode: String

    @Value("\${vk.api.version}")
    lateinit var apiVersion: String

    @Bean
    fun restTemplate() : RestTemplate = RestTemplate()

}