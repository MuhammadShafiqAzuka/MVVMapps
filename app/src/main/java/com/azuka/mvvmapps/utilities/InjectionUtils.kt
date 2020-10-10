package com.azuka.mvvmapps.utilities

import com.azuka.mvvmapps.db.Database
import com.azuka.mvvmapps.repositories.JobRepository
import com.azuka.mvvmapps.ui.job.viewmodel.JobViewModelFactory

object InjectionUtils {

    //THIS INJECTION FOR CLASS DEPENDENCY
    //CREATE A FUCNTION TO HANDLE ALL CLASSESS
    //FACTORY > VIEWMODEL > REPO > DB > DAO (all data)

    fun provideJobViewModelFactory(): JobViewModelFactory {
        val jobRepo = JobRepository.getInstance(Database.getInstance().jobDAO)
        return JobViewModelFactory(jobRepo)
    }
}