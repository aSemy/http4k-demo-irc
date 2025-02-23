package org.http4k.demo

import org.http4k.cloudnative.env.Environment
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun main(args: Array<String>) {
  val port = if (args.isNotEmpty()) args[0].toInt() else 5000
  IrcApp(Environment.ENV).asServer(Jetty(port)).start().block()
}
