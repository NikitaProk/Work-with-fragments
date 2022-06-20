package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFragment1.observe(activity as LifecycleOwner) {
            binding.text1.text = it
        }
        binding.buttonAct1.setOnClickListener {
            dataModel.messageForActivity.value = "hello activity from fragment 1"
        }
        binding.buttonFrag1.setOnClickListener{
            dataModel.messageForFragment2.value = "hello frag 2 from frag 1"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =  BlankFragment()
    }
}