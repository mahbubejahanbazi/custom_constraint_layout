package ir.mjahanbazi.customlayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout

class CustomLayout : ConstraintLayout {

    private var strokeWidth: Float = 10f
    private var outsideRadius: Float = 15f
    private var insideRadius: Float=10f

    private var outsideRect: RectF = RectF()
    private var insideRect: RectF = RectF()

    private val paintOutside: Paint = object : Paint() {
        init {
            isAntiAlias = true
            style = Style.STROKE
            color=Color.BLACK
            strokeWidth=5f
        }
    }
    private val paintInside: Paint = object : Paint() {
        init {
            isAntiAlias = true
            style = Style.FILL
            color=Color.WHITE
        }
    }

    init {
        setWillNotDraw(false)
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    fun setRadius(radius: Float) {
        this.outsideRadius = radius
        prepareDraw()
    }

    fun setSrokeWidth(strokeWidth: Float) {
        this.strokeWidth = strokeWidth
        paintOutside.strokeWidth=strokeWidth
        prepareDraw()
    }

    fun setStrokeColor(color: Int) {
        paintOutside.color = color
        prepareDraw()
    }

    fun setInsideColor(color: Int) {
        paintInside.color = color
        prepareDraw()
    }


    private fun prepareDraw() {
        insideRadius=outsideRadius-strokeWidth/2
        outsideRect = RectF(
            strokeWidth/2,
            strokeWidth/2,
            width.toFloat()-strokeWidth/2,
            height.toFloat()-strokeWidth/2
        )
        insideRect = RectF(
            strokeWidth,
            strokeWidth,
            (width - strokeWidth),
            (height - strokeWidth)
        )
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        prepareDraw()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRoundRect(
            outsideRect,
            outsideRadius,
            outsideRadius,
            paintOutside
        )
        canvas.drawRoundRect(
            insideRect,
            insideRadius,
            insideRadius,
            paintInside
        )
    }
}
