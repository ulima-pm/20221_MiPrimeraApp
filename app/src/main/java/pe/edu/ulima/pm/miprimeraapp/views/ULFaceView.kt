package pe.edu.ulima.pm.miprimeraapp.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import pe.edu.ulima.pm.miprimeraapp.LoginActivity
import pe.edu.ulima.pm.miprimeraapp.R

// View
class ULFaceView : View {
    private val mPaint : Paint = Paint()
    private var mSize : Float = 0f
    private var mWidth : Float = 0f
    private var mHeight : Float = 0f
    private var mColorCara : Int = Color.YELLOW

    private var mListener : ((v : View) -> Unit)? = null

    public var BocaHeight : Float = 0f

    /*constructor(context : Context) : super(context) {
        // Crear una nueva instancia pero solo desde codigo Kotlin
    }*/

    constructor(context: Context, attrs : AttributeSet) : super(context, attrs) {
        // Crear una instancia a partir de XML

        val a : TypedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ULFaceView,
            0,
            0
        )
        mColorCara = a.getColor(R.styleable.ULFaceView_colorCara, Color.YELLOW)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        mWidth = View.MeasureSpec.getSize(widthMeasureSpec).toFloat()
        mHeight = View.MeasureSpec.getSize(heightMeasureSpec).toFloat()

        mSize = Math.min(mWidth, mHeight)
        BocaHeight = mSize / 8f

        setMeasuredDimension(mWidth.toInt(), mHeight.toInt())
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCara(canvas!!)
        drawOjos(canvas!!)
        drawBoca(canvas!!)
    }

    private fun drawCara(canvas : Canvas) {
        mPaint.color = mColorCara
        mPaint.style = Paint.Style.FILL
        canvas.drawCircle(mWidth / 2f ,
            mHeight /2f,
            mSize / 2,
            mPaint)
    }

    private fun drawOjos(canvas : Canvas) {
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.FILL

        val eyeWidth = mSize / 6f

        // Left Eye
        canvas.drawCircle(mWidth / 2f - mSize / 4f,
             mHeight / 2f - mSize / 4f,
            eyeWidth / 2f,
            mPaint)

        // Right Eye
        canvas.drawCircle(mWidth / 2f + mSize / 4f,
            mHeight / 2f - mSize / 4f,
            eyeWidth / 2f,
            mPaint)
    }

    private fun drawBoca(canvas : Canvas) {
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.FILL

        val bocaWidth = mSize / 2f


        val rectBoca = RectF(
            mWidth / 2f - bocaWidth / 2f,
            mHeight / 2f + mSize / 6f,
            mWidth / 2f + bocaWidth / 2f,
            mHeight / 2f + mSize / 6f + BocaHeight
        )
        canvas.drawOval(rectBoca, mPaint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (mListener != null) {
            mListener!!(this)
            invalidate()
        }

        return super.onTouchEvent(event)
    }

    fun setOnClickListener(listener : (v : View) -> Unit) {
        mListener = listener
    }
}