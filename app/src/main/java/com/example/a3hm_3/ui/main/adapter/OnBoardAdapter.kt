package com.example.a3hm_3.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a3hm_3.databinding.ItemOnBoardBinding
import com.example.a3hm_3.ui.main.adapter.OnBoardAdapter.OnBoardViewHolder
import com.example.a3hm_3.ui.main.data.models.OnBoardModel

class OnBoardAdapter(
    val onBoardList: List<OnBoardModel>,
    val onStart: () -> Unit,
    val onSkip: (Int) -> Unit
) :
    RecyclerView.Adapter<OnBoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: OnBoardViewHolder,
        position: Int
    ) {
        holder.onBind(onBoardList[position], position)
    }

    override fun getItemCount(): Int {
        return onBoardList.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(onBoardModel: OnBoardModel, position: Int) {
            binding.apply {
                tvTitle.text = onBoardModel.title
                tvDesc.text = onBoardModel.desc
                img.setAnimation(onBoardModel.path)

                tvSkip.setOnClickListener {
                    onSkip(position)
                }

              btnStart.setOnClickListener {
                    onStart()
                }

                if (adapterPosition == onBoardList.size - 1) {
                   tvSkip.visibility = View.INVISIBLE
                } else {
                   btnStart.visibility = View.INVISIBLE
                }
            }
        }
    }
}