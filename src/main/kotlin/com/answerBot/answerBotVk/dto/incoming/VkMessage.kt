package com.answerBot.answerBotVk.dto.incoming

data class VkMessage(
    val from_id: Long,
    val peer_id: Long,
    val text: String,
    val id: Int
)