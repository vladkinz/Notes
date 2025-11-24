package com.example.a3hm_3.ui.main.on_board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a3hm_3.R
import com.example.a3hm_3.databinding.FragmentOnBordBinding
import com.example.a3hm_3.ui.main.adapter.OnBoardAdapter
import com.example.a3hm_3.ui.main.data.models.OnBoardModel


class OnBordFragment : Fragment() {
private lateinit var binding: FragmentOnBordBinding
private lateinit var adapter: OnBoardAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentOnBordBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter(getOnBoardList(), :: onClickStart, :: onSkip )

        binding.vpNotes.adapter = adapter
    }

    private fun  onClickStart(){
        findNavController().navigate(R.id.mainFragment)
    }

    private fun onSkip(position:Int){
        binding.vpNotes.currentItem = position + 1
    }

    fun getOnBoardList(): List<OnBoardModel>{
        return listOf(
            OnBoardModel(
                title = "Удобство",
                desc = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно.",
                path = R.raw.convenience_animation
            ),

            OnBoardModel(
                title = "Организация",
                desc = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время.",
                path = R.raw.organization_animation
            ),
            OnBoardModel(
                title = "Синхронизация",
                desc = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте.",
                path = R.raw.synchronization_animation
            ),
        )
    }
}