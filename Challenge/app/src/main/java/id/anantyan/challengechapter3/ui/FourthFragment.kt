package id.anantyan.challengechapter3.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.navigateUp
import id.anantyan.challengechapter3.MainActivity
import id.anantyan.challengechapter3.R
import id.anantyan.challengechapter3.databinding.FragmentFourthBinding
import id.anantyan.challengechapter3.databinding.FragmentSecondBinding
import id.anantyan.challengechapter3.model.Users
import id.anantyan.utils.Validation
import id.anantyan.utils.Validation.formValid
import id.anantyan.utils.validator.Validator
import id.anantyan.utils.validator.constant.Mode
import id.anantyan.utils.validator.validator
import id.anantyan.utils.viewbinding.viewBinding

class FourthFragment : Fragment() {

    private val binding: FragmentFourthBinding by viewBinding()
    private val args: FourthFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            onValidation((activity as MainActivity), Validation(it))
        }
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