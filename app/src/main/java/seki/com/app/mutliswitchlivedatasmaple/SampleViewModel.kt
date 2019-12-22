package seki.com.app.mutliswitchlivedatasmaple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {
    private val _completed = MultiSwitchMediatorLiveData()
    val completed: LiveData<Boolean> = _completed

    private val result1 = MutableLiveData<Boolean>().also { _completed.addSource(it) }
    private val result2 = MutableLiveData<Boolean>().also { _completed.addSource(it) }

    fun onResultChange1(checked: Boolean) {
        result1.value = checked
    }

    fun onResultChange2(checked: Boolean) {
        result2.value = checked
    }
}