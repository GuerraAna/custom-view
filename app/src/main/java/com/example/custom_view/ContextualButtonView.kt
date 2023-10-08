package com.example.custom_view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.content.withStyledAttributes
import com.example.custom_view.databinding.ContextualButtonViewBinding

/**
 * Custom view for displaying a contextual button
 *
 * @param context The context in which create the view.
 * @param attrs View attributes, used for styling and general view customization.
 * @param defStyleAttr Attribute used to set a default style for the View (usually defined in the theme). 0 for none.
 * @param defStyleRes Default style resource to apply to this View if `defStyleAttr` is unused. 0 for none.
 */
internal class ContextualButtonView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0,
	defStyleRes: Int = 0
): FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

	private lateinit var binding: ContextualButtonViewBinding

	/**
	 * Icon of button view.
	 * @see R.styleable.ContextualButtonView_icon_label
	 */
	var icon: Int = R.drawable.ic_launcher_foreground
		set(value) {
			field = value
			binding.icon.setImageResource(value)
		}

	/**
	 * Text of button view.
	 * @see R.styleable.ContextualButtonView_text_label
	 */
	var text: String = "algum valor de texto a escolher algum valor de texto a escolher algum valor de texto a escolher algum valor de texto a escolher algum valor de texto a escolher algum valor de texto a escolher algum valor de texto a escolher algum valor de texto a escolher algum valor de texto a escolher "
		set(value) {
			field = value
			binding.text.text = value
		}

	init {
		binding = ContextualButtonViewBinding.inflate(
				/* inflater = */ LayoutInflater.from(context),
				/* parent = */ this,
				/* attachToParent = */ true
		)

		initializeAttributes(attrs, defStyleAttr, defStyleRes)
	}

	private fun initializeAttributes(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
		val button = this

		context.withStyledAttributes(attrs, R.styleable.ContextualButtonView, defStyleAttr, defStyleRes) {
			button.icon = getInteger(R.styleable.ContextualButtonView_icon_label, icon)
			button.text = getString(R.styleable.ContextualButtonView_text_label) ?: button.text
		}
	}
}