package com.padc.customviewassigment.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.padc.customviewassigment.R

class LineProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var size = 0
    private var innerColor = Color.GREEN
    private var outerColor = Color.GRAY
    private var progress = 0

    //Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    init {
        context.withStyledAttributes(attrs, R.styleable.LineProgressBar) {
            innerColor = getInt(R.styleable.LineProgressBar_innerProgressColor, 0)
            outerColor = getInt(R.styleable.LineProgressBar_outerProgressColor, 0)
            progress = getInt(R.styleable.LineProgressBar_progress,0)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        size = measuredWidth.coerceAtMost(measuredHeight)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        drawLineProgressBar(canvas)
        super.onDraw(canvas)
    }

    private fun drawLineProgressBar(canvas: Canvas?) {
        paint.strokeWidth = height.toFloat()
        paint.color = outerColor
        val y = height / 2f
        canvas?.drawLine(0f, y, width.toFloat(), y, paint)

        paint.color = innerColor
        canvas?.drawLine(0f, y, (width * progress)/100f, y, paint)
    }
}