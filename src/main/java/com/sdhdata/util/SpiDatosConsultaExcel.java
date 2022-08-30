package com.sdhdata.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.sdhdata.model.SpiDatos;

@Component("/views/Consulta/SpiDatos/spidatos.xlsx")
public class SpiDatosConsultaExcel extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistroDatosSPI.xlsx\"");
		Sheet hoja = workbook.createSheet("Registros de datos SPI");
		DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		
		Row filatitulo= hoja.createRow(0);
		Cell box =filatitulo.createCell(2);
		box.setCellValue("SECRETARÍA DE DERECHOS HUMANOS");
		Row filatitulo1= hoja.createRow(1);
		Cell box1 =filatitulo1.createCell(2);
		box1.setCellValue("DIRECCIÓN ADMINISTRATIVA");
		Row filatitulo2= hoja.createRow(2);
		Cell box2 =filatitulo2.createCell(2);
		box2.setCellValue("Coordinación General Administrativa Financiera");
		Row filatitulo3= hoja.createRow(3);
		Cell box3 =filatitulo3.createCell(2);
		box3.setCellValue("Base de Datos SPI");
		Row filatitulo4= hoja.createRow(4);
		Cell box4 =filatitulo4.createCell(1);
		box4.setCellValue("LISTA DE LOS SPI");
		
		Row filadatos=hoja.createRow(6);
		String[] columnasdatosspi = {"ID","SPI","ZONA","INSTITUCIÓN DONDE FUNCIONA","DIRECCIÓN", "N° TELÉFONO", "N° OFICINA","CONVENIO","LÍMITE DE CONVENIO","DA SERVICIO A","OBSERVACIONES"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<SpiDatos> listaspidatos= (List<SpiDatos>) model.get("listaspidatos");
		
		int numfila=7;
		for (SpiDatos registrospidatos: listaspidatos) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrospidatos.getIdspi());
			filadatos.createCell(1).setCellValue(registrospidatos.getNombre());
			filadatos.createCell(2).setCellValue(registrospidatos.getIdzona().getNombre());
			filadatos.createCell(3).setCellValue(registrospidatos.getIdinstitucion().getNombre());
			filadatos.createCell(4).setCellValue(registrospidatos.getDireccion());
			filadatos.createCell(5).setCellValue(registrospidatos.getTelefono());
			filadatos.createCell(6).setCellValue(registrospidatos.getNumerodeoficina());
			filadatos.createCell(7).setCellValue(registrospidatos.getConvenio());
			filadatos.createCell(8).setCellValue(formatofecha.format(registrospidatos.getFechafinconvenio()));
			filadatos.createCell(9).setCellValue(registrospidatos.getDaservicioa());
			filadatos.createCell(10).setCellValue(registrospidatos.getObservaciones());	
			numfila ++;
			
		}
	}

}
