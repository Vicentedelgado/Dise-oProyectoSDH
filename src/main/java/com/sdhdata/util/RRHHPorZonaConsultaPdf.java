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

@Component("/views/Consulta/RRHH/rrhhporzona")
public class RRHHPorZonaConsultaPdf extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Date hoy = new Date();
		DateFormat formatohoy = new SimpleDateFormat("EEEE, d MMMM, yyyy");
		
		@SuppressWarnings("unchecked")
		List<RRHH> listazonarrhh= (List<RRHH>) model.get("listazonarrhh");
		
		Long array[];
		array= new Long[13];
		listazonarrhh.forEach(datos ->{
			array[0] = datos.getIdzona().getIdzona();
		});
		

		
		//DOCUMENTO PDF (REPORTE)
		document.setPageSize(PageSize.A4.rotate());
		document.setMargins(-80,-80, 15, 10);
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
		
		/* Fuentes*/
		Font fuente=FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Color.black);
		Font fuentetitulocolumna= FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Color.black);
		Font fuenteceldas= FontFactory.getFont(FontFactory.COURIER,9,Color.black);
		
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
		
		titulodatos = new PdfPCell(new Phrase("LISTA DEL RECURSO HUMANO ZONA " + array[0], fuente));
		titulodatos.setBackgroundColor(new Color(207,236,254));
		titulodatos.setBorder(0);
		titulodatos.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulodatos.setVerticalAlignment(Element.ALIGN_CENTER);
		
		/*Añadiendo dtos a tablas*/
		tablatitulo.addCell(titulo);
		tablatitulo1.addCell(titulo1);
		tablatitulo2.addCell(titulo2);
		tablatitulo3.addCell(titulo3);
		tablatitulo3.setSpacingAfter(30);
		tablafechaactual.addCell(fechaactual);
		tabladatos.addCell(titulodatos);
		tabladatos.setSpacingAfter(10);
		
		//TABLA DE DATOS GENERALES
		PdfPTable tablalistaspidatos= new PdfPTable(2);
		tablalistaspidatos.setWidths(new float[] {0.4f,2f}); 
		
		
		//TABLA DE RRHH
		PdfPTable tablarrhh= new PdfPTable(11);
		tablarrhh.setWidths(new float[] {1f,1f,0.8f,0.8f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f});
		
		comun = new PdfPCell(new Phrase("Nombres",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Apellidos",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cédula",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("SPI",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cargo",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Modalidad de trabajo",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Unidad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Teléfonos",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Correo electrónico",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Dirección domicilio",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablarrhh.addCell(comun);
		
		for(RRHH listarrrhhdatos:listazonarrhh){
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getNombres(),fuenteceldas));
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getApellidos(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getCedula(),fuenteceldas));
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getIdspi().getNombre(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getCargo(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getIdmodalidad().getNombre(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getIdunidad().getNombre(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getTelefono(),fuenteceldas));
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getEmail(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getDireccion(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablarrhh.addCell(comun);
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
		
		document.add(tablalinea);
		document.add(tablafirma);
	}

}
