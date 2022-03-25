package id.anantyan.challengechapter3.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import id.anantyan.challengechapter3.MainActivity
import id.anantyan.challengechapter3.databinding.FragmentSecondBinding
import id.anantyan.challengechapter3.model.Users
import id.anantyan.utils.Validation.formValid
import id.anantyan.utils.validator.Validator
import id.anantyan.utils.validator.constant.Mode
import id.anantyan.utils.validator.validator

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            onValidation((activity as MainActivity), Validation(it))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onValidation(
        context: Context,
        obj: Validator.OnValidateListener
    ) {
        validator(context) {
            mode = Mode.SINGLE
            listener = obj
            validate(
                formValid(binding.txtLayoutName)
            )
        }
    }

    inner class Validation(
        private val view: View
    ) : Validator.OnValidateListener {
        override fun onValidateSuccess(values: List<String>) {
            val users = Users(
                name = binding.txtInputName.text.toString()
            )
            val destination = SecondFragmentDirections.actionSecondFragmentToThirdFragment(users)
            view.findNavController().navigate(destination)
        }

        override fun onValidateFailed(errors: List<String>) {}
    }
}