package com.azuka.mvvmapps.ui.job

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.azuka.mvvmapps.R
import com.azuka.mvvmapps.data.Job
import com.azuka.mvvmapps.ui.job.viewmodel.JobViewModel
import com.azuka.mvvmapps.utilities.InjectionUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        InitializeUI()
    }

    private fun InitializeUI() {
        //pass all injectors to here
        val factory = InjectionUtils.provideJobViewModelFactory()

        //use view model provider to pass from viewmodel class
        val viewmodel = ViewModelProvider(this, factory)
            .get(JobViewModel::class.java)

        viewmodel.getJob().observe(this, { it ->
            val stringBuilder = StringBuilder()
            it.forEach {
                stringBuilder.append("$it\n\n")
            }
            tvResult.text = stringBuilder.toString()
        })
        btnSend.setOnClickListener {
            val job = Job(etName.text.toString(), etJob.text.toString())
            viewmodel.addJob(job)
            etName.setText("")
            etJob.setText("")
        }
    }

}