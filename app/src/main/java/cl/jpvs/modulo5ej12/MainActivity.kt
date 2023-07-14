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
            println("nombre invalido, ingrese un nombre valido")
            apellidos = readln()
        }

        var edad = readln().toInt()
         while (!validarEdad(edad)){
             println("edad invalido, ingrese edad valido")
             edad = readln().toInt()
         }

        var correo = readln()
        var sistemaSalud = readln()
        var usuario = Usuario(nombre, apellidos, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios) {
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
fun  validarEdad(edad:String): Boolean {
    val onlyNumbers = Regex("\\d+")
    if( onlyNumbers.matches(edad)){
        return false
    }
    return true
}

data class Usuario(
    var nombre : String,
    var apellidos: String,
    var edad:Int,
    var correo: String,
    var sistemaSalud : String  )

