package com.example

import java.net.{InetAddress, Socket}
import java.io._

import android.os.Build.VERSION_CODES

class ClientThread extends Thread {
  var socket: Socket=_
  var out: PrintWriter=null

  override def run(): Unit = {
    try {
      val serverAddr = InetAddress.getByName("172.16.181.110")
      socket = new Socket(serverAddr,4000)


    } catch {
      case e1: IOException =>
        e1.printStackTrace()
        socket.close()
      case e2: InterruptedException =>
        e2.printStackTrace()
        socket.close()

    }
    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream)), true)
    out.println("aaaaaaa")

  }
  def close(): Unit ={
    out.println("bbbbbbbbb")
  }
}




