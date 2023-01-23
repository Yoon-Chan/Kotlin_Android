package com.example.app3

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    Thread {
        //내 IP : 8080 포트
        val port = 8080
        val server = ServerSocket(port)


        while (true) {
            //accept() 을 하기 전까지는 서버는 계속 작동 중(대기중)
            val socket = server.accept()

            //데이터 주고받기 위해서는 stream을 사용한다.


//        socket.getInputStream() // 클라이언트로부터 들어오는 스트림 == 클라이언트의 socket.outputStream
//        socket.getOutputStream()    // 클라이언트에게 데이터를 주는 스트림 == socket.inputStream
//
            val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            val printer = PrintWriter(socket.getOutputStream())


            var input: String? = "-1"


            while (input != null && input != "") {
                input = reader.readLine()
            }


            println("READ DATA $input")

            printer.println("HTTP/1.1 200 OK")
            printer.println("Content-Type: text/html\r\n")

            //BODY
            printer.println("{\"message\" : \"Hello World\"}")
            printer.println("\r\n")
            printer.flush()
            printer.close()


            reader.close()

            socket.close()


        }


    }.start()

}