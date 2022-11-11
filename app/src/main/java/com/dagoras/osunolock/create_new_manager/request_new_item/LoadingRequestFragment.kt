package com.dagoras.osunolock.create_new_manager.request_new_item

import android.app.Dialog
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.R
import com.dagoras.osunolock.databinding.FragmentLoadingRequestBinding


class LoadingRequestFragment : Fragment() {

    private lateinit var binding: FragmentLoadingRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadingRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        with(binding) {
            object : CountDownTimer(5000L, 5000L) {
                override fun onTick(l: Long) {
                }

                override fun onFinish() {
                    showCustomDialog("vân tay")
                }
            }.start()

            buttonCancel.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun showCustomDialog(title: String) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.view_dialog)
        val contentDialog = dialog.findViewById(R.id.dialogContent) as TextView
        val buttonConfirm = dialog.findViewById(R.id.buttonConfirm) as TextView
        contentDialog.text = String.format(resources.getString(R.string.dialog), title, title)
        buttonConfirm.setOnClickListener {
            dialog.dismiss()
            this@LoadingRequestFragment.findNavController().popBackStack()
        }
        dialog.show()
    }
}