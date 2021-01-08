package com.example.lotto

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_random.*

class RandomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)
        val lotteryNumbers = arrayListOf(num1,num2,num3,num4,num5,num6)

        val countDownTimer = object: CountDownTimer(3000,100){
            override fun onTick(millisUntilFinished: Long) {
                val numberArray = IntArray(6)
                lotteryNumbers.forEachIndexed { index, textView ->
                    while(true){
                        val randomNumber = (Math.random()*45+1).toInt()
                        if(!numberArray.contains(randomNumber)) {
                            numberArray[index] = randomNumber
                            break
                        }
                    }
                    numberArray.sort()
                    textView.text = "${numberArray[index]}"
                }
            }

            override fun onFinish() {

            }
        }
        lotteryButton.setOnClickListener{
            if(lotteryButton.isAnimating){
                lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            }
            else{
                lotteryButton.playAnimation()
                countDownTimer.start()
            }

        }
    }
}