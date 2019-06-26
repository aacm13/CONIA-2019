package com.martinez.conia_app.DataBase.Entities

class Ponencias {
    var nombre = ""
    var descripcion = ""
    var rating = 0.0
    var imagen = 0

    constructor(){

    }

    constructor(nombre: String, descripcion: String, rating: Double, imagen: Int) {
        this.nombre = nombre
        this.descripcion = descripcion
        this.rating = rating
        this.imagen = imagen
    }
}