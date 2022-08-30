package com.sdhdata.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.IZonaService;

@Controller
@RequestMapping("/dataspi_consulta")
public class HomeConsulta {
	
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private ISpiDatosService ISpiDatosService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model, @ModelAttribute("idzona") Zona idzona) {
		Zona zona= new Zona();
		List<Zona> listaZona=IZonaService.listazona();
		model.addAttribute("zona",zona);
		model.addAttribute("listazona",listaZona);
		return "spiconsulta";
	}
	
	//ELEGIR SPI POR ZONA (FILTRAR)
	@RequestMapping(value="/Elegirspi",method = RequestMethod.GET)
	public @ResponseBody List<SpiDatos> BuscarporZona(@RequestParam(value ="idzona", required = true) Zona idzona){
		return ISpiDatosService.FindByZona(idzona); 
	}

}
