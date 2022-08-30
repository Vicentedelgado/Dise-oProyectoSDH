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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdhdata.model.RRHH;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.model.Unidad;
import com.sdhdata.model.Modalidad;
import com.sdhdata.service.IRRHHService;
import com.sdhdata.service.IZonaService;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.IUnidadService;
import com.sdhdata.service.IModalidadService;

@Controller
@RequestMapping("/views/DataSpi/RRHH")
public class RRHHController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IUnidadService IUnidadService;
	@Autowired
	private IModalidadService IModalidadService;
	
	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@RequestMapping("/")
	public String listarRRHH(Model model,@ModelAttribute("idzona") Zona idzona) {
		List<RRHH> listarrhh=IRRHHService.listarrrhh();
		List<RRHH> listarrhh1=IRRHHService.listarrhhzona1();
		List<RRHH> listarrhh2=IRRHHService.listarrhhzona2();
		List<RRHH> listarrhh3=IRRHHService.listarrhhzona3();
		List<RRHH> listarrhh4=IRRHHService.listarrhhzona4();
		List<RRHH> listarrhh5=IRRHHService.listarrhhzona5();
		List<RRHH> listarrhh6=IRRHHService.listarrhhzona6();
		List<RRHH> listarrhh7=IRRHHService.listarrhhzona7();
		List<RRHH> listarrhh8=IRRHHService.listarrhhzona8();
		List<RRHH> listarrhh9=IRRHHService.listarrhhzona9();
		
		model.addAttribute("titulo","Lista del Recurso Humano de los SPI ");
		model.addAttribute("listarrhh",listarrhh);
		model.addAttribute("listarrhh1",listarrhh1);
		model.addAttribute("listarrhh2",listarrhh2);
		model.addAttribute("listarrhh3",listarrhh3);
		model.addAttribute("listarrhh4",listarrhh4);
		model.addAttribute("listarrhh5",listarrhh5);
		model.addAttribute("listarrhh6",listarrhh6);
		model.addAttribute("listarrhh7",listarrhh7);
		model.addAttribute("listarrhh8",listarrhh8);
		model.addAttribute("listarrhh9",listarrhh9);
		//CREAR FORMULARIO REGISTRO DE VENTANA MODAL rrhh.html
		Zona zona= new Zona();
		RRHH rrhh=new RRHH();
		List<Zona> listazona=IZonaService.listazona();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		List<Unidad> listaunidad=IUnidadService.listaunidad();
		List<Modalidad> listamodalidad=IModalidadService.listamodalidad();
		model.addAttribute("titulo1","Formulario: Nuevo Registro de funcionario");
		model.addAttribute("titulo2","Formulario: Editar Registro de funcionario");
		model.addAttribute("rrhh",rrhh);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("zona",zona);
		model.addAttribute("listaunidad",listaunidad);
		model.addAttribute("listamodalidad",listamodalidad);
		return "/views/DataSpi/RRHH/rrhh";	
	}
	
	//FILTRAR PARA IMPRIMIR RRHH POR ZONA
	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@RequestMapping(value="/listaporzona/{idzona}", method=RequestMethod.GET)
	public String listarRRHHPorZona(@PathVariable("idzona") Zona idzona, Model model) {
		List<RRHH> listazonarrhh=IRRHHService.Listaporzonarrhh(idzona);
		
		model.addAttribute("titulo","Lista del Recurso Humano de la Zona "+ idzona.getIdzona());
		model.addAttribute("titulo1","Zona "+ idzona.getIdzona());
		model.addAttribute("listazonarrhh",listazonarrhh);
		
		return "/views/DataSpi/RRHH/rrhhporzona";	
	}
	
	//FILTRAR PARA IMPRIMIR RRHH POR SPI 
	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@RequestMapping(value="/listaporspi/{idspi}", method=RequestMethod.GET)
	public String listarRRHHPorSpi(@PathVariable("idspi") SpiDatos idspi, Model model,@ModelAttribute("idzona") Zona idzona,RedirectAttributes alerta) {
		List<RRHH> listaspirrhh=IRRHHService.Listaporspirrhh(idspi);
		//Llenar select filtrar spi
		Zona zona= new Zona();
		RRHH rrhh=new RRHH();
		List<Zona> listazona=IZonaService.listazona();
		List<Unidad> listaunidad=IUnidadService.listaunidad();
		List<Modalidad> listamodalidad=IModalidadService.listamodalidad();
		List<SpiDatos> listaspi=ISpiDatosService.listaspidatos();
		
		if(listaspirrhh.size()==0) {
			List<RRHH> listarrhh=IRRHHService.listarrrhh();
			List<RRHH> listarrhh1=IRRHHService.listarrhhzona1();
			List<RRHH> listarrhh2=IRRHHService.listarrhhzona2();
			List<RRHH> listarrhh3=IRRHHService.listarrhhzona3();
			List<RRHH> listarrhh4=IRRHHService.listarrhhzona4();
			List<RRHH> listarrhh5=IRRHHService.listarrhhzona5();
			List<RRHH> listarrhh6=IRRHHService.listarrhhzona6();
			List<RRHH> listarrhh7=IRRHHService.listarrhhzona7();
			List<RRHH> listarrhh8=IRRHHService.listarrhhzona8();
			List<RRHH> listarrhh9=IRRHHService.listarrhhzona9();
			
			model.addAttribute("titulo","Lista del Recurso Humano de los SPI ");
			model.addAttribute("listarrhh",listarrhh);
			model.addAttribute("listarrhh1",listarrhh1);
			model.addAttribute("listarrhh2",listarrhh2);
			model.addAttribute("listarrhh3",listarrhh3);
			model.addAttribute("listarrhh4",listarrhh4);
			model.addAttribute("listarrhh5",listarrhh5);
			model.addAttribute("listarrhh6",listarrhh6);
			model.addAttribute("listarrhh7",listarrhh7);
			model.addAttribute("listarrhh8",listarrhh8);
			model.addAttribute("listarrhh9",listarrhh9);
			model.addAttribute("titulo1","Formulario: Nuevo Registro de funcionario");
			model.addAttribute("titulo2","Formulario: Editar Registro de funcionario");
			model.addAttribute("rrhh",rrhh);
			model.addAttribute("listazona",listazona);
			model.addAttribute("listaspi",listaspi);
			model.addAttribute("zona",zona);
			model.addAttribute("listaunidad",listaunidad);
			model.addAttribute("listamodalidad",listamodalidad);
			alerta.addFlashAttribute("info", "No existen fucionarios para este SPI");
			return"redirect:/views/DataSpi/RRHH/";
		}
		
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listaspi",listaspi);
		model.addAttribute("rrhh",rrhh);
		model.addAttribute("listaunidad",listaunidad);
		model.addAttribute("listamodalidad",listamodalidad);
		
		model.addAttribute("titulo","Lista del Recurso Humano del SPI "+ idspi.getNombre());
		model.addAttribute("titulo1","RRHH del SPI "+ idspi.getNombre()+" "+idspi.getIdzona().getNombre());
		model.addAttribute("titulo2","Formulario: Nuevo Registro de funcionario");
		model.addAttribute("titulo3","Formulario: Editar Registro de funcionario");
		model.addAttribute("listaspirrhh",listaspirrhh);
		
		return "/views/DataSpi/RRHH/rrhhporspi";	
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute RRHH rrhh, BindingResult result, RedirectAttributes alerta) {
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO RRHH");
			return "views/DataSpi/RRHH/rrhh";
		}
		IRRHHService.guardar(rrhh);
		System.out.print("REGISTRO RRHH GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO RRHH GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/RRHH/";
	}
	
	//GUARDAR
	@Secured("ROLE_ADMIN")
	@PostMapping("listaporspi/save")
	public String guardarporspi(@Valid @ModelAttribute RRHH rrhh, BindingResult result, RedirectAttributes alerta) {
		Long spi = rrhh.getIdspi().getIdspi();
		
		if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO RRHH");
			return "views/DataSpi/RRHH/rrhh";
		}
		IRRHHService.guardar(rrhh);
		System.out.print("REGISTRO RRHH GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO RRHH GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/RRHH/listaporspi/"+spi;
	}
	
	//EDITAR MODAL
	@Secured("ROLE_ADMIN")
	@GetMapping("/edit")
	@ResponseBody
	public RRHH editar(Long idusuario) {
		return IRRHHService.buscarPorId(idusuario);
	}
	
	//EDITAR MODAL
	@Secured("ROLE_ADMIN")
	@GetMapping("listaporspi/edit")
	@ResponseBody
	public RRHH editarporspi(Long idusuario) {
		return IRRHHService.buscarPorId(idusuario);
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
	@Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}
	

}
