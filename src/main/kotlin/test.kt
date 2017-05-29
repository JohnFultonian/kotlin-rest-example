package com.tablesagas

import com.google.gson.Gson
import com.tablesagas.service.lookupCampaign
import org.jetbrains.ktor.application.ApplicationCall
import org.jetbrains.ktor.application.ApplicationRequest

import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.host.embeddedServer
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.netty.Netty
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.request.acceptItems
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.routing
import java.lang.Integer.parseInt

infix fun ApplicationRequest.accepts(contentType: String) =
    this.acceptItems().any { it.value.toUpperCase() == contentType.toUpperCase() }

suspend fun respond(call: ApplicationCall, model: Any) {
    when {
        call.request.accepts("application/json") -> call.respondText(Gson().toJson(model), ContentType.Application.Json)
        else -> call.respondText(model.toString(), ContentType.Text.Plain)
    }
}

fun main(args: Array<String>) {
  val server = embeddedServer(Netty, 8080) {
    routing {
      get("/campaign/{id}") {
        val id = parseInt(call.parameters["id"])
        respond(call, lookupCampaign(id))
      }
    }
  }
  server.start(wait = true)
}
