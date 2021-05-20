package com.ricardomorarey.sporteventmadrid.retrofit.models

data class SportActicitiesResponseItem(
    val address: Address,
    val description: String,
    val dtend: String,
    val dtstart: String,
    val event_location: String,
    val excluded_days: String,
    val id: String,
    val link: String,
    val location: Location,
    val organization: Organization,
    val price: Int,
    val recurrence: Recurrence,
    val references: String,
    val relation: String,
    val title: String,
    val uid: String
)