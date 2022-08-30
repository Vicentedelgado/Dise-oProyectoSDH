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

@Component("/views/Consulta/RRHH/rrhhporspi")
public class RRHHPorSpiConsultaPdf extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Date hoy = new Date();
		DateFormat formatohoy = new SimpleDateFormat("EEEE, d MMMM, yyyy");
		DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		
		@SuppressWarnings("unchecked")
		List<RRHH> listaspirrhh= (List<RRHH>) model.get("listaspirrhh");
		
		String array[];
		array= new String[10];
		listaspirrhh.forEach(datos ->{
			array[0] = datos.getIdspi().getNombre();
			array[1] = datos.getIdzona().getNombre();
			array[2] = datos.getIdspi().getDireccion();
			array[3] = datos.getIdspi().getIdinstitucion().getNombre();
			array[4] = datos.getIdspi().getTelefono();
			array[5] = Integer.toString(datos.getIdspi().getNumerodeoficina());
			array[6] = datos.getIdspi().getConvenio();
			array[7] = formatofecha.format(datos.getIdspi().getFechafinconvenio());
			array[8] = datos.getIdspi().getDaservicioa();
			array[9] = datos.getIdspi().getObservaciones();
			
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
		PdfPTable tablarrhh= new PdfPTable(1);
		PdfPCell titulorrhh=null;
		
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
		
		/*Añadiendo dtos a tablas*/
		tablatitulo.addCell(titulo);
		tablatitulo1.addCell(titulo1);
		tablatitulo2.addCell(titulo2);
		tablatitulo3.addCell(titulo3);
		tablatitulo3.setSpacingAfter(30);
		tablafechaactual.addCell(fechaactual);
		tabladatos.addCell(titulodatos);
		tabladatos.setSpacingAfter(10);
		tablarrhh.addCell(titulorrhh);
		tablarrhh.setSpacingBefore(15);
		
		//TABLA DE DATOS GENERALES
		PdfPTable tablalistaspidatos= new PdfPTable(2);
		tablalistaspidatos.setWidths(new float[] {0.4f,2f}); 
		
		for (int i = 0; i < 1; i++) {
			comun = new PdfPCell(new Phrase("SPI:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[0],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Zona:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[1],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Dirección:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[2],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Inmueble propiedad de:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[3],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Número de teléfono:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[4],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Número de oficina:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[5],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Convenio:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[6],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Límite de convenio:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[7],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Da servicio a:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[8],fuenteceldas));
			comun.setBorder(0);
			comun.setPadding(2);
			tablalistaspidatos.addCell(comun);
			
			comun = new PdfPCell(new Phrase("Observaciones:",fuentetitulocolumna));
			comun.setBorder(0);
			comun.setPadding(3);
			tablalistaspidatos.addCell(comun);
			comun=new PdfPCell(new Phrase(array[9],fuenteceldas));
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
		PdfPTable tablalistarrhh= new PdfPTable(10);
		tablalistarrhh.setWidths(new float[] {1f,1f,0.8f,0.8f,0.8f,0.8f,0.8f,0.8f,1f,1f});
		
		comun = new PdfPCell(new Phrase("Nombres",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Apellidos",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cédula",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Cargo",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Estado",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Modalidad de trabajo",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Unidad",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Teléfonos",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Correo electrónico",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		comun = new PdfPCell(new Phrase("Dirección domicilio",fuentetitulocolumna));
		comun.setBackgroundColor(Color.lightGray);
		comun.setHorizontalAlignment(Element.ALIGN_CENTER);
		comun.setVerticalAlignment(Element.ALIGN_CENTER);
		comun.setPadding(5);
		tablalistarrhh.addCell(comun);
		
		for(RRHH listarrrhhdatos:listaspirrhh){
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getNombres(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getApellidos(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getCedula(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getCargo(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getEstado(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getIdmodalidad().getNombre(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getIdunidad().getNombre(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getTelefono(),fuenteceldas));
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getEmail(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
			
			comun=new PdfPCell(new Phrase(listarrrhhdatos.getDireccion(),fuenteceldas));
			comun.setHorizontalAlignment(Element.ALIGN_CENTER);
			comun.setPadding(5);
			tablalistarrhh.addCell(comun);
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
		
		document.add(tablalinea);
		document.add(tablafirma);
	}

}
