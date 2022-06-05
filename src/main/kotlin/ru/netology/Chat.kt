package ru.netology

open class Chat(val id:Int, var messages: MutableList<Message> = mutableListOf()) {

    fun getMassages(messages: MutableList<Message>){
        return
    }
    override fun toString(): String {
        return " Чат $id. Пользователь  \n$messages"
    }
}
//"Чат номер $id содержит сообщения $messages)"