package com.padc.customviewassigment.views.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.padc.customviewassigment.R

class RoundedProfileImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {


    private var size = 0

    private val path = Path()

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.YELLOW
    }
    private var mStrokeColor = Color.YELLOW

    init {
        context.withStyledAttributes(attrs, R.styleable.RoundedProfileImageView) {
            mStrokeColor = getInt(R.styleable.RoundedProfileImageView_strokeColor, 0)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        drawProfileBackground(canvas)
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //get minimum value
        size = measuredWidth.coerceAtMost(measuredHeight)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    private fun drawProfileBackground(canvas: Canvas?) {
        val radius = size
        val horizontal = size / 2f
        val vertical = size / 2f
        paint.color = mStrokeColor
        canvas?.drawCircle(horizontal, vertical, radius / 2.2f, paint)

        path.addCircle(horizontal, vertical, radius / 2.5f, Path.Direction.CCW)
        canvas?.clipPath(path)
        //canvas?.drawCircle(size/2f,size/2f,radius,paint)
    }
}