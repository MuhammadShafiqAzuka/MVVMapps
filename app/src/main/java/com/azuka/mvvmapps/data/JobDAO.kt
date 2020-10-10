package com.azuka.mvvmapps.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class JobDAO {

    //DATA ACCESS OBJECT
    //CREATE ALL LOGIC FROM JOB CLASS
    //this DAO is fake only
    //right now using mutable list push data
    //this is for LOGIC function to store data

    //assign data into the list (Job)
    private val jobList = mutableListOf<Job>()

    //assign job into Live Data > List > Job
    private val job = MutableLiveData<List<Job>>()

    //initialize all variables
    init {
        //assign the job (value) into the list
        job.value = jobList
    }

    fun addJob(jobs: Job) {
        //logic function to assign and add job
        //add the job into list
        jobList.add(jobs)
        //then update job value into list
        job.value = jobList
    }

    //get all value from the list (job list) > cast it as LiveData
    fun getJob() = job as LiveData<List<Job>>
}