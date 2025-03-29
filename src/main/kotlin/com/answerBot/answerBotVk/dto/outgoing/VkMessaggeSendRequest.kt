package com.answerBot.answerBotVk.dto.outgoing

data class VkMessaggeSendRequest (
    val peer_id: Long,
    val message: String,
    val random_id: Int = (0..Int.MAX_VALUE).random()
)