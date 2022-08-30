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

import com.sdhdata.model.RRHH;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.service.IRRHHService;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.IZonaService;

@Controller
@RequestMapping("/views/Consulta/RRHH")
public class RRHHConsultaController {
	
	@Autowired
	private IRRHHService IRRHHService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	
	@GetMapping("/")
	public String listarCantones(Model model,@ModelAttribute("idzona") Zona idzona) {
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
		Zona zona= new Zona();
		List<Zona> listazona=IZonaService.listazona();
		
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
		
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listazona);
		
		return "/views/Consulta/RRHH/rrhh";	
	}
	
	//FILTRAR PARA IMPRIMIR RRHH POR ZONA 
		@RequestMapping(value="/listaporzona/{idzona}", method=RequestMethod.GET)
		public String listarRRHHPorZona(@PathVariable("idzona") Zona idzona, Model model) {
			List<RRHH> listazonarrhh=IRRHHService.Listaporzonarrhh(idzona);
			
			model.addAttribute("titulo","Lista del Recurso Humano de la Zona "+ idzona.getIdzona());
			model.addAttribute("titulo1","Zona "+ idzona.getIdzona());
			model.addAttribute("listazonarrhh",listazonarrhh);
			
			return "/views/Consulta/RRHH/rrhhporzona";	
		}
		
		//FILTRAR PARA IMPRIMIR RRHH POR SPI 
		@RequestMapping(value="/listaporspi/{idspi}", method=RequestMethod.GET)
		public String listarRRHHPorSpi(@PathVariable("idspi") SpiDatos idspi, Model model,@ModelAttribute("idzona") Zona idzona,RedirectAttributes alerta) {
			List<RRHH> listaspirrhh=IRRHHService.Listaporspirrhh(idspi);
			//Llenar select filtrar spi
			Zona zona= new Zona();
			List<Zona> listazona=IZonaService.listazona();
			
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
				
				model.addAttribute("zona",zona);
				model.addAttribute("listazona",listazona);
			
				alerta.addFlashAttribute("info", "No existen fucionarios para este SPI");
				return"redirect:/views/Consulta/RRHH/";
			}
			
			
			model.addAttribute("zona",zona);
			model.addAttribute("listazona",listazona);
			model.addAttribute("titulo","Lista del Recurso Humano del SPI "+ idspi.getNombre());
			model.addAttribute("titulo1","RRHH del SPI "+ idspi.getNombre()+" "+idspi.getIdzona().getNombre());
			model.addAttribute("listaspirrhh",listaspirrhh);
			
			return "/views/Consulta/RRHH/rrhhporspi";	
		}
		
		//FILTRAR PARA IMPRIMIR RRHH POR SPI 
		@RequestMapping(value="/filtrarporspi", method=RequestMethod.GET)
		public String FiltrarRRHHPorSpi(Model model,@ModelAttribute("idzona") Zona idzona, @ModelAttribute("idspi") SpiDatos idspi) {
			List<RRHH> listaspirrhh=IRRHHService.listarrrhh();
			model.addAttribute("listaspirrhh",listaspirrhh);
			//Llenar select filtrar spi
			Zona zona= new Zona();
			List<Zona> listazona=IZonaService.listazona();
			model.addAttribute("zona",zona);
			model.addAttribute("listazona",listazona);
			
			model.addAttribute("titulo","Lista del Recurso Humano de los SPI");
			model.addAttribute("titulo1","RRHH de los SPI ");
			
			return "/views/Consulta/RRHH/rrhhporspi";	
		}
		
		//ELEGIR SPI POR ZONA (FILTRAR)
		@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
		public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
			return ISpiDatosService.FindByZona(idzona); 
		}



}
