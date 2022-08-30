package com.sdhdata.consulta;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdhdata.model.Institucion;
import com.sdhdata.model.RRHH;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Tipo;
import com.sdhdata.model.Zona;
import com.sdhdata.service.IInstitucionService;
import com.sdhdata.service.IRRHHService;
import com.sdhdata.service.IRegistroDelSpiService;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.ITipoService;
import com.sdhdata.service.IZonaService;

@Controller
@RequestMapping("/views/Consulta/Formulario")
public class FormularioConsultaController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IRegistroDelSpiService IRegistroDelSpiService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IInstitucionService IInstitucionService;
	@Autowired
	private ITipoService ITipoService; 
		
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String inicio(Model model, @ModelAttribute("idzona") Zona idzona, @ModelAttribute("idspi") SpiDatos idspi, @ModelAttribute("idtipo") Tipo idtipo) {
		//títulos cards
		model.addAttribute("titulo","Modelo de Gestión Administrativa SPI");
		model.addAttribute("titulo1","DATOS GENERALES");
		model.addAttribute("titulo2","RECURSO HUMANO");
		model.addAttribute("titulo3","CARACTERÍSTICAS DEL INMUEBLE");
		model.addAttribute("titulo4","REGISTRO DE BIENES");
		model.addAttribute("titulo5","CONECTIVIDAD");
		model.addAttribute("titulo6","RELACIONAMIENTO CON ACTORES");
		model.addAttribute("titulo7","-----");
		model.addAttribute("titulo8","BÚSQUEDA");
		model.addAttribute("titulo9","Formulario: Editar Registro");
		model.addAttribute("titulo10","Formulario: Nuevo Registro");
		//Llenar select filtrar spi
		Zona zona= new Zona();
		List<Zona> listazona=IZonaService.listazona();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		//Objeto Registo del Spi
		RegistrodelSpi registrodelspi=new RegistrodelSpi(); 
		model.addAttribute("registrodelspi",registrodelspi);
		//Llenar modal Editar y guardar
		Tipo tipo= new Tipo();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo); 
		model.addAttribute("listatipo",listatipo);
		
		return "/views/Consulta/Formulario/formulario";	
	}
	
	//LLENAR FORMULARIO
	@RequestMapping(value="/listaporspi/{idspi}", method=RequestMethod.GET)
	public String Listaporspi(@PathVariable("idspi") Long idspi,@PathVariable("idspi") SpiDatos idspi1, Model model, @ModelAttribute("idzona") Zona idzona, @ModelAttribute("idtipo") Tipo idtipo){
		//títulos cards
		model.addAttribute("titulo","Modelo de Gestión Administrativa SPI");
		model.addAttribute("titulo1","DATOS GENERALES");
		model.addAttribute("titulo2","RECURSO HUMANO");
		model.addAttribute("titulo3","CARACTERÍSTICAS DEL INMUEBLE");
		model.addAttribute("titulo4","REGISTRO DE BIENES");
		model.addAttribute("titulo5","CONECTIVIDAD");
		model.addAttribute("titulo6","RELACIONAMIENTO CON ACTORES");
		model.addAttribute("titulo7","-----");
		model.addAttribute("titulo8","BÚSQUEDA");
		model.addAttribute("titulo9","Formulario: Editar Registro");
		model.addAttribute("titulo10","Formulario: Nuevo Registro");
		//Objeto Registo del Spi
		RegistrodelSpi registrodelspi=new RegistrodelSpi(); 
		model.addAttribute("registrodelspi",registrodelspi);
		//Llenar select filtrar spi
		Zona zona= new Zona();
		List<Zona> listazona=IZonaService.listazona();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		//Llenar modal Editar y guardar
		Tipo tipo= new Tipo();
		List<Institucion>listainstitucion=IInstitucionService.listainstitucion();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("listatipo",listatipo);
		//Tabla llenado de SpiDatos
		List<SpiDatos> listaspi1=ISpiDatosService.Listaporspi(idspi);
		model.addAttribute("listaspi1",listaspi1);
		//Tabla llenado de RRHH
		List<RRHH> listarrhh=IRRHHService.Listaporspirrhh(idspi1);
		model.addAttribute("listarrhh",listarrhh);
		//Tabla llenado de Registro del spi instalaciones
		List<RegistrodelSpi> listaregistrodelspiinstalaciones=IRegistroDelSpiService.Listaregistrodelspiinstalaciones(idspi1);
		model.addAttribute("listaregistrodelspiinstalaciones",listaregistrodelspiinstalaciones);
		//Tabla llenado de Registro del spi bienes
		List<RegistrodelSpi> listaregistrodelspibienes=IRegistroDelSpiService.Listaregistrodelspibienes(idspi1);
		model.addAttribute("listaregistrodelspibienes",listaregistrodelspibienes);
		//Tabla llenado de Registro del spi equipos
		List<RegistrodelSpi> listaregistrodelspiequipos=IRegistroDelSpiService.Listaregistrodelspiequipos(idspi1);
		model.addAttribute("listaregistrodelspiequipos",listaregistrodelspiequipos);
		//Tabla llenado de Registro del spi otros
		List<RegistrodelSpi> listaregistrodelspiotros=IRegistroDelSpiService.Listaregistrodelspiotros(idspi1);
		model.addAttribute("listaregistrodelspiotros",listaregistrodelspiotros);
		//Tabla llenado de Registro del spi movilidad
		List<RegistrodelSpi> listaregistrodelspimovilidad=IRegistroDelSpiService.Listaregistrodelspimovilidad(idspi1);
		model.addAttribute("listaregistrodelspimovilidad",listaregistrodelspimovilidad);
		//Tabla llenado de Registro del spi conectividad
		List<RegistrodelSpi> listaregistrodelspiconectividad=IRegistroDelSpiService.Listaregistrodelspiconectividad(idspi1);
		model.addAttribute("listaregistrodelspiconectividad",listaregistrodelspiconectividad);
		
		return "/views/Consulta/Formulario/formulario";
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}
	
	//EDITAR Y DETALLE
	@GetMapping("/spidetl/{idregistro}")
	public String Verdetalle(@PathVariable("idregistro") Long idregistro, Model model, RedirectAttributes attribute) { 
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		RegistrodelSpi registrodelspi1=IRegistroDelSpiService.buscarPorId(idregistro);
		RegistrodelSpi registrodelspi = null;
	  
		if(idregistro>0) {
			registrodelspi= IRegistroDelSpiService.buscarPorId(idregistro);
		  
			if (registrodelspi==null) {
				attribute.addFlashAttribute("error","ATENCION: Este registro no existe");
				return "redirect:/views/Consulta/Formulario/listaporspi/" + registrodelspi1.getIdspi().getIdspi();
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el registro");
			return "redirect:/views/Consulta/Formulario/listaporspi/" + registrodelspi1.getIdspi().getIdspi();
		}
		model.addAttribute("titulo","Ver Detalle: " + registrodelspi.getIdactivo().getNombre()+ " del SPI "+registrodelspi.getIdspi().getNombre());
		model.addAttribute("titulo1","Formulario: Editar Registro");
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("registrodelspi", registrodelspi);
	  
		return "/views/Consulta/Formulario/detalle"; 
	}
	

}
