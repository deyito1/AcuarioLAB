package acuario

import kotlin.math.PI

// Clase Acuario
open class Acuario(open var largo: Int = 100, open var ancho: Int = 20, open var alto: Int = 40) {

    // Propiedad calculada del volumen
    open var volumen: Int
        get() = ancho * alto * largo / 1000  // 1000 cm^3 = 1 l
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    // Forma del acuario
    open val forma = "rectángulo"

    // Agua que contiene el acuario (90% del volumen)
    open var agua: Double
        get() = volumen * 0.9
        set(_) {}  // No se usa el setter, pero se necesita para ser 'open'

    // Método para imprimir el tamaño del acuario
    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm Largo: $largo cm Alto: $alto cm")
        println("Volumen: $volumen l Agua: $agua l (${agua / volumen * 100.0}% lleno)")
    }

    // Constructor secundario para crear un acuario basado en el número de peces
    constructor(numeroDePeces: Int) : this() {
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }
}

// Subclase TanqueTorre
class TanqueTorre(override var alto: Int, var diametro: Int) : Acuario(alto = alto, ancho = diametro, largo = diametro) {

    // Sobrescribe el cálculo del volumen para un cilindro
    override var volumen: Int
        get() = (ancho / 2 * largo / 2 * alto / 1000 * PI).toInt()
        set(valor) {
            alto = ((valor * 1000 / PI) / (ancho / 2 * largo / 2)).toInt()
        }

    // Sobrescribe el cálculo del agua, aquí es el 80% del volumen
    override var agua: Double
        get() = volumen * 0.8
        set(_) {}

    // Sobrescribe la forma del tanque
    override val forma = "cilindro"
}
