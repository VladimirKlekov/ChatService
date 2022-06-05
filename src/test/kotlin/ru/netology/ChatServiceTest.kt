package ru.netology

import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun getChats() {
    }

    @Test
    fun getUserIds() {
    }

    @Test
    fun setUserIds() {
    }

    @Test
    fun deleteMessage() {
        val testChat = Chat(1)
        val service = ChatService()
        val testMessage = Message(1, "Тестовое сообщение")
        service.addMessage(1,testMessage,testChat)
        service.deleteMessage(testMessage,testChat)


    }

    @Test
    fun readMessage() {
        val testChat = Chat(1)
        val service = ChatService()
        val testMessage = Message(1, "Тестовое сообщение")
        val test1 = service.readMessage(testChat.id, Message(1, "Тестовое сообщение", true), testChat)

        val test2 = service.readMessage(1, testMessage, testChat)

        assertEquals(test1, test2)

    }

    @Test
    fun addMessage() {
        val testChat = Chat(1)
        val testUser = User(1,1)
        val service = ChatService()
        service.addUser(testUser)
        val testMessage = Message(testUser.id, "Тестовое сообщение")
        val test1 = service.addMessage(1, testMessage,testChat)

        val test2 = service.chats.get(listOf(1))

        assertEquals(test1, test2)
    }

    @Test
    fun addChat() {
        val testChat = Chat(1)
        val testUser = User(1,1)
        val service = ChatService()
        service.addUser(testUser)

        val test1 = service.addChat(testUser.id,1,testChat.id,testChat)

        val test2 = service.chats.get(listOf(0))

        assertEquals(test1, test2)
    }

    @Test
    fun addUser() {

        val testUser = User(1,1)
        val service = ChatService()
        val test1 = service.addUser(testUser)
        val test2 = service.userIds.get(0)

        assertEquals(test1, test2)



    }

    @Test
    fun testGetChats() {
        val testUser = User(1,1)
        val service = ChatService()
        service.addUser(testUser)
        val testChat = Chat(1)
        service.addChat(testUser.id,1,testChat.id,testChat)

        val test1 = service.getChats(testChat.id)
        val test2 = service.chats.get(listOf(0))

        //assertEquals(test1, test2)
    }


}