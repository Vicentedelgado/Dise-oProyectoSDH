package com.sdhdata.util;

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

import com.sdhdata.model.RRHH;

@Component("/views/Consulta/RRHH/rrhh.xlsx")
public class RRHHConsultaExcel extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistrosdelRRHH.xlsx\"");
		Sheet hoja = workbook.createSheet("Registros de RRHH de los SPIs");
		
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
		box4.setCellValue("LISTA DEL RECURSO HUMANO DE LOS SPI");
		
		Row filadatos=hoja.createRow(6);
		String[] columnasdatosspi = {"ID","NOMBRES","APELLIDOS","CÉDULA","ZONA", "SPI", "CARGO","ESTADO","MODALIDAD DE TRABAJO","UNIDAD","N° TELÉFONO","EMAIL","DIRECCIÓN DE DOMICILIO"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh1= (List<RRHH>) model.get("listarrhh1");
		
		int numfila=7;
		for (RRHH registrosrrhh : listarrhh1) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh2= (List<RRHH>) model.get("listarrhh2");
		
		for (RRHH registrosrrhh : listarrhh2) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh3= (List<RRHH>) model.get("listarrhh3");
		
		for (RRHH registrosrrhh : listarrhh3) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh4= (List<RRHH>) model.get("listarrhh4");
		
		for (RRHH registrosrrhh : listarrhh4) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh5= (List<RRHH>) model.get("listarrhh5");
		
		for (RRHH registrosrrhh : listarrhh5) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh6= (List<RRHH>) model.get("listarrhh6");
		
		for (RRHH registrosrrhh : listarrhh6) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh7= (List<RRHH>) model.get("listarrhh7");
		
		for (RRHH registrosrrhh : listarrhh7) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh8= (List<RRHH>) model.get("listarrhh8");
		
		for (RRHH registrosrrhh : listarrhh8) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh9= (List<RRHH>) model.get("listarrhh9");
		
		for (RRHH registrosrrhh : listarrhh9) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getEstado());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(10).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(11).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(12).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
	}

}
