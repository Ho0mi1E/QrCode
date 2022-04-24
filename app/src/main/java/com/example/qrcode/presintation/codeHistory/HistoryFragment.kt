package com.example.qrcode.presintation.codeHistory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.qrcode.R
import com.example.qrcode.databinding.FragmentHistoryBinding
import com.example.qrcode.domain.interactor.ScanCodeForView
import com.example.qrcode.ScannerApplication
import com.example.qrcode.presintation.codeHistory.clickListener.ClickListener
import com.example.qrcode.presintation.codeHistory.recycler.CodeAdapter
import com.example.qrcode.presintation.openFragment
import com.example.qrcode.presintation.scanner.ScannerFragment
import com.example.qrcode.presintation.viewModels.HistoryViewModel
import javax.inject.Inject

class HistoryFragment : Fragment(R.layout.fragment_history) {
    companion object {
        const val TAG = "HISTORY"
        fun newInstance() = HistoryFragment()
    }

    @Inject
    lateinit var viewModel: HistoryViewModel
    private val binding by viewBinding<FragmentHistoryBinding>()
    private val adapter by lazy { CodeAdapter(clickListener) }

    private val clickListener = object : ClickListener {
        override fun onButtonClickListener(item: ScanCodeForView) {
            val intent = Intent().apply {
                type = "text/plain"
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, item.text)
            }
            val intentChooser = Intent.createChooser(intent, "")
            startActivity(intentChooser)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ScannerApplication.appComponent?.inject(this)
        initRecycler()
        clickListener()
    }


    private fun initRecycler() {
        viewModel.codeList.observe(viewLifecycleOwner) { list ->
            adapter.submitItem(list)
        }
        binding.recycler.adapter = adapter
    }

    private fun clickListener() {
        binding.floatingScanButton.setOnClickListener {
            requireActivity().openFragment(
                R.id.container,
                ScannerFragment.newInstance(),
                ScannerFragment.TAG
            )
        }
    }
}