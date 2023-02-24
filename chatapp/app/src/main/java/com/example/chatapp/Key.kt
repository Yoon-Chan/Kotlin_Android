package com.example.chatapp

class Key {
    companion object{
        //미국은 굳이 URL을 설정 안해도 된다. 다른 지역인 경우에는 URL 참조 필수
        //Firebase.database("여기에 URL 설정")
        const val DB_URL = "https://mysampleproject-e77b8-default-rtdb.firebaseio.com/"
        const val DB_USERS = "Users"
        const val DB_CHAT_ROOMS = "ChatRooms"
        const val DB_CHATS = "Chats"
    }
}