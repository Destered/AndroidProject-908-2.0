package com.dester.androidproject_908_20.presenter.category_list

import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import com.dester.androidproject_908_20.data.api.ApiFactory
import com.dester.androidproject_908_20.data.api.response.BaseCategoryData
import com.dester.androidproject_908_20.presenter.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.dester.androidproject_908_20.data.api.CategoryRequest

class CategoryListVM(
    val lifecycleCoroutineScope: LifecycleCoroutineScope,
    val request: CategoryRequest,
    val owner: LifecycleOwner,
    val openItem: (String, Int) -> Unit,
) : BaseViewModel() {

    val itemList = MutableLiveData<List<BaseCategoryData>>(arrayListOf())
    val itemListAdapter = CategoryListAdapter(openItem)

    var currentPage: Int = 1

    val loadingVisibility = MutableLiveData(true)

    fun initVM(){
        Log.d("dester/","Init VM")

        itemList.observe(owner) { lessons ->
            Log.d("dester/","Observe: ${itemList.value?.size}")
            if(itemList.value?.size != 0) {
                itemListAdapter.setItems(lessons)
                loadingVisibility.postValue(false)
                Log.d("dester/", "Item set")
            }
        }
        Log.d("dester/","End observe")


        loadListItem()


    }

    fun loadMoreData(){
        currentPage++
        loadListItem()
    }

    private fun loadListItem() {
        Log.d("dester/","LoadListItem")

            when(request.requestType){
                "character" -> loadCharacterItem()
                "location" -> loadLocationItem()
                "episode" -> loadEpisodeItem()
            }

    }

     private fun loadCharacterItem() {
         Log.d("dester/","LoadCharacter")
        addDisposable(
            ApiFactory.universityApi.getCharacter(
                currentPage,
                request.name,
                request.status,
                request.species,
                request.type,
                request.gender
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                { response ->
                    Log.d("dester/","GetResponse")
                    val array = arrayListOf<BaseCategoryData>()
                    itemList.value?.map {
                        array.add(it)
                    }
                    response.results.map { character ->
                        array.add(BaseCategoryData(character.name,"character",character.id))
                    }
                    Log.d("dester/","arrayPut: ${array.size}")
                    itemList.setValue(array)
                    itemList.value?.let{
                        itemList.postValue(it.distinct())
                    }
                },{
                    Log.e("destErr:","${it.message}")
                }
            )
        )
    }

    private fun loadLocationItem() {
        addDisposable(
            ApiFactory.universityApi.getLocations(
                currentPage,
                request.name,
                request.type,
                request.dimension,
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        val array = arrayListOf<BaseCategoryData>()
                        itemList.value?.map {
                            array.add(it)
                        }
                        response.results.map { character ->
                            array.add(BaseCategoryData(character.name,"location",character.id))
                        }
                        itemList.postValue(array)
                    },{
                        Log.e("destErr:","${it.message}")
                    }
                )
        )
    }

    private fun loadEpisodeItem() {
        addDisposable(
            ApiFactory.universityApi.getEpisodes(
               currentPage,
               request.name,
                request.episode,
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { response ->
                        val array = arrayListOf<BaseCategoryData>()
                        itemList.value?.map {
                            array.add(it)
                        }
                        response.results.map { character ->
                            array.add(BaseCategoryData(character.name,"episode",character.id))
                        }
                        itemList.postValue(array)
                    },{
                        Log.e("destErr:","${it.message}")
                    }
                )
        )
    }
}