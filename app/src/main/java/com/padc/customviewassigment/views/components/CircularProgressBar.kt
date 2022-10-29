package com.padc.customviewassigment.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.padc.customviewassigment.R

class CircularProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    private var size = 0
    private var radius = 0f
    private var innerCircleRadius = 0f
    private var outerCircleRadius = 0f
    private var innerColor = Color.WHITE
    private var outerColor = Color.GRAY
    private var progressColor = Color.GREEN
    private var progressText = 0

    //Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.YELLOW
    }

    init {
        context.withStyledAttributes(attrs, R.styleable.CircularProgressBar) {
            innerColor = getInt(R.styleable.CircularProgressBar_innerColor, 0)
            outerColor = getInt(R.styleable.CircularProgressBar_outerColor, 0)
            progressColor = getInt(R.styleable.CircularProgressBar_progressColor, 0)
            progressText = getInt(R.styleable.CircularProgressBar_progressText, 0)

        }
    }


    override fun onDraw(canvas: Canvas?) {
        drawProgressCircle(canvas)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        size = measuredWidth.coerceAtMost(measuredHeight)
        radius = size / 2f
        innerCircleRadius = size * 0.40f
        outerCircleRadius = size / 2f
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }


    private fun drawProgressCircle(canvas: Canvas?) {

        //Draw Outer Circle
        paint.color = outerColor
        canvas?.drawCircle(size / 2f, size / 2f, outerCircleRadius, paint)

        //set left,top,right,bottom to define four point of progress
        val mRectF = RectF(
            size / 2f - outerCircleRadius,
            size / 2f - outerCircleRadius,
            size / 2f + outerCircleRadius,
            size / 2f + outerCircleRadius
        )

        //Draw Progress Circle
        paint.color = progressColor
        canvas?.drawArc(mRectF, 270f, 360 * (75 / 100f), true, paint)

        //Draw InnerCircle
        paint.color = innerColor
        canvas?.drawCircle(size / 2f, size / 2f, innerCircleRadius, paint)

        //Set progress text
        paint.textSize = size / 10f
        val strProgressText = "$progressText%"
        val lan = strProgressText.length * (size / 10f)/4
        canvas?.drawText(strProgressText, radius - lan, size / 2f, paint)
    }
}