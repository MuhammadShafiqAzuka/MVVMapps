package com.azuka.mvvmapps.db

import com.azuka.mvvmapps.data.JobDAO

class Database private constructor() {

    //this all is important when using ROOM

    var jobDAO = JobDAO()
        private set

    //Singleton
    companion object {

        //writes is visible to other
        @Volatile
        private var instance: Database? = null

        //get the instance if not null else return beside null ?:
        fun getInstance() =
            //return sync instance if not null
            instance ?: synchronized(this) {
                instance ?: Database().also { instance = it }
            }
    }
}