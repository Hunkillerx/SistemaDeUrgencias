package com.example.tibu.sistemadeurgencias.mundo

import ean.collections.*

class Punto:Comparable<Punto>{
    //atributos

    private var calle: Int = 0
    private var carrera: Int = 0

    //constructor primario y secundario
    constructor(calle:Int,carrera: Int){
        this.calle=calle
        this.carrera=carrera
    }

    constructor()

    //analizadoras
    fun darcalle() = calle
    fun darcarrera() = carrera

    //modificadoras
    fun cambiarcalle(calle: Int){
        this.calle=calle
    }
    fun cambiarccarrera(carrera: Int){
        this.carrera=carrera
    }

    //comparador
    override fun compareTo(other: Punto): Int {
        if(compareValues(this.calle,other.calle)==0){
            return compareValues(this.carrera,other.carrera)
        }
        return compareValues(this.calle,other.calle)
    }
}

//--------------------------------------------------------------------------------------------------

//funcion para hallar la distancia
fun distmanhatan(a:Punto,b:Punto):Int{
    return Math.abs(a.darcarrera()-b.darcarrera())+Math.abs(a.darcalle()-b.darcalle())
}

//--------------------------------------------------------------------------------------------------

class Accidentado:Comparable<Accidentado>{

    //atributos
    private var nombre: String = ""
    private var accidente: String = ""
    private var ubicacion: Punto = Punto()

    //contructor primario y secundario
    constructor(nombre: String,accidente:String,ubicacion:Punto){
        this.accidente=accidente
        this.nombre=nombre
        this.ubicacion=ubicacion
    }

    constructor()

    //analizadoras
    fun darNombre() = nombre
    fun darAccidente() = accidente
    fun darUbicacion() = ubicacion


    fun cambiarUbicacion(nUbicacion: Punto) {
        ubicacion = nUbicacion
    }

    //comparador
    override fun compareTo(other: Accidentado): Int {
        return compareValues(this.nombre,other.nombre)
    }
}

//--------------------------------------------------------------------------------------------------

class Ambulancia{

    //atributos
    private var codigo:Int=0
    private var estado:Boolean=false
    private var paciente:Accidentado?= null
    private var ubicacion = Punto()

    //contructor primario y secundario
    constructor(codigo: Int, ubicacion: Punto) {
        this.codigo = codigo
        this.estado = estado
        this.paciente = paciente
        this.ubicacion = ubicacion
    }
    constructor()

    //analizadoras
    fun darCodigo()=codigo
    fun darEstado()=estado
    fun darPaciente()=paciente
    fun darUbicacion()=ubicacion


    fun cambiarUbicacion(punto: Punto){
        ubicacion=punto
    }


    fun recibirAccidentado(accidentado: Accidentado){
        require(!estado)
        paciente=accidentado
        estado=true
    }
    fun vaciarAmbulancia(){
        require(estado)
        paciente=null
        estado=false
    }
}

//--------------------------------------------------------------------------------------------------

class Hospital:Comparable<Hospital>{

    //atributos
    private var codigo: Int = 0
    private var nombre: String = ""
    private var acc1: String = ""
    private var acc2: String = ""
    private var ubicacion: Punto = Punto()
    private var accidentados: IList<Accidentado> = ArrayList()

    //contructor primario y secundario
    constructor(codigo: Int, nombre: String, acc1: String, acc2: String, ubicacion: Punto) {
        this.codigo = codigo
        this.nombre = nombre
        this.acc1 = acc1
        this.acc2 = acc2
        this.ubicacion = ubicacion
    }

    constructor()

    //analizadoras
    fun darCodigo() = codigo
    fun darNombre() = nombre
    fun darPrimerAcc() = acc1
    fun darSegundoAcc() = acc2
    fun darUbicacion() = ubicacion


    fun estaEnHospi(nombre: String):Boolean{
        var bandera = false
        for (i in 0 until accidentados.size){
            if(accidentados[i].darNombre()==nombre){
                bandera=true
            }
        }
        return bandera
    }

    fun existeacc(acc:String):Boolean{
        if (acc==acc1 || acc==acc2){
            return true
        }
        return false
    }

    fun ingresarAlHospi(accidentado: Accidentado){
        if (!estaEnHospi(accidentado.darNombre()) && (accidentado.darAccidente()==acc1 || accidentado.darAccidente()==acc2)){
            accidentados.add(accidentado)
        }
    }

    //comparador
    override fun compareTo(other: Hospital): Int {
        return  compareValues(this.codigo,other.codigo)
    }
}

//----------------------------------------------------------------------------------------------------------------------
object SistemaDeEmergencias{

    private var accidentados: IList<Accidentado> = ArrayList()
    private var ambulancias: IList<Ambulancia> = ArrayList()
    private var hospitales: IList<Hospital> = ArrayList()
    var cantidadAccidentados= accidentados.size

    fun existeHospital(codigo: Int):Boolean {
        var bandera=false
        for (i in 0 until hospitales.size){
            if (hospitales[i].darCodigo()==codigo){
                bandera= true
            }
        }
        return bandera
    }

    fun existeAbulancia(codigo: Int):Boolean {
        var bandera=false
        for (i in 0 until ambulancias.size){
            if (ambulancias[i].darCodigo()==codigo){
                bandera= true
            }
        }
        return bandera
    }

    fun agregarAmbulancia(codigo: Int,x:Int,y:Int){
        if (!existeAbulancia(codigo)) {
            val ambulancia = Ambulancia(codigo, Punto(x, y))
            ambulancias.add(ambulancia)
        }
    }

    fun agregarHospital(codigo: Int,nombre:String, acc1:String,acc2:String, x:Int,y:Int){
        if (!existeHospital(codigo)){
            val hospital = Hospital(codigo,nombre,acc1,acc2,Punto(x,y))
            hospitales.add(hospital)
        }
    }

    fun ambulanciaCercana(accidentado: Accidentado):Ambulancia?{
        val menordis=Int.MAX_VALUE
        var ambulanciaCerca=Ambulancia()

        for (i in 0 until ambulancias.size){
            if (!ambulancias[i].darEstado() && distmanhatan(accidentado.darUbicacion(),ambulancias[i].darUbicacion())<menordis){
                    ambulanciaCerca = ambulancias[i]
                }
            }
        return ambulanciaCerca
    }

    fun actualizarubicacion(codigo: Int,ubicacion: Punto){
        var ambulancia=Ambulancia()
        for (i in 0 until ambulancias.size){
            if (ambulancias[i].darCodigo()==codigo){
                ambulancia= ambulancias[i]
            }
        }
        if (!ambulancia.darEstado()){
            ambulancia.cambiarUbicacion(ubicacion)
        }
    }

    fun asignaraccidentado(accidentado: Accidentado,ambulancia: Ambulancia){
        require(ambulancia.darEstado())
        ambulancia.recibirAccidentado(accidentado)
    }

    fun buscarHospital(ambulancia: Ambulancia):Hospital{
        require(ambulancia.darEstado())
        for (i in 0 until hospitales.size){
            if (ambulancia.darPaciente()!!.darAccidente()== hospitales[i].darPrimerAcc() ||
                    ambulancia.darPaciente()!!.darAccidente()== hospitales[i].darSegundoAcc()){

            }
        }
    }
}


