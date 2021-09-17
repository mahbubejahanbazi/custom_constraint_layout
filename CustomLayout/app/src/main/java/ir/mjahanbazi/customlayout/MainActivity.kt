package ir.mjahanbazi.customlayout

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout1: CustomLayout = findViewById(R.id.layout1)
        layout1.setStrokeColor(Color.BLUE)
        layout1.setInsideColor(Color.YELLOW)
        layout1.setRadius(20f)
        layout1.setSrokeWidth(25f)

        val layout2: CustomLayout = findViewById(R.id.layout2)
        layout2.setStrokeColor(Color.DKGRAY)
        layout2.setInsideColor(Color.LTGRAY)
        layout2.setRadius(15f)
        layout2.setSrokeWidth(12f)

        val layout3: CustomLayout = findViewById(R.id.layout3)
        layout3.setStrokeColor(Color.BLACK)
        layout3.setInsideColor(Color.WHITE)
        layout3.setRadius(15f)
        layout3.setSrokeWidth(8f)

        val layout4: CustomLayout = findViewById(R.id.layout4)
        layout4.setStrokeColor(Color.BLACK)
        layout4.setInsideColor(Color.TRANSPARENT)
        layout4.setRadius(15f)
        layout4.setSrokeWidth(8f)
    }
}
