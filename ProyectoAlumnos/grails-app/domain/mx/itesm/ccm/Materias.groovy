package mx.itesm.ccm
import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Materias {
	String nombre
	String clave
}
