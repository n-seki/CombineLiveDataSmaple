package seki.com.app.mutliswitchlivedatasmaple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

class MultiSwitchMediatorLiveData : MediatorLiveData<Boolean>() {
    private val values = mutableListOf<Boolean>()

    fun addSource(source: LiveData<Boolean>) {
        val key = values.size
        values += false
        val observer = Observer<Boolean> {
            values[key] = source.value ?: false
            this.value = values.all { it }
        }
        addSource(source, observer)
    }
}