const val EROR_LIMIT = -1
fun main() {



    val comission = getComission("Vk Pay", 0, 5000)
    if (comission == EROR_LIMIT ) {
        println("Превышен лимит")
    } else println("Комиссия составит: $comission рублей.")
}

fun getComission (cardType: String, sumLastRemittence: Int, remittence: Int): Int {
    return when (cardType) {
        "Maestro", "Mastercard" -> (if (sumLastRemittence + remittence <= 600000 && remittence <= 150000)
            comissionMaestroMastercard(remittence)
        else EROR_LIMIT)
        "Visa", "Мир" -> (if (sumLastRemittence + remittence <= 600000 && remittence <= 150000)
            comissionVisaMir(remittence, minCommission)
        else EROR_LIMIT)
        "Vk Pay" -> (if (sumLastRemittence + remittence <= 40000 && remittence <= 15000) 0 else EROR_LIMIT)
        else -> EROR_LIMIT
    }
}

val minCommission = 35
fun comissionVisaMir (remittence:Int, minCommission: Int) =
    if ((remittence * 0.0075) > minCommission)
        (remittence * 0.0075).toInt()
    else minCommission


fun comissionMaestroMastercard (remittence: Int) =
    if (remittence > 75000)
        (remittence * 0.006 + 20).toInt()
    else 0
