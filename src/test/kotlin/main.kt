import ru.netology.Chat
import ru.netology.ChatService
import ru.netology.Message
import ru.netology.User


fun main() {
    //создал сервис
    val service = ChatService()
    //создал пользователей
    val testUser = User(1)
    service.addUser(testUser)
    val testUser2 = User(2)
    service.addUser(testUser2)
    println(service.userIds[0])
    println(service.userIds[1])
    println("________________________________________________________")

    //создаю чат между пользователей
    //чат с юзер1 и юзер 2
    val testChat = Chat(testUser.id)
    service.addChat(testUser.id, testUser2.id, testChat.id, testChat)
    println(service.chats)
    println("________________________________________________________")

    //Пользователь 1 создал сообщение
    val testMessage = Message(1, "Первое сообщение")
    service.addMessage(testUser.id, testMessage, testChat)
    val testMessage2 = Message(2, "Второе сообщение")
    service.addMessage(testUser2.id, testMessage2, testChat)
    val testMessage3 = Message(3, "Третье сообщение")
    service.addMessage(testUser.id, testMessage3, testChat)
    println("________________________________________________________")

    service.readMessage(testChat.id, Message(testMessage.id, testMessage.text, true), testChat)
    println("________________________________________________________")

    service.deleteMessage(Message(testMessage.id, testMessage.text, true), testChat)
    println("________________________________________________________")

    service.getChats(testChat.id)
    println("________________________________________________________")





}