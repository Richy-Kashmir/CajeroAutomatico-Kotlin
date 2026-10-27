
fun main() {
    // Llamada a la función principal del cajero automático
    cajeroAutomatico()
}

fun cajeroAutomatico() {

    // variables donde se inicia el saldo a 500 y  guardará la opción del menú
    var saldo = 500.0
    var opcion = 0

    // Repetira el menú hasta que el usuario seleccione salir
    do {
        println("===== CAJERO AUTOMÁTICO =====")
        println("1. Consultar saldo")
        println("2. Ingresar dinero")
        println("3. Retirar dinero")
        println("4. Salir")
        print("Seleccione una opción: ")

        // // Lee la opción introducida por el usuario
        val entradaOpcion = readln().toIntOrNull()
        // Es para comprobar de que se haya introducido un número correcto
        if (entradaOpcion == null) {
            println("Error: introduzca una opción numérica válida.")
            println()
            continue
        }

        // Aquí guardara opción elegida
        opcion = entradaOpcion

        // Menu de opciones del cajero automático
        when (opcion) {

            // Opción 1: Consultar saldo
            1 -> {
                println("Su saldo actual es: $saldo €")
            }

            // Opción 2: Ingresar dinero
            2 -> {
                print("Introduzca la cantidad a ingresar: ")
                val ingreso = readln().toDoubleOrNull()

                // Comprueba que la cantidad introducida sea válida
                if (ingreso == null || !ingreso.isFinite() || ingreso <= 0) {
                    println("Error: introduzca una cantidad válida mayor que 0.")
                // Comprueba que el saldo resultante no sea infinito
                } else if (!(saldo + ingreso).isFinite()) {
                    println("Error: el saldo resultante no es válido.")
                    // Aquí hace el ingreso y actualiza el saldo
                } else {
                    saldo += ingreso
                    println("Ingreso realizado correctamente.")
                    println("Nuevo saldo: $saldo €")
                }
            }

            3 -> {
                print("Introduzca la cantidad a retirar: ")
                val retirada = readln().toDoubleOrNull()

                // Hace que la cantidad sea válida y que no supere el saldo disponible
                if (retirada == null || !retirada.isFinite() || retirada <= 0) {
                    println("Error: introduzca una cantidad mayor a 0.")

                //  Comprueba si hay saldo suficiente
                } else if (retirada > saldo) {
                    println("Error: saldo insuficiente.")

                // Y aquí lo mismo que en el ingreso, hace la retirada y actualiza el saldo
                } else {
                    saldo -= retirada
                    println("Retirada realizada correctamente.")
                    println("Nuevo saldo: $saldo €")
                }
            }

            // Cierra el programa
            4 -> {
                println("Gracias por usar nuestro cajero.")
            }

            // Mensaje para una opción no válida
            else -> {
                println("Error: opción no válida.")
            }
        }

        // Esto es visual, crea un espacio vacio
        println()

    } while (opcion != 4)
}

main()