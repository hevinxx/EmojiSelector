package io.hevinxx.emojiselector.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.hevinxx.emojiselector.databinding.BottomSheetDialogFragmentEmojiPickerBinding

class EmojiPickerBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private var _binding: BottomSheetDialogFragmentEmojiPickerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetDialogFragmentEmojiPickerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.emojis.layoutManager = GridLayoutManager(requireContext(), 7)
        binding.emojis.adapter = EmojiAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}