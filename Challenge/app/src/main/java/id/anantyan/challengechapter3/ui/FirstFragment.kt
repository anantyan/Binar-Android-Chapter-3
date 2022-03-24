package id.anantyan.challengechapter3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import id.anantyan.challengechapter3.R
import id.anantyan.challengechapter3.databinding.FragmentFirstBinding
import id.anantyan.utils.viewbinding.viewBinding

class FirstFragment : Fragment() {

    private val binding: FragmentFirstBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            val destination = R.id.action_firstFragment_to_secondFragment
            it.findNavController().navigate(destination)
        }
    }
}