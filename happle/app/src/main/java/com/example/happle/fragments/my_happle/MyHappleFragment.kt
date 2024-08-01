package com.example.happle

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.happle.databinding.FragmentMyHappleBinding

class MyHappleFragment : Fragment() {

    private var _binding: FragmentMyHappleBinding? = null
    private val binding get() = _binding!!
    private var isFollowing = true
    private var isBookmarked = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyHappleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.applyButton.setOnClickListener {
            if (isFollowing) {
                AlertDialog.Builder(requireContext())
                    .setTitle("이미 멤버입니다")
                    .setMessage("멤버 신청을 취소하시겠습니까?")
                    .setPositiveButton("예") { _, _ ->
                        isFollowing = false
                        binding.applyButton.text = "멤버 신청하기"
                        binding.applyButton.setBackgroundTintList(
                            ContextCompat.getColorStateList(requireContext(), R.color.purple_100)
                        )
                    }
                    .setNegativeButton("아니오", null)
                    .show()
            } else {
                isFollowing = true
                binding.applyButton.text = "팔로잉 중"
                binding.applyButton.setBackgroundTintList(
                    ContextCompat.getColorStateList(requireContext(), android.R.color.darker_gray)
                )
            }
        }

        binding.bookmarkBtn.setOnClickListener {
            isBookmarked = !isBookmarked
            binding.bookmarkBtn.setImageResource(
                if (isBookmarked) R.drawable.ic_bookmark_filled else R.drawable.ic_bookmark)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}