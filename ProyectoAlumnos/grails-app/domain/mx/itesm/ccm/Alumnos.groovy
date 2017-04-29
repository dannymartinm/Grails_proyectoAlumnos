package mx.itesm.ccm


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Alumnos {
	String nombre
	String apellidos
	String matricula
	String email
	int edad
	boolean habilitado

	static constraints = {
		matricula unique:true
		email email:true
		edad min:18, max:80
		habilitado defaultValue:false
		nombre blank:false
	}


}