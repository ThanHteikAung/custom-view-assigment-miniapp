package com.padc.customviewassigment.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.withStyledAttributes
import com.padc.customviewassigment.R

class RoundedCornerImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private var cornerRadius = 0f

    private val path = Path()

    private var roundedColor = Color.YELLOW

    init {
        context.withStyledAttributes(attrs, R.styleable.RoundedCornerImageView){
            //take text view of radius entry value
            cornerRadius = getDimension(R.styleable.RoundedCornerImageView_cornerRadius,0f)

            //take text view of color entry value
            roundedColor = getColor(R.styleable.RoundedCornerImageView_roundedColor,0)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f,0f,width.toFloat(),height.toFloat())
        path.addRoundRect(rectangle,cornerRadius,cornerRadius,Path.Direction.CCW) //draw
        paint.color = roundedColor    //dynamic change color depended on Text view entry value
        canvas?.drawPath(path,paint)  // draw rectangle text view on canvas
        super.onDraw(canvas)
    }

}