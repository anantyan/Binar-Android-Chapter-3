package id.anantyan.challengechapter3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import id.anantyan.challengechapter3.model.Users

class ThirdViewModel(private val state: SavedStateHandle) : ViewModel() {
    companion object {
        private const val SAVE_STATE_ITEM: String = "SAVE_STATE_ITEM"
    }

    private val _item: MutableLiveData<Users?> = state.getLiveData(SAVE_STATE_ITEM, null)

    val item: LiveData<Users?> = _item

    fun setItem(users: Users?) {
        _item.postValue(users)
        state.set(SAVE_STATE_ITEM, _item.value)
    }
}