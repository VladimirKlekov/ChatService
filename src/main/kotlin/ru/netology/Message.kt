package ru.netology

open class Message(val id: Int, val text: String, var readMessage: Boolean = false) {


    override fun toString(): String {
        return "\n$text"
    }
}