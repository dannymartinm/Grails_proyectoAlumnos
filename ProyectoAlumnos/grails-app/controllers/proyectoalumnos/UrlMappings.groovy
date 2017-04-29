package proyectoalumnos

class UrlMappings {

    static mappings = {
      /*  delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
     */
        "/alumnos"(resources:"mx.itesm.ccm.Alumnos")
        "/alumnosActivos"(controller:"Alumnos", action: "alumnosHabilitados")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
