package proyectoalumnos
import mx.itesm.ccm.*
/*import proyectoalumnos.Role
import proyectoalumnos.UserRole
import proyectoalumnos.Alumnos
*/
class BootStrap {

    def init = { servletContext ->
    	new Alumnos(matricula:"1323113", 
    				nombre:"Dani", apellidos:"Martín", edad:20,
    				email:"dani@mail.com", habilitado:true).save()
    	new Alumnos(matricula:"1337654", 
    				nombre:"Itzi", apellidos:"Dani", edad:24,
    				email:"ixchi@mail.com", habilitado:false).save()
    	new Alumnos(matricula:"1278889", 
    				nombre:"Juan", apellidos:"Velez", edad:22,
    				email:"juanito@mail.com", habilitado:true).save()

        Role rol1 = new Role("ROLE_ADMIN").save()
        User user1 = new User("Administrador","123456").save()
        UserRole.create(user1,rol1,true)
    }
    def destroy = {
    }
}
