package com.tablesagas.service

import com.tablesagas.model.Campaign

import javax.ws.rs.NotFoundException

val items = listOf(
        Campaign(0, "The first campaign", 12),
        Campaign(1, "The second campaign", 9),
        Campaign(2, "The third campaign", 2)
)

val default = Campaign(-1, "default", 0)

fun lookup(id: Int) = items.find { it.id == id } ?: throw NotFoundException()

fun all() = items
