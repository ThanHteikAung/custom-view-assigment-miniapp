package com.padc.customviewassigment.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.withStyledAttributes
import androidx.core.graphics.blue
import com.padc.customviewassigment.R

class RoundedCornerImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private var cornerRadius = 0f

    private val path = Path()

    private var roundedColor = Color.YELLOW

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        color = Color.BLUE
        textSize = 55.0f
    }

    init {
        context.withStyledAttributes(attrs, R.styleable.RoundedCornerImageView){
            cornerRadius = getDimension(R.styleable.RoundedCornerImageView_cornerRadius,0f)
            roundedColor = getColor(R.styleable.RoundedCornerImageView_roundedColor,0)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f,0f,width.toFloat(),height.toFloat())
        path.addRoundRect(rectangle,cornerRadius,cornerRadius,Path.Direction.CCW)
        paint.color = roundedColor
        canvas?.drawPath(path,paint)
        //drawBackground(canvas)
        //canvas?.drawCircle(50.0f,50.0f,cornerRadius,paint)
        super.onDraw(canvas)
    }

    /*private fun drawBackground(canvas: Canvas?){
        paint.color = roundedColor
    }*/

}