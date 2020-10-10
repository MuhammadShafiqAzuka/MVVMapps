package com.azuka.mvvmapps.ui.job.viewmodel

import androidx.lifecycle.ViewModel
import com.azuka.mvvmapps.data.Job
import com.azuka.mvvmapps.repositories.JobRepository

class JobViewModel(private val jobRepository: JobRepository) : ViewModel() {

    //THIS JOB VIEW MODEL CLASS ONLY HANDLE FROM REPOSITORIES
    //ONLY HAVE FUNCTION

    //get the job from job repo
    fun getJob() = jobRepository.getJob()

    //add the job data from job repo
    fun addJob(job: Job) = jobRepository.addJob(job)
}