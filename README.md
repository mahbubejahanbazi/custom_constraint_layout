
# Custom ConstraintLayout With Kotlin
We design a custom ConstraintLayout by using Draw. A custom ConstraintLayout class with modification in :
- StrokeWidth
- StokeColor
- Inside color
- Corner radius


## Tech Stack

Kotlin

<p align="center">
  <img src="https://github.com/mahbubejahanbazi/custom_constraint_layout/blob/main/images/constraint_layout.jpg" />
</p>


## Source code

CustomConstraintLayout.kt
```kotlin
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

class CustomConstraintLayout : ConstraintLayout {

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
```
activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#AEDEE4"
    android:orientation="vertical">

    <ir.mjahanbazi.customlayout.CustomConstraintLayout
        android:id="@+id/layout1"
        android:layout_width="160dp"
        android:layout_height="80dp"
        android:layout_alignParentTop="true"
        android:layout_centerInParent="true"
        android:layout_margin="10dp" />

    <ir.mjahanbazi.customlayout.CustomConstraintLayout
        android:id="@+id/layout2"
        android:layout_width="160dp"
        android:layout_height="80dp"
        android:layout_below="@+id/layout1"
        android:layout_centerInParent="true"
        android:layout_margin="10dp" />

    <ir.mjahanbazi.customlayout.CustomConstraintLayout
        android:id="@+id/layout3"
        android:layout_width="160dp"
        android:layout_height="80dp"
        android:layout_below="@id/layout2"
        android:layout_centerInParent="true"
        android:layout_margin="10dp" />

    <ir.mjahanbazi.customlayout.CustomConstraintLayout
        android:id="@+id/layout4"
        android:layout_width="160dp"
        android:layout_height="80dp"
        android:layout_below="@id/layout3"
        android:layout_centerInParent="true"
        android:layout_margin="10dp" />
</RelativeLayout>
```
MainActivity.kt
```kotlin
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout1: CustomConstraintLayout = findViewById(R.id.layout1)
        layout1.setStrokeColor(Color.BLUE)
        layout1.setInsideColor(Color.YELLOW)
        layout1.setRadius(20f)
        layout1.setSrokeWidth(25f)

        val layout2: CustomConstraintLayout = findViewById(R.id.layout2)
        layout2.setStrokeColor(Color.DKGRAY)
        layout2.setInsideColor(Color.LTGRAY)
        layout2.setRadius(15f)
        layout2.setSrokeWidth(12f)

        val layout3: CustomConstraintLayout = findViewById(R.id.layout3)
        layout3.setStrokeColor(Color.BLACK)
        layout3.setInsideColor(Color.WHITE)
        layout3.setRadius(15f)
        layout3.setSrokeWidth(8f)

        val layout4: CustomConstraintLayout = findViewById(R.id.layout4)
        layout4.setStrokeColor(Color.BLACK)
        layout4.setInsideColor(Color.TRANSPARENT)
        layout4.setRadius(15f)
        layout4.setSrokeWidth(8f)
    }
}
```
## Contact


mjahanbazi@protonmail.com