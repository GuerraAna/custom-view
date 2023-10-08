package com.example.custom_view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.custom_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		with(binding.buttonCustomView) {
			icon = R.drawable.baseline_keyboard_arrow_right_24
			text = "mudei o texto em"
			contentDescription = "mudei o texto em, Botão. Clique duas vezes para ativar"
			setOnClickListener {
				Toast.makeText(context, "ciquei aqui em", Toast.LENGTH_LONG).show()
			}
		}
	}
}