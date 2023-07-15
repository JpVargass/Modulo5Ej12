package cl.jpvs.modulo5ej12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}



fun main() {
    var usuarios = mutableListOf<Usuario>()
    println("ingresar cantidad de usuarios")
    val cantidadUsuarios = readln().toInt()
    for (i in 1..cantidadUsuarios) {
        println("ingrese el nombre")
        var nombre = readln()
        while (!validarNombre(nombre)){
            println("nombre invalido, ingrese un nombre valido")
            nombre = readln()
        }

        println("ingrese el Apellido")
        var apellidos = readln()
        while (!validarApellido(apellidos)){
            println("Apellido invalido, ingrese un Apellido valido")
            apellidos = readln()
        }
        println("ingrese edad")
        var edad = readln().toInt()
         while (!validarEdad(edad)){
             println("edad invalido, ingrese edad valida")
             edad = readln().toInt()
         }
        println("ingrese correo")
        var correo = readln()
        while (!validarCorreo(correo)){
            println("correo invalido, ingrese correo valido")
            correo = readln()
        }

            println(" Ingrese su sistema de salud 1.Fonasa,2.Isapre,3.Particular ")
            var sistemaSalud = readln()
            while (!validarSistema(sistemaSalud)) {
                println("Sistema de salud inválido, ingrese un sistema de salud válido.")
                sistemaSalud = readln()
            }

        var usuario = Usuario( nombre,  apellidos, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios.sortedBy { it.edad }) {
        println(u)
    }
}

fun validarNombre(nombre: String) : Boolean{

    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }
}

/*
probar alternativa
fun validarNombre(nombre: String) : String{

    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }
}
* */
fun validarApellido(apellido: String): Boolean{
    return apellido.length in 1..20 && apellido.all { it.isLetterOrDigit() }
}
fun  validarEdad(edad:Int): Boolean {
    return edad in 1..115
}
fun validarCorreo(correo:String): Boolean {
    return correo.length in 10..200 && correo.contains(Regex("@"))
}

fun validarSistema(sistemaSalud: String): Boolean {
    if (sistemaSalud.uppercase().lowercase() == "Fonasa" || sistemaSalud.uppercase()
            .lowercase() == "Isapre" || sistemaSalud.uppercase().lowercase() == "Particular"
    ) {
        return false

    }
    return true
}

data class Usuario(
    val nombre : String,
    val apellidos: String,
    val edad:Int,
    val correo: String,
    val sistemaSalud : String
    )

