package com.sidpatchy.javasnipe.Bean.Generic

/**
 * The Date class represents a date object in the Snipe-API.
 *
 * todo this should probably be written such that the user inserts something like a Unix timestamp or similar and then
 *      converts to the formatting expected by Snipe-IT.
 */
data class Date (
    var date: String,
    var formatted: String
)