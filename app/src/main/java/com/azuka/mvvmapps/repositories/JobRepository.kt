package com.azuka.mvvmapps.repositories

import com.azuka.mvvmapps.data.Job
import com.azuka.mvvmapps.data.JobDAO

class JobRepository private constructor(private val jobDAO: JobDAO) {

    //TO STORE ALL LOGIC FUCNTION FOR JOB

    // to add the job (live data)
    fun addJob(job: Job) {
        jobDAO.addJob(job)
    }

    //return the live data
    fun getJob() = jobDAO.getJob()

    //Singleton
    companion object {
        //writes is visible to other
        @Volatile
        private var instance: JobRepository? = null

        //get the instance if not null else return beside null ?:
        fun getInstance(jobDAO: JobDAO) =
            //return sync instance if not null
            instance ?: synchronized(this) {
                instance ?: JobRepository(jobDAO).also { instance = it }
            }
    }
}