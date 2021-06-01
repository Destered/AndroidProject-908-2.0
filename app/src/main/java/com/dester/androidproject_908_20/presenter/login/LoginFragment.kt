package com.dester.androidproject_908_20.presenter.login

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.lifecycleScope
import com.dester.androidproject_908_20.databinding.FragmentLoginBinding

import com.dester.androidproject_908_20.presenter.base.BaseFragment
import com.dester.androidproject_908_20.presenter.data.UserInfo


class LoginFragment : BaseFragment<LoginVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = LoginVM(
            lifecycleScope,
            this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater)

        binding.apply {
            lifecycleOwner = this@LoginFragment
            vm = viewModel
        }

        binding.enterButton.setOnClickListener{
            if(binding.loginInput.text.toString() == "test" && binding.passwordInput.text.toString() == "test"){
                enter()
            }
        }

        binding.registrationBtn.setOnClickListener {
            registrationFragment()
        }

        return binding.root
    }

    fun enter(){
        val data = UserInfo("test","test")
        val bundle = Bundle().apply {
            putParcelable("userData",data)
        }
        val action = LoginFragmentDirections.actionLoginFragmentToMainActivity(data)
        navigationController.navigate(action.actionId, bundle)
    }

    fun registrationFragment(){
        val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        navigationController.navigate(action)
    }





}