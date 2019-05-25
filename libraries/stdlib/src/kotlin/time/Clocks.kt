/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package kotlin.time

import kotlin.js.JsName

public expect object MonoClock : Clock


public abstract class LongReadingClock(protected val unit: DurationUnit) : Clock {
    protected abstract fun reading(): Long

    override fun mark(): ClockMark = object : ClockMark {
        val startedAt = reading()
        override fun elapsed(): Duration = (reading() - startedAt).toDuration(this@LongReadingClock.unit)
    }
}

public abstract class DoubleReadingClock(protected val unit: DurationUnit) : Clock {
    protected abstract fun reading(): Double

    override fun mark(): ClockMark = object : ClockMark {
        val startedAt = reading()
        override fun elapsed(): Duration = (reading() - startedAt).toDuration(this@DoubleReadingClock.unit)
    }
}



public class TestClock(
    @JsName("readingValue")
    var reading: Long = 0L,
    unit: DurationUnit = DurationUnit.NANOSECONDS
) : LongReadingClock(unit) {
    override fun reading(): Long = reading
}

/*
public interface WallClock {
    fun currentTimeMilliseconds(): Long

    companion object : WallClock, LongReadingClock() {
        override fun currentTimeMilliseconds(): Long = System.currentTimeMillis()
        override fun reading(): Long = System.currentTimeMillis()
        override val unit: DurationUnit get() = DurationUnit.MILLISECONDS
    }
}
*/