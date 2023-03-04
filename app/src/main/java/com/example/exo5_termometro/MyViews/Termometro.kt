package com.example.exo5_termometro.MyViews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View

class Termometro(context: Context, temp: Float) : View(context) {

    private var tempe: Float = temp

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val heigth : Int = this.height
        val width: Int = this.width
        val xs : Float = width / 2.0f
        var ys : Float = heigth - 100.0f
        val xf : Float = width / 2.0f
        var yf : Float = ys - (tempe*10) - 600

        val p1 = Paint()
        p1.strokeWidth=5.0f
        p1.setColor(Color.rgb(255,0,0))

        val p2 = Paint()
        p2.color = Color.rgb(0, 0, 0)
        p2.style = Paint.Style.STROKE
        p2.textSize = 45f
        p2.strokeWidth = 5f
        p2.typeface = Typeface.SERIF

        val p3 = Paint()

        if (canvas != null) {
            canvas.drawRect(xs-10,ys,xf+10,yf,p1)
            canvas.drawCircle(xs,ys,40.0f, p1)
            canvas.drawRect(xs - 200, ys + 60, xf + 200, 90f, p2)
            canvas.drawText("°C", xs - 150, 150f, p2)
            canvas.drawText("°F", xs + 80, 150f, p2)

            for (i in -5..10)  //afficher des valeurs °C
            {
                val y2 = ys - 600 - i * 100
                canvas.drawRect(xs - 30, y2 - 3, xs - 150, y2 + 3, p3)
                canvas.drawText((i * 10).toString() + "°", xs - 170, y2 - 20, p2)
                for (j in 0..4) {
                    canvas.drawRect(xs - 30, y2 - 3 - j * 20, xs - 60, y2 + 3 - j * 20, p3)
                }
            }

            for (i in -5..22)  //afficher des valeurs °F
            {
                val y1 = ys - 600 - Math.round(5.5556 * i * 10 - 177.78)
                if (i % 2 == 0) {
                    canvas.drawText((i * 10).toString() + "°", xs + 90, y1 - 10, p2)
                    canvas.drawRect(xs + 30, y1 - 3, xs + 150, y1 + 3, p3)
                } else {
                    canvas.drawRect(xs + 30, y1 - 3, xs + 80, y1 + 3, p3)
                }
                for (j in 0..4) {
                    canvas.drawRect(xs + 30, y1 - 2 - j * 11, xs + 60, y1 + 2 - j * 11, p3)
                }
            }
        }
    }

    fun setTemp(temp : Float)
    {
        if(temp>=-50)
        {
            tempe  = temp
        }
        else
        {
            tempe = -50f
        }

        invalidate()
    }
}