package com.dester.androidproject_908_20.presenter.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dester.androidproject_908_20.databinding.FragmentRegistrationBinding
import com.dester.androidproject_908_20.presenter.base.BaseFragment
import com.dester.androidproject_908_20.presenter.data.UserInfo
import com.dester.androidproject_908_20.presenter.login.LoginFragmentDirections

class RegistrationFragment: BaseFragment<RegistrationVM>() {

    lateinit var binding:FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater)
        viewModel = RegistrationVM()
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@RegistrationFragment
        }

        binding.enterButton.setOnClickListener{
            val username = binding.loginInput.text.toString()
            val password = binding.passwordInput.text.toString()
            enter(UserInfo(username,password))
        }

        binding.loginBtn.setOnClickListener {
            loginFragment()
        }

        return binding.root
    }

    fun enter(data: UserInfo){
        val bundle = Bundle().apply {
            putParcelable("userData",data)
        }
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToMainActivity(data)
        navigationController.navigate(action.actionId, bundle)
    }

    fun loginFragment(){
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        navigationController.navigate(action)
    }
}