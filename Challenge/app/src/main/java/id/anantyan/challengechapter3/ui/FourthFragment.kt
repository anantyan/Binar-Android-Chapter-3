package id.anantyan.challengechapter3.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import id.anantyan.challengechapter3.MainActivity
import id.anantyan.challengechapter3.databinding.FragmentFourthBinding
import id.anantyan.challengechapter3.model.Users
import id.anantyan.utils.Validation.formValid
import id.anantyan.utils.validator.Validator
import id.anantyan.utils.validator.constant.Mode
import id.anantyan.utils.validator.validator

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!
    private val args: FourthFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
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
                formValid(binding.txtLayoutAge),
                formValid(binding.txtLayoutAddress),
                formValid(binding.txtLayoutProfession)
            )
        }
    }

    inner class Validation(
        private val view: View
    ) : Validator.OnValidateListener {
        override fun onValidateSuccess(values: List<String>) {
            val users = Users(
                name = args.name,
                age = Integer.parseInt(binding.txtInputAge.text.toString()),
                address = binding.txtInputAddress.text.toString(),
                profession = binding.txtInputProfession.text.toString()
            )
            view.findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToThirdFragment(users))
        }

        override fun onValidateFailed(errors: List<String>) {}
    }
}