package com.ricardomorarey.sporteventmadrid.retrofit.models

data class Graph(
    val id: String,
    val type: String,
    val address: AddressX,
    val audience: String,
    val description: String,
    val dtend: String,
    val dtstart: String,
    val event_location: String,
    val excluded_days: String,
    val free: Int,
    val id2: String,
    val link: String,
    val location: LocationX,
    val organization: OrganizationX,
    val price: String,
    val recurrence: RecurrenceX,
    val references: References,
    val relation: Relation,
    val time: String,
    val title: String,
    val uid: String
)