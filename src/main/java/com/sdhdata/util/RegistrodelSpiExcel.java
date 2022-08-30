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

import com.sdhdata.model.RegistrodelSpi;

@Component("/views/DataSpi/RegistroDelSpi/registrosdelspi.xlsx")
public class RegistrodelSpiExcel extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistrosBienes/ServiciosdelosSPI.xlsx\"");
		Sheet hoja = workbook.createSheet("Registros de los SPI");
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
		box4.setCellValue("LISTA DE BIENES Y SERVICIOS DE LOS SPI");
		
		Row filadatos=hoja.createRow(6);
		String[] columnasdatosspi = {"ID","BIEN/SERVICIO","ZONA","SPI","PERTENENCIA DEL BIEN/SERVICIO", "ESTADO", "CANTIDAD EXISTENTE","CANTIDAD REQUERIDA","FALTANTE","PRIORIDAD","AVANCES (Acción)","PERIODO", "FECHA","OBSERVACIONES"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspi= (List<RegistrodelSpi>) model.get("listaregistrodelspi");
		
		int numfila=7;
		for (RegistrodelSpi registrosspi : listaregistrodelspi) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosspi.getIdregistro());
			filadatos.createCell(1).setCellValue(registrosspi.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registrosspi.getIdspi().getIdzona().getNombre());
			filadatos.createCell(3).setCellValue(registrosspi.getIdspi().getNombre());
			filadatos.createCell(4).setCellValue(registrosspi.getIdinstitucion().getNombre());
			filadatos.createCell(5).setCellValue(registrosspi.getEstado());
			filadatos.createCell(6).setCellValue(registrosspi.getCantidad());
			filadatos.createCell(7).setCellValue(registrosspi.getCantidadrequerida());
			filadatos.createCell(8).setCellValue(registrosspi.getHolguradecantidad());
			filadatos.createCell(9).setCellValue(registrosspi.getPrioridad());
			filadatos.createCell(10).setCellValue(registrosspi.getAccionrealizada());
			filadatos.createCell(11).setCellValue(registrosspi.getPeriodo());
			filadatos.createCell(12).setCellValue(formatofecha.format(registrosspi.getFechaaccion()));
			filadatos.createCell(13).setCellValue(registrosspi.getObservaciones());
			numfila ++;
			
		}
    }
}
