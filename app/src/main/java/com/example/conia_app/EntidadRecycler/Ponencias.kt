package com.example.conia_app.EntidadRecycler

class Ponencias(nombre:String, precio:Double, rating:Double, imagen:Int) {

    /*
    * Acá debo generar la estructura de la "cardview" del recyclerview
    * */
    var nombre = ""
    var precio = 0.0
    var rating = 0.0
    var imagen = 0

    init {
        this.nombre = nombre
        this.precio = precio
        this.rating = rating
        this.imagen = imagen
    }
}