package com.answerBot.answerBotVk.dto.incoming

data class VkCallback (
    val type: String,
    val `object`: VkObject,
    val group_id: Long
)