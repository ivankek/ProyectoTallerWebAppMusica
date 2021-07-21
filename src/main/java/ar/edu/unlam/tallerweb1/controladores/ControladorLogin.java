package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			request.getSession().setAttribute("usuario", usuarioBuscado);
			model.put("sesion", request.getAttribute("usuario"));

			return new ModelAndView("redirect:/Inicio", model);
		} else {

			model.put("Error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}


	@RequestMapping("/registroUsuario")
	public ModelAndView registro(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("registroUsuario", modelo);
	}
	@RequestMapping(path="/procesarRegistro",method=RequestMethod.POST)
	public ModelAndView procesarRegistroUsuario(
			@ModelAttribute("usuario") Usuario usuario,
			@RequestParam(value="repassword",required=false) String repass
			) {
		//validar password con repassword
		ModelMap modelo = new ModelMap();
		if(servicioLogin.consultarUsuario(usuario) == null) {
		if(usuario.getPassword().equals(repass)) {
			//guardamelo en la base
			servicioLogin.insertarUsuario(usuario);
				modelo.put("exito","Usuario registrado! "+usuario.getUsuario());
				}
			else {
				modelo.put("error","No coinciden las pass");
				return new ModelAndView("registroUsuario", modelo);
			}
			}

			else{
			modelo.put("error","Ya existe el usuario");
			return new ModelAndView("registroUsuario", modelo);
		}
			
		return new ModelAndView("login",modelo);
		
	}
	
	
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/cerrarSesion")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/login");
	}

	public ServicioLogin getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	
	
}
