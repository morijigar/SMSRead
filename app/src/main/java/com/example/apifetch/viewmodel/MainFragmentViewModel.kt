package com.example.apifetch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apifetch.models.ApiResponse
import com.example.myapplication.ws.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainFragmentViewModel : ViewModel() {

    var listData = MutableLiveData<ApiResponse>()

    var searchJob: Job? = null


    private val repository: Repository = Repository()

    /*val listData : LiveData<MutableList<PostModel>> = liveData(Dispatchers.IO)  {
        val retrievedData = repository.getData()
        emit(retrievedData)
    }*/

    fun callApi(page: String, q: String) {
        if (searchJob != null) {
            searchJob?.cancel()
        }
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(250)
                val retrievedData = repository.getData(page, q)
                listData.postValue(retrievedData)
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> Log.e("TAG", "IO Exception")
                    is HttpException -> {
                        val code = throwable.code()
                        //val errorResponse = convertErrorBody(throwable)
                        Log.e("TAG", "HttpException $code")
                    }
                    else -> {
                        Log.e("TAG", "throwable ${throwable.message}" )
                    }
                }
            }

        }

    }

    /*   fun getDatabaseList(offset: Int, context: Context): MutableList<Rows> {

           //return Database.getInstance(context).appDatabase.PostDao().getAllData(100, offset)
           return Database.getInstance(context).appDatabase.PostDao().getAllData()


       }*/


}