package com.example.firebasemessenger.viewmodel

import com.example.firebasemessenger.errors.AppError
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModelImpl: BaseViewModel {
    override val scope =  CoroutineScope(Dispatchers.Main)
    override val jobs: MutableList<Job> = mutableListOf()

    suspend fun exceptionHandleable(
        executionBlock: suspend () -> Unit,
        failureBlock: (suspend (error: AppError) -> Unit)? = null,
        completionBlock: (suspend () -> Unit)? = null
    ){
        try {
            executionBlock()
        } catch (exception: Throwable){
            println("Throwable caught, cause: ${exception.cause}, message: ${exception.message}")
            if(exception !is CancellationException){
                failureBlock?.invoke(if (exception is AppError) exception else AppError())
                //TODO add error handling
            } else {
                throw exception
            }
        } finally {
            completionBlock?.invoke()
        }
    }

    override fun onViewShow() { }

    override fun onViewHidden() {
        clearJobs()
    }

    override fun onCleared() {
        clearJobs()
    }

    private fun clearJobs(){
        jobs.forEach {
            it.cancel()
        }
        jobs.clear()
    }
}