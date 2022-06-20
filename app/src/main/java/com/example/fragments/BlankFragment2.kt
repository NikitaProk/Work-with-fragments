package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.FragmentBlank2Binding
import com.example.fragments.databinding.FragmentBlankBinding

class BlankFragment2 : Fragment() {

    private lateinit var binding:FragmentBlank2Binding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment2.observe(activity as LifecycleOwner) {
            binding.text2.text = it
        }
        binding.buttonAct2.setOnClickListener {
            dataModel.messageForActivity.value = "hello activity from fragment 2"
        }
        binding.buttonFrag2.setOnClickListener{
            dataModel.messageForFragment1.value = "hello frag 1 from frag 2"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}