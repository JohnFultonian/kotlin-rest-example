package com.tablesagas

import com.tablesagas.configuration.Config
import com.tablesagas.resource.Campaign

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


class App() : Application<Config>() {
  override fun initialize(bootstrap: Bootstrap<Config>) {}

  override fun run(configuration: Config, environment: Environment) {
    environment.jersey().register(Campaign())
  }
}

fun main(args: Array<String>) = when {
  args.isEmpty()  -> App().run("server")
  else            -> App().run(*args)
}
