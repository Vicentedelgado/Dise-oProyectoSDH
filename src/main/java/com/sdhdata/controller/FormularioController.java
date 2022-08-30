package com.sdhdata.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdhdata.model.Activo;
import com.sdhdata.model.Institucion;
import com.sdhdata.model.Modalidad;
import com.sdhdata.model.RRHH;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Tipo;
import com.sdhdata.model.Unidad;
import com.sdhdata.model.Zona;
import com.sdhdata.service.IActivoService;
import com.sdhdata.service.IInstitucionService;
import com.sdhdata.service.IModalidadService;
import com.sdhdata.service.IRRHHService;
import com.sdhdata.service.IRegistroDelSpiService;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.IZonaService;
import com.sdhdata.service.ITipoService;
import com.sdhdata.service.IUnidadService;

@Controller
@RequestMapping("/views/DataSpi/Formulario")
public class FormularioController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IRegistroDelSpiService IRegistroDelSpiService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IActivoService IActivoService;
	@Autowired
	private IInstitucionService IInstitucionService;
	@Autowired
	private ITipoService ITipoService;
	@Autowired
	private IUnidadService IUnidadService;
	@Autowired
	private IModalidadService IModalidadService;
	
	//RUTAS GUARDAR ARCHIVOS
	  //DESARROLLO
	  	private String RutaGuardarArchivos = "C://DATASDH//DATASPI//VerificableBienes";
	  //SERVIDOR
		//private String RutaGuardarArchivos = "/opt//DATASDH//DATASPI//VerificableBienes";
	//////////////////////
  	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String inicio(Model model, @ModelAttribute("idzona") Zona idzona, @ModelAttribute("idspi") SpiDatos idspi, @ModelAttribute("idtipo") Tipo idtipo) {
		//títulos cards
		model.addAttribute("titulo","Coordinación General Administrativa Financiera");
		model.addAttribute("titulo1","DATOS GENERALES");
		model.addAttribute("titulo2","RECURSO HUMANO");
		model.addAttribute("titulo3","CARACTERÍSTICAS DEL INMUEBLE");
		model.addAttribute("titulo4","REGISTRO DE BIENES");
		model.addAttribute("titulo5","CONECTIVIDAD");
		model.addAttribute("titulo6","RELACIONAMIENTO CON ACTORES");
		model.addAttribute("titulo7","------");
		model.addAttribute("titulo8","BÚSQUEDA");
		model.addAttribute("titulo9","Formulario: Editar Registro");
		model.addAttribute("titulo10","Formulario: Nuevo Registro");
		model.addAttribute("titulo11","Formulario: Agregar Nuevo Bien/Servicio a la lista ");
		model.addAttribute("titulo12","Formulario: Agregar Institución a la lista");
		model.addAttribute("titulo13","Formulario: Editar Registro RRHH");
		model.addAttribute("titulo14","Formulario: Nuevo Registro RRHH");
		//Llenar select filtrar spi
		Zona zona= new Zona();
		List<Zona> listazona=IZonaService.listazona();
		List<Unidad> listaunidad=IUnidadService.listaunidad();
		List<Modalidad> listamodalidad=IModalidadService.listamodalidad();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaunidad",listaunidad);
		model.addAttribute("listamodalidad",listamodalidad);
		//Objeto Registo del Spi
		RegistrodelSpi registrodelspi=new RegistrodelSpi(); 
		RRHH rrhh=new RRHH();
		model.addAttribute("registrodelspi",registrodelspi);
		model.addAttribute("rrhh",rrhh);
		//Llenar modal Editar y guardar
		Tipo tipo= new Tipo();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo); 
		model.addAttribute("listatipo",listatipo);
		//Llenar modal guardar activo
		Activo Activo= new Activo();
		model.addAttribute("Activo",Activo);
		//Llenar modal guardar institucion
		Institucion Institucion= new Institucion();
		model.addAttribute("Institucion",Institucion);
		
		return "/views/DataSpi/Formulario/formulario";	
	}
	
	//LLENAR FORMULARIO
  	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@RequestMapping(value="/listaporspi/{idspi}", method=RequestMethod.GET)
	public String Listaporspi(@PathVariable("idspi") Long idspi,@PathVariable("idspi") SpiDatos idspi1, Model model, @ModelAttribute("idzona") Zona idzona, @ModelAttribute("idtipo") Tipo idtipo){
		//títulos cards
		model.addAttribute("titulo","Coordinación General Administrativa Financiera");
		model.addAttribute("titulo1","DATOS GENERALES");
		model.addAttribute("titulo2","RECURSO HUMANO");
		model.addAttribute("titulo3","CARACTERÍSTICAS DEL INMUEBLE");
		model.addAttribute("titulo4","REGISTRO DE BIENES");
		model.addAttribute("titulo5","CONECTIVIDAD");
		model.addAttribute("titulo6","RELACIONAMIENTO CON ACTORES");
		model.addAttribute("titulo7","------");
		model.addAttribute("titulo8","BÚSQUEDA");
		model.addAttribute("titulo9","Formulario: Editar Registro");
		model.addAttribute("titulo10","Formulario: Nuevo Registro");
		model.addAttribute("titulo11","Formulario: Agregar Nuevo Bien/Servicio a la lista ");
		model.addAttribute("titulo12","Formulario: Agregar Institución a la lista");
		model.addAttribute("titulo13","Formulario: Editar Registro RRHH");
		model.addAttribute("titulo14","Formulario: Nuevo Registro RRHH");
		//Objeto Registo del Spi
		RegistrodelSpi registrodelspi=new RegistrodelSpi(); 
		RRHH rrhh=new RRHH();
		model.addAttribute("registrodelspi",registrodelspi);
		model.addAttribute("rrhh",rrhh);
		//Llenar select filtrar spi
		Zona zona= new Zona();
		List<Zona> listazona=IZonaService.listazona();
		List<Unidad> listaunidad=IUnidadService.listaunidad();
		List<Modalidad> listamodalidad=IModalidadService.listamodalidad();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaunidad",listaunidad);
		model.addAttribute("listamodalidad",listamodalidad);
		//Llenar modal Editar y guardar
		Tipo tipo= new Tipo();
		List<Institucion>listainstitucion=IInstitucionService.listainstitucion();
		List<Tipo>listatipo= ITipoService.listatipos();
		model.addAttribute("tipo",tipo);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("listatipo",listatipo);
		//Llenar modal guardar activo
		Activo Activo= new Activo();
		model.addAttribute("Activo",Activo);
		//Llenar modal guardar institucion
		Institucion Institucion= new Institucion();
		model.addAttribute("Institucion",Institucion);
		//Tabla llenado de SpiDatos
		List<SpiDatos> listaspi1=ISpiDatosService.Listaporspi(idspi);
		model.addAttribute("listaspi1",listaspi1);
		//Tabla llenado de RRHH
		List<RRHH> listarrhh=IRRHHService.ListaporspirrhhFor(idspi1);
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
		
		return "/views/DataSpi/Formulario/formulario";
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
  	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}
	
	//ELEGIR ACTIVO POR TIPO (FILTRAR)
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/Elegiractivo",method = RequestMethod.GET)
	public @ResponseBody List<Activo> BuscarporTipo(@RequestParam(value ="idtipo", required = true) Tipo idtipo){
		return IActivoService.Buscarportipo(idtipo); 
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("listaporspi/save")
	public String guardar(@Valid @ModelAttribute RegistrodelSpi registrodelspi, BindingResult result, Model model,
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		Calendar fecha = Calendar.getInstance();
	    int año = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH) + 1;
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
        Long spi=registrodelspi.getIdspi().getIdspi();
		
		if(result.hasErrors()) {
			System.out.print("Errores en el formulario por favor revice los campos");
			return "redirect:/views/DataSpi/Formulario/listaporspi/" +spi;
		}
		
		if(!archivo.isEmpty()) {
			//DESARROLLO
			//String rutaAbsoluta="C://DATASDH//DATASPI//VerificableBienes";
			//SERVIDOR
			String rutaAbsoluta=RutaGuardarArchivos;
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" +"VrfRegSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				registrodelspi.setArchivo("VrfRegSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		IRegistroDelSpiService.guardar(registrodelspi);
		System.out.print("REGISTRO GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO GUARDADO CON ÉXITO");
		
		return "redirect:/views/DataSpi/Formulario/listaporspi/" + spi;
	}
	
	//GUARDAR EDITAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveedit")
	public String guardaredit(@Valid @ModelAttribute("registrodelspi") RegistrodelSpi registrodelspi, BindingResult result, Model model, 
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		Calendar fecha = Calendar.getInstance();
	    int año = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH) + 1;
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
		List<Activo> listaactivo=IActivoService.listaactivo();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Ver Detalle: " + registrodelspi.getIdactivo().getNombre()+ " del SPI "+registrodelspi.getIdspi().getNombre());
			model.addAttribute("titulo1","Formulario: Editar Registro");
			model.addAttribute("registrodelspi",registrodelspi);
			model.addAttribute("listaactivo",listaactivo);
			model.addAttribute("listaspi",listaspi);
			model.addAttribute("listainstitucion",listainstitucion);
			System.out.print("Errores en el formulario por favor revice los campos");
			return "/views/DataSpi/Formulario/detalle";
		}
		
		if(!archivo.isEmpty()) {
			//DESARROLLO
			//String rutaAbsoluta="C://DATASDH//DATASPI//VerificableBienes";
			//SERVIDOR
	        String rutaAbsoluta=RutaGuardarArchivos;
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" +"VrfRegSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				registrodelspi.setArchivo("VrfRegSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		IRegistroDelSpiService.guardar(registrodelspi);
		System.out.print("REGISTRO EDITADO CON EXITO");
		alerta.addFlashAttribute("success", "REGISTRO EDITADO CON ÉXITO");
		return "redirect:/views/DataSpi/Formulario/spidetl/" + registrodelspi.getIdregistro();
	}
	
	//GUARDAR RRHH
	@Secured("ROLE_ADMIN")
	@PostMapping("/listaporspi/saverrhh")
	public String guardarrrhh(@Valid @ModelAttribute RRHH rrhh, BindingResult result, RedirectAttributes alerta) {
		Long spi=rrhh.getIdspi().getIdspi();
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO RRHH");
			return "views/DataSpi/RRHH/rrhh";
		}
		IRRHHService.guardar(rrhh);
		System.out.print("REGISTRO RRHH GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO RRHH GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Formulario/listaporspi/" + spi;
	}
	
	//EDITAR MODAL
	@Secured("ROLE_ADMIN")
	@GetMapping("listaporspi/edit/")
	@ResponseBody
	public RegistrodelSpi editar( Long idregistro) {
		
		RegistrodelSpi registrodelspi = IRegistroDelSpiService.buscarPorId(idregistro);
			
		return registrodelspi;
	}
	
	//EDITAR MODAL RRHH
	@Secured("ROLE_ADMIN")
	@GetMapping("listaporspi/editrrhh")
	@ResponseBody
	public RRHH editarrrhh(Long idusuario) {
		return IRRHHService.buscarPorId(idusuario);
	}
	
	//EDITAR Y DETALLE
	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@GetMapping("/spidetl/{idregistro}")
	public String Verdetalle(@PathVariable("idregistro") Long idregistro, Model model, RedirectAttributes attribute) { 
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		RegistrodelSpi registrodelspi1=IRegistroDelSpiService.buscarPorId(idregistro);
		RegistrodelSpi registrodelspi = null;
	  
		if(idregistro>0) {
			registrodelspi= IRegistroDelSpiService.buscarPorId(idregistro);
		  
			if (registrodelspi==null) {
				attribute.addFlashAttribute("error","ATENCION: Este registro no existe");
				return "redirect:/views/DataSpi/Formulario/listaporspi/" + registrodelspi1.getIdspi().getIdspi();
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el registro");
			return "redirect:/views/DataSpi/Formulario/listaporspi/" + registrodelspi1.getIdspi().getIdspi();
		}
		model.addAttribute("titulo","Ver Detalle: " + registrodelspi.getIdactivo().getNombre()+ " del SPI "+registrodelspi.getIdspi().getNombre());
		model.addAttribute("titulo1","Formulario: Editar Registro");
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("registrodelspi", registrodelspi);
	  
		return "/views/DataSpi/Formulario/detalle"; 
	}
	
	//GUARDAR ACTIVO
	@Secured("ROLE_ADMIN")
	@PostMapping("listaporspi/saveactivo")
	public String guardaractivo(@Valid @ModelAttribute RegistrodelSpi registrodelspi,@ModelAttribute Activo Activo, BindingResult result,
			RedirectAttributes alerta) {
		
        Long spi=registrodelspi.getIdspi().getIdspi();
		
		if(result.hasErrors()) {
			System.out.print("Errores en el formulario por favor revice los campos");
			return "redirect:/views/DataSpi/Formulario/listaporspi/" +spi;
		}
		
		IActivoService.guardar(Activo);
		System.out.print("NUEVO BIEN/SERVICIO AGREGADO CON ÉXITO");
		alerta.addFlashAttribute("success", "NUEVO BIEN/SERVICIO AGREGADO CON ÉXITO");
		
		return "redirect:/views/DataSpi/Formulario/listaporspi/" + spi;
	}
	
	//GUARDAR INSTITUCION
	@Secured("ROLE_ADMIN")
	@PostMapping("listaporspi/saveinstitucion")
	public String guardarinstitucion(@Valid @ModelAttribute RegistrodelSpi registrodelspi,@ModelAttribute Institucion Institucion, BindingResult result,
			RedirectAttributes alerta) {
		
        Long spi=registrodelspi.getIdspi().getIdspi();
		
		if(result.hasErrors()) {
			System.out.print("Errores en el formulario por favor revice los campos");
			return "redirect:/views/DataSpi/Formulario/listaporspi/" +spi;
		}
		
		IInstitucionService.guardar(Institucion);
		System.out.print("INSTITUCIÓN AGREGADA CON ÉXITO");
		alerta.addFlashAttribute("success", "INSTITUCIÓN AGREGADA CON ÉXITO");
		
		return "redirect:/views/DataSpi/Formulario/listaporspi/" + spi;
	}
			

}
