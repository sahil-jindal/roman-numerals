object RomanNumerals {

    private val romanAlphabets = listOf('I', 'V', 'X', 'L', 'C', 'D', 'M')

    private val numbers = romanAlphabets.windowed(3, 2) { (a, b, c) ->
        listOf("", "$a", "$a$a", "$a$a$a", "$a$b", "$b", "$b$a", "$b$a$a", "$b$a$a$a", "$a$c")
    }

    fun value(n: Int): String {
        if(n !in 1..3999) throw IllegalArgumentException()

        val digitList = n.toString().map { it - '0' }.reversed()
        val length = minOf(digitList.size, 3)

        val result = mutableListOf<String>()

        (0 until length).forEach {
            result.add(numbers[it][digitList[it]])
        }

        if(digitList.size == 4) {
            result.add("M".repeat(digitList[3]))
        }

        return result.reversed().joinToString("")
    }
}