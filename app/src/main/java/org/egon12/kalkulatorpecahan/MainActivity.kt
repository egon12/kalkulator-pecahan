package org.egon12.kalkulatorpecahan

import android.os.Bundle
import android.support.constraint.ConstraintLayout.LayoutParams
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.egon12.kalkulatorpecahan.KalkulatorPecahan.Companion.format
import java.util.Arrays.asList


class MainActivity : AppCompatActivity() {

    val kalkulator = KalkulatorPecahan()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kalkulator.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                cnt_100rb.text = kalkulator.cnt100rb.toString()
                cnt_50rb.text = kalkulator.cnt50rb.toString()
                cnt_20rb.text = kalkulator.cnt20rb.toString()
                cnt_10rb.text = kalkulator.cnt10rb.toString()
                cnt_5rb.text = kalkulator.cnt5rb.toString()
                cnt_2rb.text = kalkulator.cnt2rb.toString()
                cnt_1rb.text = kalkulator.cnt1rb.toString()

                sum_100rb.text = format(kalkulator.getSum100rb().toString())
                sum_50rb.text = format(kalkulator.getSum50rb().toString())
                sum_20rb.text = format(kalkulator.getSum20rb().toString())
                sum_10rb.text = format(kalkulator.getSum10rb().toString())
                sum_5rb.text = format(kalkulator.getSum5rb().toString())
                sum_2rb.text = format(kalkulator.getSum2rb().toString())
                sum_1rb.text = format(kalkulator.getSum1rb().toString())
                totalTextView.text = format(kalkulator.getSum().toString())
            }
        }
        kalkulator.observer?.onChange()
    }

    fun btnPressed(view: View) {
        when (view.id) {
            R.id.btn_100rb_plus -> kalkulator.cnt100rb++
            R.id.btn_50rb_plus -> kalkulator.cnt50rb++
            R.id.btn_20rb_plus -> kalkulator.cnt20rb++
            R.id.btn_10rb_plus -> kalkulator.cnt10rb++
            R.id.btn_5rb_plus -> kalkulator.cnt5rb++
            R.id.btn_2rb_plus -> kalkulator.cnt2rb++
            R.id.btn_1rb_plus -> kalkulator.cnt1rb++

            R.id.btn_100rb_min -> kalkulator.cnt100rb--
            R.id.btn_50rb_min -> kalkulator.cnt50rb--
            R.id.btn_20rb_min -> kalkulator.cnt20rb--
            R.id.btn_10rb_min -> kalkulator.cnt10rb--
            R.id.btn_5rb_min -> kalkulator.cnt5rb--
            R.id.btn_2rb_min -> kalkulator.cnt2rb--
            R.id.btn_1rb_min -> kalkulator.cnt1rb--
            R.id.reset -> kalkulator.reset()
        }
    }

    fun switchLayout() {
        for (sum_text in asList(sum_1rb, sum_2rb, sum_5rb, sum_10rb, sum_20rb, sum_50rb, sum_100rb)) {
            val layoutParams = sum_text.layoutParams as LayoutParams
            layoutParams.startToStart = LayoutParams.PARENT_ID
            layoutParams.endToEnd = LayoutParams.UNSET
            sum_text.layoutParams = layoutParams
        }

        for (btn_text in asList(btn_1rb_plus, btn_2rb_plus, btn_5rb_plus, btn_10rb_plus, btn_20rb_plus, btn_50rb_plus, btn_100rb_plus)) {
            val layoutParams = btn_text.layoutParams as LayoutParams
            layoutParams.endToEnd = LayoutParams.PARENT_ID
            layoutParams.startToStart = LayoutParams.UNSET
            btn_text.layoutParams = layoutParams
        }
    }
}
