package com.dester.androidproject_908_20.presenter.detailed_info

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.dester.androidproject_908_20.data.api.ApiFactory
import com.dester.androidproject_908_20.data.api.CategoryRequest
import com.dester.androidproject_908_20.presenter.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailedInfoVM(
    val request:CategoryRequest,
    val owner: LifecycleOwner
):BaseViewModel() {

    val avatarUrl = MutableLiveData(String())
    val isCharacter = MutableLiveData(true)
    val isLocation = MutableLiveData(true)
    val isEpisode = MutableLiveData(true)

    val name = MutableLiveData(String())
    val status = MutableLiveData(String())
    val species = MutableLiveData(String())
    val gender = MutableLiveData(String())
    val origin = MutableLiveData(String())
    val originUrl = MutableLiveData(String())
    val lastKnownLocation = MutableLiveData(String())
    val lastKnownLocationUrl = MutableLiveData(String())
    val type = MutableLiveData(String())
    val dimension = MutableLiveData(String())
    val episode = MutableLiveData(String())
    val airDate = MutableLiveData(String())

    init{
        loadData()
    }


    private fun loadData() {
        when(request.requestType){
            "character" -> {
                isCharacter.postValue(false)
                loadCharacter()
            }
            "location" -> {
                isLocation.postValue(false)
                loadLocation()
            }
            "episode" -> {
                isEpisode.postValue(false)
                loadEpisode()
            }
        }
    }

    private fun loadEpisode() {
        request.id?.let{ id ->
            addDisposable(
                ApiFactory.universityApi.getSingleEpisodes(
                    id
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ episode ->
                        name.postValue(episode.name)
                        this.episode.postValue(episode.episode)
                        airDate.postValue(episode.airDate)
                    },{
                        Log.d("destErr: ","${it.message}")
                    }
                    )
            )
        }
    }

    private fun loadLocation() {
        request.id?.let{ id ->
            addDisposable(
                ApiFactory.universityApi.getSingleLocations(
                    id
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ dimension ->
                        name.postValue(dimension.name)
                        type.postValue(dimension.type)
                        this.dimension.postValue(dimension.dimension)
                    },{
                        Log.d("destErr: ","${it.message}")
                    }
                    )
            )
        }
    }

    private fun loadCharacter() {
        request.id?.let{ id ->
            addDisposable(
                ApiFactory.universityApi.getSingleCharacter(
                    id
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ character ->
                        name.postValue(character.name)
                        status.postValue(character.status)
                        species.postValue(character.species)
                        gender.postValue(character.gender)
                        origin.postValue(character.origin.name)
                        originUrl.postValue(character.origin.url)
                        avatarUrl.postValue(character.image)
                        lastKnownLocation.postValue(character.location.name)
                        lastKnownLocationUrl.postValue(character.location.url)
                    },{
                        Log.d("destErr: ","${it.message}")
                    }
                    )
            )
        }

    }


    fun originClick(){

    }

}