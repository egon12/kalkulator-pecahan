package org.egon12.kalkulatorpecahan

/**
 * Created by nidiastephanie on 11/4/17.
 */

class KalkulatorPecahan {

    companion object {
        fun format(number: String): String {
            return number.replace(Regex("([0-9]{0,3})([0-9]{3})*([0-9]{3})$"), {
                var result = ""
                if (it.groups[1] != null) result += it.groups[1]?.value + "."
                if (it.groups[2] != null) result += it.groups[2]?.value + "."
                result += it.groups[3]?.value
                return@replace result
            })
        }
    }

    interface Observer {
        fun onChange()
    }

    var observer: Observer? = null

    var cnt100rb: Int = 0
        set(value) {
            if (value in 0..10000) field = value
            observer?.onChange()
        }

    var cnt50rb: Int = 0
        set(value) {
            if (value in 0..10000) field = value
            observer?.onChange()
        }

    var cnt20rb: Int = 0
        set(value) {
            if (value in 0..10000) field = value
            observer?.onChange()
        }

    var cnt10rb: Int = 0
        set(value) {
            if (value in 0..10000) field = value
            observer?.onChange()
        }

    var cnt5rb: Int = 0
        set(value) {
            if (value in 0..10000) field = value
            observer?.onChange()
        }

    var cnt2rb: Int = 0
        set(value) {
            if (value in 0..10000) field = value
            observer?.onChange()
        }

    var cnt1rb: Int = 0
        set(value) {
            if (value in 0..10000) field = value
            observer?.onChange()
        }

    fun getSum100rb(): Int {
        return cnt100rb * 100000
    }

    fun getSum50rb(): Int {
        return cnt50rb * 50000
    }

    fun getSum20rb(): Int {
        return cnt20rb * 20000
    }

    fun getSum10rb(): Int {
        return cnt10rb * 10000
    }

    fun getSum5rb(): Int {
        return cnt5rb * 5000
    }

    fun getSum2rb(): Int {
        return cnt2rb * 2000
    }

    fun getSum1rb(): Int {
        return cnt1rb * 1000
    }

    fun getSum(): Int {
        return getSum100rb() +
                getSum50rb() +
                getSum20rb() +
                getSum10rb() +
                getSum5rb() +
                getSum2rb() +
                getSum1rb()
    }

    fun reset() {
        cnt100rb = 0
        cnt50rb = 0
        cnt20rb = 0
        cnt10rb = 0
        cnt5rb = 0
        cnt2rb = 0
        cnt1rb = 0
    }



}

