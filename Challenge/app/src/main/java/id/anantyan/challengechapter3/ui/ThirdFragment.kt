package id.anantyan.challengechapter3.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import id.anantyan.challengechapter3.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val args: ThirdFragmentArgs by navArgs()
    private val viewModel: ThirdViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEdit.setOnClickListener {
            val name = binding.txtName.text.toString().drop(12)
            val destiation = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(name)
            it.findNavController().navigate(destiation)
        }
        onSaveState()
        onRestoreState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    private fun onRestoreState() {
        viewModel.item.observe(viewLifecycleOwner) {
            it?.let { item ->
                binding.txtName.text = "Nama anda : ${item.name}"
                binding.txtAge.text = "Usia anda : ${onOddEven(item.age)}"
                binding.txtAddress.text = "Alamat anda : ${item.address}"
                binding.txtProfession.text = "Pekerjaan anda : ${item.profession}"
            }
        }
    }

    private fun onSaveState() {
        val users = args.users
        users?.let {
            viewModel.setItem(it)
        }
    }

    private fun onOddEven(number: Int?): String {
        number?.let {
            return if (number % 2 == 0) {
                "$number Genap"
            } else {
                "$number Ganjil"
            }
        }
        return ""
    }
}
