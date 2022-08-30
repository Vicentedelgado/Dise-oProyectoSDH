package com.sdhdata.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sdhdata.model.Institucion;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.service.IInstitucionService;
import com.sdhdata.service.ISpiDatosService;
import com.sdhdata.service.IZonaService;

@Controller
@RequestMapping("/views/DataSpi/SpiDatos")
public class SpiDatosController {
	
	@Autowired
	private ISpiDatosService ISpiDatosService;
	@Autowired
	private IZonaService IZonaService;
	@Autowired
	private IInstitucionService IInstitucionService;
	
	//RUTAS GUARDAR ARCHIVOS
	  //DESARROLLO
	    private String RutaGuardarArchivos = "C://DATASDH//DATASPI//VerificableSPI";
	  //SERVIDOR
		//private String RutaGuardarArchivos = "/opt//DATASDH//DATASPI//VerificableSPI";
	//////////////////////
	
    @Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
    @GetMapping("/")
	public String listarSpiDatos(Model model) {
		List<SpiDatos> listaspidatos= ISpiDatosService.listaspidatos();
		Collections.sort(listaspidatos, Collections.reverseOrder());
		model.addAttribute("titulo","Lista de los SPI");
		model.addAttribute("listaspidatos",listaspidatos);
		//CREAR FORMULARIO REGISTRO DE VENTANA MODAL spidatos.html
		SpiDatos spidatos=new SpiDatos();
		List<Zona> listazona=IZonaService.listazona();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		model.addAttribute("titulo1","Formulario: Nuevo Registro de SPI");
		model.addAttribute("titulo2","Formulario: Editar Registro de SPI");
		model.addAttribute("spidatos",spidatos);
		model.addAttribute("listazona",listazona);
		model.addAttribute("listainstitucion",listainstitucion);
		return "/views/DataSpi/SpiDatos/spidatos";
	}
	
	//GUARDAR
    @Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute SpiDatos spidatos, BindingResult result, Model model, 
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		Calendar fecha = Calendar.getInstance();
	    int año = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH) + 1;
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
		
	    if(result.hasErrors()) {
			System.out.print("HUBO ERRORES EN EL FORMULARIO SPI");
			return "redirect:/views/DataSpi/SpiDatos/";
		}
		
		if(!archivo.isEmpty()) {
			String rutaAbsoluta=RutaGuardarArchivos;
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" +"VrfdataSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				spidatos.setArchivo("VrfdataSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ISpiDatosService.guardar(spidatos);
		System.out.print("REGISTRO SPI GUARDADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO SPI GUARDADO CON ÉXITO");
		return "redirect:/views/DataSpi/SpiDatos/";
	}
	
	//GUARDAR
    @Secured("ROLE_ADMIN")
	@PostMapping("/saveedit")
	public String guardaredit(@Valid @ModelAttribute SpiDatos spidatos, BindingResult result, Model model, 
			@RequestParam("file") MultipartFile archivo, RedirectAttributes alerta) {
		Calendar fecha = Calendar.getInstance();
	    int año = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH) + 1;
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
		List<Zona> listazona=IZonaService.listazona();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Ver Detalle del SPI: " + spidatos.getNombre());
			model.addAttribute("titulo1","Formulario: Editar Registro del SPI");
			model.addAttribute("listazona",listazona);
			model.addAttribute("listainstitucion",listainstitucion);
			model.addAttribute("spidatos", spidatos);
			System.out.print("HUBO ERRORES EN EL FORMULARIO SPI");
			return "views/DataSpi/SpiDatos/detalle";
		}
		
		if(!archivo.isEmpty()) {
			String rutaAbsoluta=RutaGuardarArchivos;
			
			try {
				byte[] bytesArch= archivo.getBytes();
				Path rutaCompleta= Paths.get(rutaAbsoluta + "//" +"VrfdataSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				Files.write(rutaCompleta,bytesArch);
	
				spidatos.setArchivo("VrfdataSPI"+"_"+dia+mes+año+"_"+hora+minuto+segundo+"_"+archivo.getOriginalFilename());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ISpiDatosService.guardar(spidatos);
		System.out.print("REGISTRO SPI EDITADO CON ÉXITO");
		alerta.addFlashAttribute("success", "REGISTRO SPI EDITADO CON ÉXITO");
		return "redirect:/views/DataSpi/SpiDatos/spidetl/" + spidatos.getIdspi();
	}
		
	
	
	//EDITAR MODAL
    @Secured("ROLE_ADMIN")
	@GetMapping("/edit")
	@ResponseBody
	public SpiDatos editar(Long idspi) {
		return ISpiDatosService.buscarPorId(idspi);
	}
	
	//EDITAR Y DETALLE
	
    @Secured({"ROLE_ADMIN", "ROLE_VISITOR"})
	@GetMapping("/spidetl/{idspi}")
  
	public String Verdetalle(@PathVariable("idspi") Long idspi, Model model, RedirectAttributes attribute) { 
		List<Zona> listazona=IZonaService.listazona();
		List<Institucion> listainstitucion=IInstitucionService.listainstitucion();
		SpiDatos spidatos = null;
	  
		if(idspi>0) {
			spidatos= ISpiDatosService.buscarPorId(idspi);
		  
			if (spidatos==null) {
				attribute.addFlashAttribute("error","ATENCION: Este registro SPI no existe");
				return "/views/DataSpi/SpiDatos/";
			}
		}else {
			attribute.addFlashAttribute("error","ATENCION: Error con el registro del SPI");
			return "/views/DataSpi/SpiDatos/";
		}
		model.addAttribute("titulo","Ver Detalle del SPI: " + spidatos.getNombre());
		model.addAttribute("titulo1","Formulario: Editar Registro del SPI");
		model.addAttribute("listazona",listazona);
		model.addAttribute("listainstitucion",listainstitucion);
		model.addAttribute("spidatos", spidatos);
	  
		return "/views/DataSpi/SpiDatos/detalle"; 
	}

}
