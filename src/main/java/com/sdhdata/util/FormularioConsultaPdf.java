package com.sdhdata.util;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.sdhdata.model.RRHH;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;

@Component("/views/Consulta/Formulario/formulario")
public class FormularioConsultaPdf extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Date hoy = new Date();
		DateFormat formatohoy = new SimpleDateFormat("EEEE, d MMMM, yyyy");
		DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		
		@SuppressWarnings("unchecked")
		List<SpiDatos> listaspi1= (List<SpiDatos>) model.get("listaspi1");
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh=(List<RRHH>) model.get("listarrhh");
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiinstalaciones= (List<RegistrodelSpi>) model.get("listaregistrodelspiinstalaciones");
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspibienes= (List<RegistrodelSpi>) model.get("listaregistrodelspibienes");
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiequipos= (List<RegistrodelSpi>) model.get("listaregistrodelspiequipos");
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiotros= (List<RegistrodelSpi>) model.get("listaregistrodelspiotros");
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspimovilidad= (List<RegistrodelSpi>) model.get("listaregistrodelspimovilidad");
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiconectividad= (List<RegistrodelSpi>) model.get("listaregistrodelspiconectividad");
		
		//DOCUMENTO PDF (REPORTE)
		document.setPageSize(PageSize.A4.rotate());
		document.setMargins(-40, -40, 10, 10);
		document.open();
		PdfPCell comun=null;
		
		//ENCABEZADO
		PdfPTable tablatitulo= new PdfPTable(1);
		PdfPCell titulo=null;
		PdfPTable tablatitulo1= new PdfPTable(1);
		PdfPCell titulo1=null;
		PdfPTable tablatitulo2= new PdfPTable(1);
		PdfPCell titulo2=null;
		PdfPTable tablatitulo3= new PdfPTable(1);
		PdfPCell titulo3=null;
		PdfPTable tablafechaactual= new PdfPTable(1);
		PdfPCell fechaactual=null;
		PdfPTable tabladatos= new PdfPTable(1);
		PdfPCell titulodatos=null;
		PdfPTable tablarrhh= new PdfPTable(1);
		PdfPCell titulorrhh=null;
		PdfPTable tablainmueble= new PdfPTable(1);
		PdfPCell tituloinmueble=null;
		PdfPTable tablabienes= new PdfPTable(1);
		PdfPCell titulobienes=null;
		PdfPTable tablaconectividad= new PdfPTable(1);
		PdfPCell tituloconectividad=null;
		
		
		
		/* Fuentes*/
		Font fuente=FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Color.black);
		Font fuentetitulocolumna= FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Color.black);
		Font fuenteceldas= FontFactory.getFont(FontFactory.COURIER,10,Color.black);
		
		/*Titulos*/
		titulo = new PdfPCell(new Phrase("SECRETARÍA DE DERECHOS HUMANOS", fuente));
		titulo.setBorder(0);
		titulo.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo1 = new PdfPCell(new Phrase("DIRECCIÓN ADMINISTRATIVA", fuente));
		titulo1.setBorder(0);
		titulo1.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo1.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo2 = new PdfPCell(new Phrase("Coordinación General Administrativa Financiera", fuente));
		titulo2.setBorder(0);
		titulo2.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo2.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo3 = new PdfPCell(new Phrase("Base de Datos SPI", fuente));
		titulo3.setBorder(0);
		titulo3.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo3.setVerticalAlignment(Element.ALIGN_CENTER);
		
		fechaactual = new PdfPCell(new Phrase(formatohoy.format(hoy), fuentetitulocolumna));
		fechaactual.setBorder(0);
		fechaactual.setHorizontalAlignment(Element.ALIGN_RIGHT);
		fechaactual.setVerticalAlignment(Element.ALIGN_RIGHT);
		
		titulodatos = new PdfPCell(new Phrase("DATOS GENERALES SPI", fuente));
		titulodatos.setBackgroundColor(new Color(207,236,254));
		titulodatos.setBorder(0);
		titulodatos.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulodatos.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulorrhh = new PdfPCell(new Phrase("RECURSO HUMANO", fuente));
		titulorrhh.setBackgroundColor(new Color(207,236,254));
		titulorrhh.setBorder(0);
		titulorrhh.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulorrhh.setVerticalAlignment(Element.ALIGN_CENTER);
		
		tituloinmueble = new PdfPCell(new Phrase("CARACTERÍSTICAS DEL INMUEBLE", fuente));
		tituloinmueble.setBackgroundColor(new Color(207,236,254));
		tituloinmueble.setBorder(0);
		tituloinmueble.setHorizontalAlignment(Element.ALIGN_CENTER);
		tituloinmueble.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulobienes = new PdfPCell(new Phrase("REGISTRO DE BIENES", fuente));
		titulobienes.setBackgroundColor(new Color(207,236,254));
		titulobienes.setBorder(0);
		titulobienes.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulobienes.setVerticalAlignment(Element.ALIGN_CENTER);
		
		tituloconectividad = new PdfPCell(new Phrase("CONECTIVIDAD", fuente));
		tituloconectividad.setBackgroundColor(new Color(207,236,254));
		tituloconectividad.setBorder(0);
		tituloconectividad.setHorizontalAlignment(Element.ALIGN_CENTER);
		tituloconectividad.setVerticalAlignment(Element.ALIGN_CENTER);
		
		/*Añadiendo dtos a tablas*/
		tablatitulo.addCell(titulo);
		tablatitulo1.addCell(titulo1);
		tablatitulo2.addCell(titulo2);
		tablatitulo3.addCell(titulo3);
		tablatitulo3.setSpacingAfter(30);
		tablafechaactual.addCell(fechaactual);
		tabladatos.addCell(titulodatos);
		tablarrhh.addCell(titulorrhh);
		tablarrhh.setSpacingBefore(15);
		tablainmueble.addCell(tituloinmueble);
		tablainmueble.setSpacingBefore(15);
		tablabienes.addCell(titulobienes);
		tablabienes.setSpacingBefore(15);
		tablaconectividad.addCell(tituloconectividad);
		tablaconectividad.setSpacingBefore(15);
		
		//TABLA DE DATOS GENERALES
		PdfPTable tablalistaspidatos= new PdfPTable(2);
		tablalistaspidatos.setWidths(new float[] {0.4f,2f}); 	
		
		for(SpiDatos listaspidatos:listaspi1){
			comun = new PdfPCell(new Phrase("SPI:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(listaspidatos.getNombre(),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Dirección:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(listaspidatos.getDireccion(),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Inmueble propiedad de:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(listaspidatos.getIdinstitucion().getNombre(),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Número de teléfono:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(listaspidatos.getTelefono(),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Número de oficina:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(Integer.toString(listaspidatos.getNumerodeoficina()),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Convenio:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(listaspidatos.getConvenio(),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Límite de convenio:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(formatofecha.format(listaspidatos.getFechafinconvenio()),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Da servicio a:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(listaspidatos.getDaservicioa(),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Observaciones:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(listaspidatos.getObservaciones(),fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Reporte generado el día:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(formatohoy.format(hoy), fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
		}
		
		//TABLA DE RRHH
		PdfPTable tablalistarrhh= new PdfPTable(7);
		tablalistarrhh.setWidths(new float[] {1f,1f,1f,1f,1f,1f,1f});
		
		comun = new PdfPCell(new Phrase("Nombres",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Apellidos",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cargo",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Teléfonos",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Correo electrónico",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Dirección",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Modalidad de trabajo",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablalistarrhh.addCell(comun);
		
		for(RRHH listarrhhdatos:listarrhh){
			comun=new PdfPCell(new Phrase(listarrhhdatos.getNombres(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrhhdatos.getApellidos(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrhhdatos.getCargo(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrhhdatos.getTelefono(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrhhdatos.getEmail(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrhhdatos.getDireccion(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrhhdatos.getIdmodalidad().getNombre(),fuenteceldas));	
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
		}
		
		//TABLA DE INSTALACIONES
		PdfPTable tablainstalaciones= new PdfPTable(9);
		tablainstalaciones.setWidths(new float[] {1.3f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f,1f});
		
		comun = new PdfPCell(new Phrase("INSTALACIONES",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Existente",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Prioridad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Requerida",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Faltante",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Avances (Acción)",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Fecha",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Observaciones",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablainstalaciones.addCell(comun);
		
		for(RegistrodelSpi listaregistrodelspiinstalacionesdatos:listaregistrodelspiinstalaciones){
			comun=new PdfPCell(new Phrase(listaregistrodelspiinstalacionesdatos.getIdactivo().getNombre(),fuenteceldas));
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiinstalacionesdatos.getCantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiinstalacionesdatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiinstalacionesdatos.getPrioridad(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiinstalacionesdatos.getCantidadrequerida()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiinstalacionesdatos.getHolguradecantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiinstalacionesdatos.getAccionrealizada(),fuenteceldas));
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(formatofecha.format(listaregistrodelspiinstalacionesdatos.getFechaaccion()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiinstalacionesdatos.getObservaciones(),fuenteceldas));
			comun.setPadding(5);
			tablainstalaciones.addCell(comun);
		}
		
		//TABLA DE BIENES
		PdfPTable tablabienes1= new PdfPTable(9);
		tablabienes1.setWidths(new float[] {1.3f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f,1f});
		
		comun = new PdfPCell(new Phrase("BIENES",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Existente",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Prioridad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Requerida",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Faltante",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Avances (Acción)",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Fecha",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Observaciones",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablabienes1.addCell(comun);
		
		for(RegistrodelSpi listaregistrodelspibienesdatos:listaregistrodelspibienes){
			comun=new PdfPCell(new Phrase(listaregistrodelspibienesdatos.getIdactivo().getNombre(),fuenteceldas));
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspibienesdatos.getCantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspibienesdatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspibienesdatos.getPrioridad(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspibienesdatos.getCantidadrequerida()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspibienesdatos.getHolguradecantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspibienesdatos.getAccionrealizada(),fuenteceldas));
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(formatofecha.format(listaregistrodelspibienesdatos.getFechaaccion()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablabienes1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspibienesdatos.getObservaciones(),fuenteceldas));
			comun.setPadding(5);
			tablabienes1.addCell(comun);
		}
		//TABLA DE EQUIPOS
		PdfPTable tablaequipos= new PdfPTable(9);
		tablaequipos.setWidths(new float[] {1.3f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f,1f});
		tablaequipos.setSpacingBefore(15);
		
		comun = new PdfPCell(new Phrase("EQUIPOS",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Existente",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Prioridad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Requerida",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Faltante",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Avances (Acción)",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Fecha",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Observaciones",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaequipos.addCell(comun);
		
		for(RegistrodelSpi listaregistrodelspiequiposdatos:listaregistrodelspiequipos){
			comun=new PdfPCell(new Phrase(listaregistrodelspiequiposdatos.getIdactivo().getNombre(),fuenteceldas));
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiequiposdatos.getCantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiequiposdatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiequiposdatos.getPrioridad(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiequiposdatos.getCantidadrequerida()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiequiposdatos.getHolguradecantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiequiposdatos.getAccionrealizada(),fuenteceldas));
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(formatofecha.format(listaregistrodelspiequiposdatos.getFechaaccion()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaequipos.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiequiposdatos.getObservaciones(),fuenteceldas));
			comun.setPadding(5);
			tablaequipos.addCell(comun);
		}
		//TABLA DE OTROS
		PdfPTable tablaotros= new PdfPTable(9);
		tablaotros.setWidths(new float[] {1.3f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f,1f});
		tablaotros.setSpacingBefore(15);
		
		comun = new PdfPCell(new Phrase("OTROS",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Existente",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Prioridad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Requerida",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Faltante",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Avances (Acción)",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Fecha",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Observaciones",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaotros.addCell(comun);
		
		for(RegistrodelSpi listaregistrodelspiotrosdatos:listaregistrodelspiotros){
			comun=new PdfPCell(new Phrase(listaregistrodelspiotrosdatos.getIdactivo().getNombre(),fuenteceldas));
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiotrosdatos.getCantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiotrosdatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiotrosdatos.getPrioridad(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiotrosdatos.getCantidadrequerida()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiotrosdatos.getHolguradecantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiotrosdatos.getAccionrealizada(),fuenteceldas));
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(formatofecha.format(listaregistrodelspiotrosdatos.getFechaaccion()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiotrosdatos.getObservaciones(),fuenteceldas));
			comun.setPadding(5);
			tablaotros.addCell(comun);
			
		}
				
		//TABLA DE MOVILIDAD
		PdfPTable tablamovilidad= new PdfPTable(9);
		tablamovilidad.setWidths(new float[] {1.3f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f,1f});
		tablamovilidad.setSpacingBefore(15);
		
		comun = new PdfPCell(new Phrase("MOVILIDAD",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Existente",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Prioridad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Requerida",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Faltante",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Avances (Acción)",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Fecha",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Observaciones",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablamovilidad.addCell(comun);
		
		for(RegistrodelSpi listaregistrodelspimovilidaddatos:listaregistrodelspimovilidad){
			comun=new PdfPCell(new Phrase(listaregistrodelspimovilidaddatos.getIdactivo().getNombre(),fuenteceldas));
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspimovilidaddatos.getCantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspimovilidaddatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspimovilidaddatos.getPrioridad(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspimovilidaddatos.getCantidadrequerida()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspimovilidaddatos.getHolguradecantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspimovilidaddatos.getAccionrealizada(),fuenteceldas));
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(formatofecha.format(listaregistrodelspimovilidaddatos.getFechaaccion()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspimovilidaddatos.getObservaciones(),fuenteceldas));
			comun.setPadding(5);
			tablamovilidad.addCell(comun);
		}
		//TABLA DE CONECTIVIDAD
		PdfPTable tablaconectividad1= new PdfPTable(9);
		tablaconectividad1.setWidths(new float[] {1.3f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f,1f});
		
		comun = new PdfPCell(new Phrase("CONECTIVIDAD",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Existente",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Prioridad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cantidad Requerida",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Faltante",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Avances (Acción)",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Fecha",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Observaciones",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(10);
		tablaconectividad1.addCell(comun);
		
		for(RegistrodelSpi listaregistrodelspiconectividaddatos:listaregistrodelspiconectividad){
			comun=new PdfPCell(new Phrase(listaregistrodelspiconectividaddatos.getIdactivo().getNombre(),fuenteceldas));
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiconectividaddatos.getCantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiconectividaddatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiconectividaddatos.getPrioridad(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiconectividaddatos.getCantidadrequerida()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(Integer.toString(listaregistrodelspiconectividaddatos.getHolguradecantidad()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiconectividaddatos.getAccionrealizada(),fuenteceldas));
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(formatofecha.format(listaregistrodelspiconectividaddatos.getFechaaccion()),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listaregistrodelspiconectividaddatos.getObservaciones(),fuenteceldas));
			comun.setPadding(5);
			tablaconectividad1.addCell(comun);
		}
		
		
		//tablas de linea y firma
		PdfPTable tablalinea= new PdfPTable(2);
		tablalinea.setWidths(new float[] {2f,2f});
		tablalinea.setSpacingBefore(60);
		PdfPCell linea=null;
		
		for (int i = 0; i < 1; i++) {
			linea = new PdfPCell(new Phrase("________________________________", fuente));
			linea.setBorder(0);
			linea.setHorizontalAlignment(Element.ALIGN_CENTER);
			linea.setVerticalAlignment(Element.ALIGN_CENTER);
			tablalinea.addCell(linea);
			
			linea = new PdfPCell(new Phrase("________________________________", fuente));
			linea.setBorder(0);
			linea.setHorizontalAlignment(Element.ALIGN_CENTER);
			linea.setVerticalAlignment(Element.ALIGN_CENTER);
			tablalinea.addCell(linea);
		}
		
		PdfPTable tablafirma= new PdfPTable(2);
		tablafirma.setWidths(new float[] {2f,2f});
		PdfPCell firma=null;
		
		for (int i = 0; i < 1; i++) {
			firma = new PdfPCell(new Phrase("Secretaría", fuente));
			firma.setBorder(0);
			firma.setHorizontalAlignment(Element.ALIGN_CENTER);
			firma.setVerticalAlignment(Element.ALIGN_CENTER);
			tablafirma.addCell(firma);
			
			firma = new PdfPCell(new Phrase("Dirección", fuente));
			firma.setBorder(0);
			firma.setHorizontalAlignment(Element.ALIGN_CENTER);
			firma.setVerticalAlignment(Element.ALIGN_CENTER);
			tablafirma.addCell(firma);
		}

		
		// Añadir escrito al documento
		document.add(tablatitulo);
		document.add(tablatitulo1);
		document.add(tablatitulo2);
		document.add(tablatitulo3);
		document.add(tablafechaactual);
		document.add(tabladatos);
		document.add(tablalistaspidatos);
		
		document.add(tablarrhh);
		document.add(tablalistarrhh);
		
		document.add(tablainmueble);
		document.add(tablainstalaciones);
		
		document.add(tablabienes);
		document.add(tablabienes1);
		document.add(tablaequipos);
		document.add(tablaotros);
		document.add(tablamovilidad);
		
		document.add(tablaconectividad);
		document.add(tablaconectividad1);
		document.add(tablalinea);
		document.add(tablafirma);
		
	}

}
