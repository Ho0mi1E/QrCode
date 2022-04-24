package com.example.qrcode.presintation.scanner

import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.example.qrcode.R
import com.example.qrcode.databinding.FragmentScannerBinding
import com.example.qrcode.ScannerApplication
import com.example.qrcode.presintation.codeHistory.HistoryFragment
import com.example.qrcode.presintation.openFragment
import com.example.qrcode.presintation.viewModels.ScannerViewModel
import javax.inject.Inject

class ScannerFragment : Fragment(R.layout.fragment_scanner) {
    companion object {
        const val TAG = "SCAN"
        fun newInstance() = ScannerFragment()
    }

    @Inject
    lateinit var viewModel: ScannerViewModel
    private lateinit var codeScanner: CodeScanner
    private val binding by viewBinding<FragmentScannerBinding>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ScannerApplication.appComponent?.inject(this)
        openScan()

    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private fun openScan() {
        codeScanner = CodeScanner(requireActivity(), binding.scannerView)
        codeScanner.decodeCallback = DecodeCallback { result ->
            requireActivity().runOnUiThread {
                viewModel.putScanInDataBase(
                    result.text,
                    Calendar.getInstance().time.toString()
                )
                requireActivity().openFragment(
                    R.id.container,
                    HistoryFragment.newInstance(),
                    HistoryFragment.TAG
                )
            }
        }
        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }
}


