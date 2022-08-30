package com.sdhdata.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdhdata.model.Institucion;
import com.sdhdata.model.Zona;
import com.sdhdata.model.Activo;
import com.sdhdata.model.Tipo;
import com.sdhdata.model.Modalidad;
import com.sdhdata.model.Unidad;
import com.sdhdata.service.IInstitucionService;
import com.sdhdata.service.IZonaService;
import com.sdhdata.service.IActivoService;
import com.sdhdata.service.ITipoService;
import com.sdhdata.service.IUnidadService;
import com.sdhdata.service.IModalidadService;


@Controller
@RequestMapping("/views/DataSpi/Admin")
public class AdminController {
	
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IInstitucionService IInstitucionService;
	@Autowired
	private IActivoService IActivoService;
	@Autowired
	private ITipoService ITipoService;
	@Autowired
	private IUnidadService IUnidadService;
	@Autowired
	private IModalidadService IModalidadService;
	
	@GetMapping("/")
	public String AdminPage (Model model) {
		List<Zona> listazonas = IZonaService.listazona();
		List<Institucion> listainstituciones = IInstitucionService.listainstitucion();		
		List<Activo> listaactivos = IActivoService.listaactivo();
		List<Tipo> listatipos = ITipoService.listatipos();
		List<Unidad> listaunidades = IUnidadService.listaunidad();
		List<Modalidad> listamodalidades = IModalidadService.listamodalidad();
		//CREAR FORMULARIOS
		Zona zona = new Zona();
		Institucion institucion = new Institucion();
		Tipo tipo= new Tipo();
		Unidad unidad=new Unidad();
		Activo activo=new Activo();
		Modalidad modalidad=new Modalidad();
		//VENTANA
		model.addAttribute("titulo","Página: Admin de SDH");
		model.addAttribute("titulo1","Zonas");
		model.addAttribute("listazonas",listazonas);
		model.addAttribute("listainstituciones",listainstituciones);
		model.addAttribute("listaactivos",listaactivos);
		model.addAttribute("listatipos",listatipos);
		model.addAttribute("listaunidades",listaunidades);
		model.addAttribute("listamodalidades",listamodalidades);
		model.addAttribute("zona",zona);
		model.addAttribute("institucion",institucion);
		model.addAttribute("tipo",tipo);
		model.addAttribute("unidad",unidad);
		model.addAttribute("activo",activo);
		model.addAttribute("modalidad",modalidad);
		return "/views/DataSpi/Admin/admin";
	}
	
	@GetMapping("/zonas")
	public String AdminPagezonas (Model model) {
		List<Zona> listazonas = IZonaService.listazona();
		//CREAR FORMULARIOS
		Zona zona = new Zona();
		//VENTANA
		model.addAttribute("titulo","Página: Zonas de la SDH");
		model.addAttribute("listazonas",listazonas);
		model.addAttribute("zona",zona);
		return "/views/DataSpi/Admin/zona";
	}
	
	@GetMapping("/instituciones")
	public String AdminPageinstituciones (Model model) {
		List<Institucion> listainstituciones = IInstitucionService.listainstitucion();	
		//CREAR FORMULARIOS
		Institucion institucion = new Institucion();
		//VENTANA
		model.addAttribute("titulo","Página: Instituciones de la SDH");
		model.addAttribute("listainstituciones",listainstituciones);
		model.addAttribute("institucion",institucion);
		return "/views/DataSpi/Admin/institucion";
	}
	
	@GetMapping("/activos")
	public String AdminPageactivos (Model model) {		
		List<Activo> listaactivos = IActivoService.listaactivo();
		List<Tipo> listatipos = ITipoService.listatipos();
		//CREAR FORMULARIOS
		Activo activo=new Activo();
		//VENTANA
		model.addAttribute("titulo","Página: Bienes/Servicios de SDH");
		model.addAttribute("titulo1","Zonas");
		model.addAttribute("listaactivos",listaactivos);
		model.addAttribute("listatipos",listatipos);
		model.addAttribute("activo",activo);
		return "/views/DataSpi/Admin/activo";
	}
	
	@GetMapping("/tipos")
	public String AdminPagetipos (Model model) {
		
		List<Tipo> listatipos = ITipoService.listatipos();
		
		//CREAR FORMULARIOS
		
		Tipo tipo= new Tipo();
		
		//VENTANA
		model.addAttribute("titulo","Página: tipos de SDH");
		model.addAttribute("titulo1","Zonas");
		model.addAttribute("listatipos",listatipos);
		model.addAttribute("tipo",tipo);
		return "/views/DataSpi/Admin/tipo";
	}
	
	//EDITAR MODAL Zona
	@Secured("ROLE_ADMIN")
	@GetMapping("/editzona")
	@ResponseBody
	public Zona editarzona(Long idzona) {
		return IZonaService.buscarPorId(idzona);
	}
	
	//EDITAR MODAL Institucion
	@Secured("ROLE_ADMIN")
	@GetMapping("/editinstitucion")
	@ResponseBody
	public Institucion editarinstitucion(Long idinstitucion) {
		return IInstitucionService.buscarPorId(idinstitucion);
	}
	
	//EDITAR MODAL Activo
	@Secured("ROLE_ADMIN")
	@GetMapping("/editactivo")
	@ResponseBody
	public Activo editaractivo(Long idactivo) {
		return IActivoService.buscarPorId(idactivo);
	}
	
	//EDITAR MODAL Tipo
	@Secured("ROLE_ADMIN")
	@GetMapping("/edittipo")
	@ResponseBody
	public Tipo editartipo(Long idtipo) {
		return ITipoService.buscarporId(idtipo);
	}
	
	//EDITAR MODAL Unidad
	@Secured("ROLE_ADMIN")
	@GetMapping("/editunidad")
	@ResponseBody
	public Unidad editarunidad(Long idunidad) {
		return IUnidadService.buscarporId(idunidad);
	}
	
	//EDITAR MODAL Modalidad
	@Secured("ROLE_ADMIN")
	@GetMapping("/editmodalidad")
	@ResponseBody
	public Modalidad editarmodalidad(Long idmodalidad) {
		return IModalidadService.buscarporId(idmodalidad);
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/savezona")
	public String guardarzona(@Valid @ModelAttribute Zona zona, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO ZONA");
			return "/views/DataSpi/Admin/zona";
		}
		IZonaService.guardar(zona);
		System.out.print("REGISTRO ZONA GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ZONA GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/zonas";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveinstitucion")
	public String guardarinstitucion(@Valid @ModelAttribute Institucion institucion, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO INSTITUCION");
			return "/views/DataSpi/Admin/institucion";
		}
		IInstitucionService.guardar(institucion);
		System.out.print("REGISTRO INSTITUCIÓN GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO INSTITUCIÓN GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/instituciones";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveactivo")
	public String guardaractivo(@Valid @ModelAttribute Activo activo, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO ACTIVO");
			return "/views/DataSpi/Admin/activo";
		}
		IActivoService.guardar(activo);
		System.out.print("REGISTRO INSTITUCIÓN GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ACTIVO GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/activos";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/savetipo")
	public String guardaritipo(@Valid @ModelAttribute Tipo tipo, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO TIPO");
			return "/views/DataSpi/Admin/admin";
		}
		ITipoService.guardar(tipo);
		System.out.print("REGISTRO TIPO GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO TIPO GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/saveunidad")
	public String guardarunidad(@Valid @ModelAttribute Unidad unidad, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO UNIDAD");
			return "/views/DataSpi/Admin/admin";
		}
		IUnidadService.guardar(unidad);
		System.out.print("REGISTRO UNIDAD GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO UNIDAD GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/savemodalidad")
	public String guardarmodalidad(@Valid @ModelAttribute Modalidad modalidad, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO MODALIDAD");
			return "/views/DataSpi/Admin/admin";
		}
		IModalidadService.guardar(modalidad);
		System.out.print("REGISTRO MODALIDAD GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO MODALIDAD GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}
	
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletezona/{idzona}")
	public String deletezona(@PathVariable("idzona") Long idzona, RedirectAttributes alerta) {
		
		IZonaService.eliminar(idzona);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/zonas";
	}
	
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteinstitucion/{idinstitucion}")
	public String deleteinstitucion(@PathVariable("idinstitucion") Long idinstitucion, RedirectAttributes alerta) {
		
		
		IInstitucionService.eliminar(idinstitucion);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/instituciones";
	}
	
	//Eliminar
	@GetMapping("/deleteactivo/{idactivo}")
	public String deleteactivo(@PathVariable("idactivo") Long idactivo, RedirectAttributes alerta) {
		
		
		IActivoService.eliminar(idactivo);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/activos";
	}
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletetipo/{idtipo}")
	public String deletetipo(@PathVariable("idtipo") Long idtipo, RedirectAttributes alerta) {
		
		
		ITipoService.eliminar(idtipo);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}

	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletemodalidad/{idmodalidad}")
	public String deletemoddalidad(@PathVariable("idmodalidad") Long idmodalidad, RedirectAttributes alerta) {
		
		
		IModalidadService.eliminar(idmodalidad);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}
	
	//Eliminar
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteunidad/{idunidad}")
	public String deleteunidad(@PathVariable("idunidad") Long idunidad, RedirectAttributes alerta) {
		
		
		IUnidadService.eliminar(idunidad);
		System.out.print("REGISTRO ELIMINADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO ELIMINADO CON ÉXITO");
		return "redirect:/views/DataSpi/Admin/";
	}


}
