package ar.edu.unlam.tallerweb1;
import  static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import static org.assertj.core.api.Assertions.*;

public class ControladorLoginTestMock extends SpringTest{

	private ServicioLogin servicioLogin;
	private ControladorLogin controladorLogin = new ControladorLogin(servicioLogin);
	private Usuario usuarioMock;
	private HttpServletRequest requestMock;
	private HttpSession sessionMock;
	private ServicioLogin servicioLoginMock;

	
	
	@Before
	public void init(){
		usuarioMock = mock(Usuario.class);
		requestMock = mock(HttpServletRequest.class);
		sessionMock = mock(HttpSession.class);
		servicioLoginMock = mock(ServicioLogin.class);
		controladorLogin.setServicioLogin(servicioLoginMock);	
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void loginConUsuarioExistenteQueLleveAlInicio(){
		
		// Preparacion
		when(requestMock.getSession()).thenReturn(sessionMock);
	
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
		
		// Ejecucion
		ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
		
		// Validacion
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/Inicio");
	
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void loginConUsuarioIncorrectoQuePermanezcaEnLogin(){
		
		// Preparacion
		when(requestMock.getSession()).thenReturn(sessionMock);
	
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(null);
		
		// Ejecucion
		ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
		
		// Validacion
		assertThat(modelAndView.getViewName()).isEqualTo("login");
	
	}
	
	@Test
	@Transactional
	@Rollback(true)
	    public void testQueRedireccionaRolNullALogin() {
	        when(requestMock.getSession()).thenReturn(sessionMock);
	        when(sessionMock.getAttribute("ROL")).thenReturn(null);
	        ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
	        assertThat(modelAndView.getViewName().equals("redirect:/login"));
	    }
		
	@Test
	@Transactional
	@Rollback(true)
	public void testQueVerificaQueSePuedaEnviarARegistrar() {		
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(requestMock.getSession().getAttribute("usuario")).thenReturn(null);
		Usuario usuario = new Usuario();
		
		ModelAndView modelo = controladorLogin.registro(requestMock);
		assertThat(modelo.getViewName()).isEqualTo("registroUsuario");
		assertThat(modelo.getModel().get("usuario")).isEqualTo(usuario);
	}
	 
	@Test
	@Rollback(true)
	@Transactional
	public void RegistroConUsuarioExistentePermanezcaEnElRegistro(){
		
		// Preparacion
		when(requestMock.getSession()).thenReturn(sessionMock);
	
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
		
		// Ejecucion
		ModelAndView modelAndView = controladorLogin.procesarRegistroUsuario(usuarioMock, usuarioMock.getPassword());
		
		// Validacion
		assertThat(modelAndView.getViewName()).isEqualTo("registroUsuario");
	
	}
	
	@Test
	@Rollback(true)
	@Transactional
	public void RegistroUsuarioQueLlevaAlLogin(){
		
		// Preparacion
		when(requestMock.getSession()).thenReturn(sessionMock);
	
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(null);
		
		// Ejecucion
		ModelAndView modelAndView = controladorLogin.procesarRegistroUsuario(usuarioMock, usuarioMock.getPassword());
		
		// Validacion
		assertThat(modelAndView.getViewName()).isEqualTo("login");
	
	}
	
}
