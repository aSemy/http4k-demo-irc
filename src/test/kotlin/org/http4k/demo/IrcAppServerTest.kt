package org.http4k.demo

import org.http4k.client.WebsocketClient
import org.http4k.cloudnative.env.Environment
import org.http4k.core.Credentials
import org.http4k.core.Uri
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

class IrcAppServerTest : IrcContract() {
  override fun newUser() = NewUser(WebsocketClient.blocking(Uri.of("ws://localhost:8000/ws")))

  private val config = Environment.defaults(CREDENTIALS of Credentials("user", "password"))

  private val server = IrcApp(config).asServer(Jetty(8000))

  @BeforeEach
  fun before() {
    server.start()
  }

  @AfterEach
  fun after() {
    server.stop()
  }
}
