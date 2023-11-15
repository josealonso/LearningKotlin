// Summary2/Task6.kt
package summaryIIExercise6

import atomictest.eq

// I N C O R R E C T

class Temperature {
    private var current = 0.0
    private var scale = "f"

    var farenheit: Double = 0.0
        get() {
            if (scale == "f")
                return field
            else
                return field * 9.0 / 5.0 + 32.0
        }
        set(value) {
            field = value
            scale = "f"
        }

    var celsius: Double = 0.0
        get() {
            return if (scale == "c")
                field
            else
                (field - 32.0) * 5.0 / 9.0
        }
        set(value) {
            field = value
            scale = "c"
        }

}

fun main() {
    val temp = Temperature()
    temp.farenheit = 98.6
    temp.farenheit eq 98.6
    temp.celsius eq 37.0
    temp.celsius = 100.0
    temp.farenheit eq 212.0
}