package org.egon12.kalkulatorpecahan


import org.egon12.kalkulatorpecahan.KalkulatorPecahan.Companion.format
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Testing for the model
 *
 * Created by Egon Firman on 11/5/17.
 */
class KalkulatorPecahanTest {

    @Test
    fun setCnt100rb() {
        val kalkulatorPecahan = KalkulatorPecahan()
        var observerOnChange = false
        kalkulatorPecahan.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                observerOnChange = true
            }
        }
        kalkulatorPecahan.cnt100rb = 5

        assertEquals(kalkulatorPecahan.getSum100rb(), 5 * 100000)
        assert(observerOnChange)
    }

    @Test
    fun setCnt50rb() {
        val kalkulatorPecahan = KalkulatorPecahan()
        var observerOnChange = false
        kalkulatorPecahan.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                observerOnChange = true
            }
        }
        kalkulatorPecahan.cnt50rb = 4

        assertEquals(kalkulatorPecahan.getSum50rb(), 4 * 50000)
        assert(observerOnChange)
    }

    @Test
    fun setCnt20rb() {
        val kalkulatorPecahan = KalkulatorPecahan()
        var observerOnChange = false
        kalkulatorPecahan.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                observerOnChange = true
            }
        }
        kalkulatorPecahan.cnt20rb = 3

        assertEquals(kalkulatorPecahan.getSum20rb(), 3 * 20000)
        assert(observerOnChange)
    }

    @Test
    fun setCnt10rb() {
        val kalkulatorPecahan = KalkulatorPecahan()
        var observerOnChange = false
        kalkulatorPecahan.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                observerOnChange = true
            }
        }
        kalkulatorPecahan.cnt10rb = 2

        assertEquals(kalkulatorPecahan.getSum10rb(), 20000)
        assert(observerOnChange)
    }

    @Test
    fun setCnt5rb() {
        val kalkulatorPecahan = KalkulatorPecahan()
        var observerOnChange = false
        kalkulatorPecahan.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                observerOnChange = true
            }
        }
        kalkulatorPecahan.cnt5rb = 5

        assertEquals(kalkulatorPecahan.getSum5rb(), 25000)
        assert(observerOnChange)
    }

    @Test
    fun setCnt2rb() {
        val kalkulatorPecahan = KalkulatorPecahan()
        var observerOnChange = false
        kalkulatorPecahan.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                observerOnChange = true
            }
        }
        kalkulatorPecahan.cnt2rb = 4

        assertEquals(kalkulatorPecahan.getSum5rb(), 8000)
        assert(observerOnChange)
    }

    @Test
    fun setCnt1rb() {
        val kalkulatorPecahan = KalkulatorPecahan()
        var observerOnChange = false
        kalkulatorPecahan.observer = object : KalkulatorPecahan.Observer {
            override fun onChange() {
                observerOnChange = true
            }
        }
        kalkulatorPecahan.cnt1rb = 3

        assertEquals(kalkulatorPecahan.getSum5rb(), 3000)
        assert(observerOnChange)
    }

    @Test
    fun getSum() {
        val k = KalkulatorPecahan()

        k.cnt100rb = 1
        k.cnt50rb = 1
        k.cnt20rb = 1
        k.cnt10rb = 1
        k.cnt5rb = 1
        k.cnt2rb = 1
        k.cnt1rb = 1
        assertEquals(188000, k.getSum())

        k.cnt100rb = 1
        k.cnt50rb = 2
        k.cnt20rb = 3
        k.cnt10rb = 4
        k.cnt5rb = 5
        k.cnt2rb = 6
        k.cnt1rb = 7
        assertEquals(444000, k.getSum())

    }

    @Test
    fun reset() {
        val k = KalkulatorPecahan()
        k.cnt100rb = 1
        k.cnt50rb = 2
        k.cnt20rb = 3
        k.cnt10rb = 4
        k.cnt5rb = 5
        k.cnt2rb = 6
        k.cnt1rb = 7

        k.reset()
        assertEquals(0, k.cnt100rb)
        assertEquals(0, k.cnt50rb)
        assertEquals(0, k.cnt20rb)
        assertEquals(0, k.cnt10rb)
        assertEquals(0, k.cnt5rb)
        assertEquals(0, k.cnt2rb)
        assertEquals(0, k.cnt1rb)
    }

    @Test
    fun formatTest() {
        assertEquals("100.000", format("100000"))
        assertEquals("1.000.000.000", format("1000000000"))
        assertEquals("3.500.299", format("3500299"))
        assertEquals("278.123.456", format("278123456"))
    }

}