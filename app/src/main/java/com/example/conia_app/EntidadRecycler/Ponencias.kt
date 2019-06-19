package com.example.conia_app.EntidadRecycler

class Ponencias(nombre:String, descripcion:String, rating:Double, imagen:Int) {

    /*
    * Acá debo generar la estructura de la "cardview" del recyclerview
    * */
    var nombre = ""
    var descripcion = ""
    var rating = 0.0
    var imagen = 0

    init {
        this.nombre = nombre
        this.descripcion = descripcion
        this.rating = rating
        this.imagen = imagen
    }
}