fun getMonth(): Int {
    print("Enter a month number: ")
    var stringInput = readLine()!!
    var intInput = stringInput.toInt()
    while (intInput > 12 || intInput < 1) {
        println("Month must be an integer between 1 and 12")
        print("Enter a month number: ")
        stringInput = readLine()!!
        intInput = stringInput.toInt()
    }
    return intInput
}

fun getYear(): Int {
    print("Enter a year number: ")
    var stringInput = readLine()!!
    var intInput = stringInput.toInt()
    while (intInput < 1753) {
        println("Year must be later than 1753")
        print("Enter a year number: ")
        stringInput = readLine()!!
        intInput = stringInput.toInt()
    }
    return intInput
}

fun isLeap(param_year: Int = 0): Boolean {
    if ((param_year % 4 == 0 && param_year % 100 != 0) || (param_year % 400 == 0) ){
        return true
    }
    else{
        return false
    }
}

fun setNumDays(pam_month: Int = 0, pam_year: Int = 0): Int {
    if (pam_month == 1){
        return 31
    }
    else if (pam_month == 2){
        if (isLeap(pam_year)){
            return 29
        }
        else{
            return 28
        }
    }
    else if (pam_month == 3){
        return 31
    }
    else if (pam_month == 4){
        return 30
    }
    else if (pam_month == 5){
        return 31
    }
    else if (pam_month == 6){
        return 30
    }
    else if (pam_month == 7){
        return 31
    }
    else if (pam_month == 8){
        return 31
    }
    else if (pam_month == 9){
        return 30
    }
    else if (pam_month == 10){
        return 31
    }
    else if (pam_month == 11){
        return 31
    }
    else{
        return 31
    }
}

fun getMonthName(pam_month: Int = 0) {
    if (pam_month == 1){
        print("January, ")
    }
    else if (pam_month == 2){
        print("February, ")
    }
    else if (pam_month == 3){
        print("March, ")
    }
    else if (pam_month == 4){
        print("April, ")
    }
    else if (pam_month == 5){
        print("May, ")
    }
    else if (pam_month == 6){
        print("June, ")
    }
    else if (pam_month == 7){
        print("July, ")
    }
    else if (pam_month == 8){
        print("August, ")
    }
    else if (pam_month == 9){
        print("September, ")
    }
    else if (pam_month == 10){
        print("October, ")
    }
    else if (pam_month == 11){
        print("November, ")
    }
    else{
        print("December, ")
    }
}

fun getOffset(pam_month: Int = 0, pam_year: Int = 0): Int{
    var sum = 0
    for (x in 1753 until pam_year){
        sum += 365
        if (isLeap(x)){
            sum += 1
        }
    }
    for (x in 1 until pam_month){
        sum += setNumDays(x,pam_year)
    }
    return sum % 7
}

fun display(pam_month: Int = 0, pam_year: Int = 0, pam_days: Int = 0, pam_offset: Int = 0){
    println()
    getMonthName(pam_month)
    println(pam_year)
    println("  Su  Mo  Tu  We  Th  Fr  Sa")
    if (pam_offset != 6) {
        for (x in -1 until pam_offset) {
            print("    ")
        }
        for (i in 1..pam_days) {
            if ((i + pam_offset) % 7 == 0){
                println()
            }
            val fNum = i.toString().padStart(2, '0')
            print("  $fNum")
        }
    }
    else if (pam_offset == 6){
        for (i in 1..pam_days){
            if ((i+pam_offset) % 7 == 0 && i+pam_offset != 7){
                println()
            }
            val fNum = i.toString().padStart(2, '0')
            print("  $fNum")
        }
    }
}

fun main(args: Array<String>) {
    val month = getMonth()
    val year = getYear()
    val days = setNumDays(month, year)
    val offset = getOffset(month, year)
    display(month, year, days, offset)

}