package com.sdhdata.consulta;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdhdata.model.Activo;
import com.sdhdata.model.Institucion;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Tipo;
import com.sdhdata.model.Zona;
import com.sdhdata.service.IActivoService;
import com.sdhdata.service.IInstitucionService;
import com.sdhdata.service.IRegistroDelSpiService;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.ITipoService;
import com.sdhdata.service.IZonaService;

@Controller
@RequestMapping("/views/Consulta/RegistroDelSpi")
public class RegistroDelSpiConsultaController {
	
	@Autowired
	private IRegistroDelSpiService IRegistroDelSpiService;
	@Autowired
	private IActivoService IActivoService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IInstitucionService IInstitucionService;
	@Autowired
	private ITipoService ITipoService;
	@Autowired
	private IZonaService IZonaService;
	/*
	 * @Autowired private ServletContext context;
	 */
	
	
	//LISTAR
	@GetMapping("/")
	public String listarCantones(Model model,@ModelAttribute("idtipo") Tipo idtipo,@ModelAttribute("idzona") Zona idzona) {
		List<RegistrodelSpi> listaregistrodelspi=IRegistroDelSpiService.listarregistro();
		model.addAttribute("titulo","Lista de Bienes y Servicios de los SPI");
		model.addAttribute("listaregistrodelspi",listaregistrodelspi);
	    //CREAR FORMULARIO REGISTRO DE VENTANA MODAL registrodelspi.html
		Tipo tipo= new Tipo();
		Zona zona= new Zona();
		RegistrodelSpi registrodelspi=new RegistrodelSpi();
		List<Zona> listazona=IZonaService.listazona(); 
		List<Activo>listaactivo=IActivoService.listaactivo(); 
		List<SpiDatos>listaspi=ISpiDatosService.listaspidatos(); 
		List<Institucion>listainstitucion=IInstitucionService.listainstitucion();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo);
		model.addAttribute("titulo1","Formulario: Nuevo Registro");
		model.addAttribute("titulo2","Formulario: Editar Registro");
		model.addAttribute("registrodelspi",registrodelspi);
		model.addAttribute("listaactivo",listaactivo);
	    model.addAttribute("listaspi",listaspi);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("listatipo",listatipo);
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		return "/views/Consulta/RegistroDelSpi/registrosdelspi";	
	}
	
	//CREAR FORMULARIO REGISTRO
	@GetMapping("/create")
	public String crear(Model model) {
		RegistrodelSpi registrodelspi=new RegistrodelSpi();
		List<Activo> listaactivo=IActivoService.listaactivo();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		model.addAttribute("titulo","Formulario: Nuevo Registro");
		model.addAttribute("registrodelspi",registrodelspi);
		model.addAttribute("listaactivo",listaactivo);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("listainstitucion",listainstitucion);
		return "/views/Consulta/RegistroDelSpi/frmRegistro";
	}
	
	//EDITAR Y DETALLE
	@GetMapping("/spidetl/{idregistro}")
	public String Verdetalle(@PathVariable("idregistro") Long idregistro, Model model, RedirectAttributes attribute) { 
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		RegistrodelSpi registrodelspi = null;
	  
		if(idregistro>0) {
			registrodelspi= IRegistroDelSpiService.buscarPorId(idregistro);
		  
			if (registrodelspi==null) {
				attribute.addFlashAttribute("error","ATENCION: Este registro no existe");
				return "/views/Consulta/RegistroDelSpi/";
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el registro");
			return "/views/Consulta/RegistroDelSpi/";
		}
		model.addAttribute("titulo","Ver Detalle: " + registrodelspi.getIdactivo().getNombre()+ " del SPI "+registrodelspi.getIdspi().getNombre());
		model.addAttribute("titulo1","Formulario: Editar Registro");
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("registrodelspi", registrodelspi);
	  
		return "/views/Consulta/RegistroDelSpi/detalle"; 
	}
	
		
 
	@GetMapping("/editar/{idregistro}")
	public String editar(@PathVariable("idregistro") Long idregistro, Model model) {
		RegistrodelSpi registrodelspi = IRegistroDelSpiService.buscarPorId(idregistro);
		List<Activo> listaactivo=IActivoService.listaactivo();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		model.addAttribute("titulo","Formulario: Editar Registro");
		model.addAttribute("listaactivo",listaactivo);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("registrodelspi", registrodelspi);
		return "/views/Consulta/RegistroDelSpi/frmRegistro";
	} 

}
