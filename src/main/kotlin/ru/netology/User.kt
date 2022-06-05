package ru.netology


open class User(var id: Int, var groupId: Int = 0) {
    override fun toString(): String {
        return "Пользователь с именем $id создан"
    }
}