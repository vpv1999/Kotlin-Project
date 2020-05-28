
internal object NumberOfDays {

    private var monthDays = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    class Date(d:Int, m:Int, y:Int) {
        var d:Int = 0
        var m:Int = 0
        var y:Int = 0
        init{
            this.d = d
            this.m = m
            this.y = y
        }
    }
    private fun countLeapYears(d:Date):Int {
        var years = d.y
        if (d.m <= 2)
        {
            years--
        }
        return years / 4 - years / 100 + years / 400
    }

    private fun getDifference(dt1:Date, dt2:Date): Int {
        var n1 = dt1.y * 365 + dt1.d
        for (i in 0 until dt1.m - 1)
        {
            n1 += monthDays[i]
        }
        n1 += countLeapYears(dt1)
        var n2 = dt2.y * 365 + dt2.d
        for (i in 0 until dt2.m - 1)
        {
            n2 += monthDays[i]
        }
        n2 += countLeapYears(dt2)
        return (n2 - n1)
    }

    @JvmStatic fun main(args:Array<String>) {

        val dt1 = Date(20, 1, 1999)
        val dt2 = Date(21, 5, 2012)

        when {
            getDifference(dt1, dt2) == 0 -> {
                println("Oops!! The dates are same :)")
            }
            getDifference(dt1, dt2) < 0 -> {
                println("Error!! Please check the dates once again :|")
            }
            else -> {
                println("Difference between two dates is " + getDifference(dt1, dt2) )
                println("In hours, ${getDifference(dt1, dt2)} days is equal to " + getDifference(dt1, dt2)*24 + " Hrs")
                println("In minutes, ${getDifference(dt1, dt2)} days is equal to " + getDifference(dt1, dt2)*24*60 + " Mins")
                println("In seconds, ${getDifference(dt1, dt2)} days is equal to " + getDifference(dt1, dt2)*24*60*60 + " Sec")
            }
        }
    }
}
