package com.dester.androidproject_908_20.presenter.detailed_info

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.androidproject_908_20.R
import com.dester.androidproject_908_20.data.api.CategoryRequest
import com.dester.androidproject_908_20.databinding.DetailedFragmentBinding
import com.dester.androidproject_908_20.presenter.base.BaseFragment
import java.util.*
import kotlin.concurrent.schedule


class DetailedInfoFragment : BaseFragment<DetailedInfoVM>() {
    lateinit var binding: DetailedFragmentBinding
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("dester/", "onCreate")
        val request = arguments?.getParcelable("item_request") ?: CategoryRequest(
            "character",
            null,
            1
        )
        Log.d("dester/", "getRequest: ${request.requestType}")
        viewModel = DetailedInfoVM(request, this,{id -> openLocation(id)},{id -> openCharacter(id)})
        Log.d("dester/", "SetVM")
    }

    private fun openLocation(id: Int) {
        val action = DetailedInfoFragmentDirections.actionDetailedInfoFragmentSelf(
            CategoryRequest("location",null,id)
        )
        navigationController.navigate(action)
    }

    private fun openCharacter(id:Int){
        val action = DetailedInfoFragmentDirections.actionDetailedInfoFragmentSelf(
            CategoryRequest("character",null,id)
        )
        navigationController.navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailedFragmentBinding.inflate(inflater)
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@DetailedInfoFragment
        }

        viewModel.name.observe(viewLifecycleOwner, {
            if (it == "Evil Morty") {
                binding.avatar.setOnClickListener {
                    mediaPlayer?.let { player ->
                        if (player.isPlaying) {
                            player.stop()
                        }
                    }
                    val resId = resources.getIdentifier(
                        R.raw.evil_morty.toString(),
                        "raw", activity?.packageName
                    )

                    mediaPlayer = MediaPlayer.create(activity, resId)
                    mediaPlayer?.start()
                    context?.resources?.let { it1 -> binding.background.setBackgroundColor(it1.getColor(R.color.transparent_red)) }
                }
            }
        })

        return binding.root
    }


    override fun onPause() {
        super.onPause()
        mediaPlayer?.stop()
    }
}