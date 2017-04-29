package mx.itesm.ccm

//para crear este archivo -> grails create-interceptor mx.itesm.ccm CorsInterceptor

//A interceptor is responsible intercepting incoming web requests and performing actions such as authentication, logging and so on.
//Interceptors: Los controladores serán interceptados por todos los interceptors que haya.
//	3 peticiones: 1 que es antes de recibir la petición, después y después del despliegue la vista
// Nosotros usaremos el after por ser apirest app.
//Sirven para... Es como un filtro. 
//¡Agrega headers!.

class CorsInterceptor {

	public CorsInterceptor(){
		//clase heredada de interceptors. Para que los headers esten alineados con este interceptor.
		//tenemos que hacer una relacion 1-1 basado en lo que viene dentro de nuestro grails,los headers que estaremos enviando.
		matchAll()
	}

    boolean before() { 
    										// "*" para dar acceso a todos
    	header("Access-Control-Allow-Origin", "http://localhost:9000") 
    	//options: son los metodos a los que yo puedo acceder. GET POST PUT
    	boolean options = ("OPTIONS" == request.method)
    		if(options){
    			header("Access-Control-Allow-Origin", "http://localhost:9000")
    			header("Access-Control-Allow-Credentials", "true")
    			header("Access-Control-Allow-Methods", 
    					"POST, GET, DELETE, PUT, OPTIONS")
    			header("Access-Control-Max-Age","3600")
    			response.status = 200
    		}
    	true //grails requiere que des un true. permite el libre paso de la peticion
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
