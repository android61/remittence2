const val EROR_LIMIT = -1
fun main() {
    
if (getComission() == ERROR_LIMIT){
        println("Лимит превышен.")
    }else println("Комиссия: ${getComission()}.")
}

fun getComission (cardType: String = "Vk Pay", sumLastRemittence: Int = 0, remittence: Int = 5000): Int {
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
