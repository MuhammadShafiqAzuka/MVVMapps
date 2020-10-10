package com.azuka.mvvmapps.ui.job.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.azuka.mvvmapps.repositories.JobRepository

class JobViewModelFactory(private val jobRepository: JobRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JobViewModel(jobRepository) as T
    }
}