package com.azuka.mvvmapps.data

data class Job(
    val jobName: String,
    val jobDescription: String
) {
    override fun toString(): String {
        return super.toString()
    }
}