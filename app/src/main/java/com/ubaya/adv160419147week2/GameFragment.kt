package com.ubaya.adv160419147week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
        var score = 0;
        var nilaiX = Random.nextInt(20)
        var nilaiY = Random.nextInt(20)
        txtValueX.text = "$nilaiX"
        txtValueY.text = "$nilaiY"

        btnSubmit.setOnClickListener {
            nilaiX = Random.nextInt(20)
            nilaiY = Random.nextInt(20)
            txtValueX.text = "$nilaiX"
            txtValueY.text = "$nilaiY"
            var result = nilaiX + nilaiY
            if (txtAnswer.text.toString() != "" && txtAnswer.text.toString() == result.toString()){
                score++
            } else {
                val action = GameFragmentDirections.actionResultFragment(score.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}