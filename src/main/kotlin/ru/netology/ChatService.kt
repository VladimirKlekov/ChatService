package ru.netology


class ChatService() {
    //Создал список для хранения id пользователей и их сообщений
    val chats = HashMap<List<Int>, Chat>()
    var userIds = mutableListOf<User>()


    fun deleteMessage(message: Message, chat: Chat): Chat {

        return chats.getOrPut(listOf(chat.id)) { Chat(chat.id) }.apply { messages.removeAll(mutableListOf(message)) }

    }

    fun readMessage(chatId: Int, message: Message, chat: Chat): Chat {
        println("сообщение $chatId прочитано $message")
        return chats.getOrPut(listOf(chat.id)) { Chat(chat.id) }.apply { messages.add(message) }

    }


    fun addMessage(userId: Int, message: Message, chat: Chat): Chat {
        if (userIds[userId - 1].groupId == chat.id) {
            val mes = chats.getOrPut(listOf(chat.id)) { Chat(chat.id) }.apply { messages.add(message) }
            println("Пользователь $userId создал сообщение $message")
            return mes
        }
        return chat
    }


    fun addChat(userId: Int, answerId: Int, chatId: Int, chat: Chat): Chat? {
        userIds[userId - 1].groupId = chat.id
        userIds[answerId - 1].groupId = chat.id
        return chats.put(listOf(chatId), chat)
        //return chats.filter { entry -> entry.key(userId),  }.values.toList()
    }

    fun addUser(user: User): User {
        userIds.add(user)
        return userIds.last()
    }


//    //Получить список чатов
    fun getChats(chatId: Int): List<Chat> {
        // entry- это интерфейс, который хранит ключи и значение коллекции (MapEntry - это элемент коллекции)
        return chats.filter { entry -> entry.key.contains(chatId) }.values.toList()
        //вернуть список по фильтру, если ключ в entry содержит userId}.получаем значение преобразованное в список
    }

//    //функция
//    fun getChat(userId: Int, chatId: Int): Chat? {
//        //вернуть чат по userID, в нем найти id=chatId
//        return getChats(userId).find { it.id == chatId }
//    }


    //функция добавления сообщения в чат
//    fun addMessage(userIds: List<Int>, message: Message): Chat {
////        //3 Вариант
////        //верни список чатов chats по значению userIds сохрани Chat с  id 1 и с ссобщением
////        //apply - эплайн заставляет выполнить код, иначе будут несоотвествие типов и возвращает значение
////        //println(message.text)
//        return chats.getOrPut(userIds) { Chat(1) }.apply { messages.add(message) }

//        //2вариант
//        //в список chats по значению userIds добавь Chat с  id 1
//        chats.getOrPut(userIds){Chat(1, mutableListOf(message))}


    //1 Вариант
//        //если лист по userIds = null
//        if(chats[userIds] == null){
////тогда в лист chats по userId в сообщение добавляем сообщение
//            chats[userIds]?.messages?.add(message)
//        }else{
//            //иначе в список чатов сохраняем новый экземпляр класса Chat с сообщением
//            chats[userIds] = Chat(1, mutableListOf(message))
//        }
//        return chats[userIds] ?: Chat(-1) //либо можно сделать явное приведение типов return chats[userIds]!!
//    }


}


