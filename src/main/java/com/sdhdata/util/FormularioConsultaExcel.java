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

import com.sdhdata.model.RRHH;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;

@Component("/views/Consulta/Formulario/formulario.xlsx")
public class FormularioConsultaExcel extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistrosDelSPI.xlsx\"");
		Sheet hoja = workbook.createSheet("Registros de bienes del SPI");
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
		String[] columnasdatosspi = {"SPI","DIRECCIÓN","INMUEBLE PROPIEDAD DE","N° TELÉFONO", "N° OFICINA", "CONVENIO","LÍMITE DE CONVENIO","DA SERVICIO A","OBSERVACIONES"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<SpiDatos> listaspi1= (List<SpiDatos>) model.get("listaspi1");
		
		int numfila=7;
		for (SpiDatos spiDatos : listaspi1) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(spiDatos.getNombre());
			filadatos.createCell(1).setCellValue(spiDatos.getDireccion());
			filadatos.createCell(2).setCellValue(spiDatos.getIdinstitucion().getNombre());
			filadatos.createCell(3).setCellValue(spiDatos.getTelefono());
			filadatos.createCell(4).setCellValue(spiDatos.getNumerodeoficina());
			filadatos.createCell(5).setCellValue(spiDatos.getConvenio());
			filadatos.createCell(6).setCellValue(formatofecha.format(spiDatos.getFechafinconvenio()));
			filadatos.createCell(7).setCellValue(spiDatos.getDaservicioa());
			filadatos.createCell(8).setCellValue(spiDatos.getObservaciones());
			numfila ++;
			
		}
		
		Row filadatosrrhh=hoja.createRow(10);
		String[] columnasdatosrrhh = {"NOMBRES","APELLIDOS","CARGO","TELÉFONOS", "EMAIL","DIRECCIÓN","MODALIDAD DE TRABAJO"};
		
		for (int i = 0; i < columnasdatosrrhh.length; i++) {
			box =filadatosrrhh.createCell(i);
			box.setCellValue(columnasdatosrrhh[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh= (List<RRHH>) model.get("listarrhh");
		
		int numfila1=11;
		for (RRHH rrhh : listarrhh) {
			filadatos =hoja.createRow(numfila1);
			
			filadatos.createCell(0).setCellValue(rrhh.getNombres());
			filadatos.createCell(1).setCellValue(rrhh.getApellidos());
			filadatos.createCell(2).setCellValue(rrhh.getCargo());
			filadatos.createCell(3).setCellValue(rrhh.getTelefono());
			filadatos.createCell(4).setCellValue(rrhh.getEmail());
			filadatos.createCell(5).setCellValue(rrhh.getDireccion());
			filadatos.createCell(6).setCellValue(rrhh.getIdmodalidad().getNombre());
			numfila1 ++;	
		}
		
		int numfila2=numfila1+1;
		Row filadatosbienes=hoja.createRow(numfila2);
		String[] columnasdatosbienes = {"ID","BIEN/SERVICIO","CANTIDAD EXISTENTE", "ESTADO","PRIORIDAD","CANTIDAD REQUERIDA","FALTANTE","AVANCES (Acción)","FECHA","OBSERVACIONES"};
		
		for (int i = 0; i < columnasdatosbienes.length; i++) {
			box =filadatosbienes.createCell(i);
			box.setCellValue(columnasdatosbienes[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiinstalaciones= (List<RegistrodelSpi>) model.get("listaregistrodelspiinstalaciones");
		
        int numfila3=numfila2+1;
		for (RegistrodelSpi registros : listaregistrodelspiinstalaciones) {
			filadatos =hoja.createRow(numfila3);
			
			filadatos.createCell(0).setCellValue(registros.getIdregistro());
			filadatos.createCell(1).setCellValue(registros.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registros.getCantidad());
			filadatos.createCell(3).setCellValue(registros.getEstado());
			filadatos.createCell(4).setCellValue(registros.getPrioridad());
			filadatos.createCell(5).setCellValue(registros.getCantidadrequerida());
			filadatos.createCell(6).setCellValue(registros.getHolguradecantidad());
			filadatos.createCell(7).setCellValue(registros.getAccionrealizada());
			filadatos.createCell(8).setCellValue(formatofecha.format(registros.getFechaaccion()));
			filadatos.createCell(9).setCellValue(registros.getObservaciones());
			numfila3 ++;	
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspibienes= (List<RegistrodelSpi>) model.get("listaregistrodelspibienes");
		for (RegistrodelSpi registros : listaregistrodelspibienes) {
			filadatos =hoja.createRow(numfila3);
			
			filadatos.createCell(0).setCellValue(registros.getIdregistro());
			filadatos.createCell(1).setCellValue(registros.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registros.getCantidad());
			filadatos.createCell(3).setCellValue(registros.getEstado());
			filadatos.createCell(4).setCellValue(registros.getPrioridad());
			filadatos.createCell(5).setCellValue(registros.getCantidadrequerida());
			filadatos.createCell(6).setCellValue(registros.getHolguradecantidad());
			filadatos.createCell(7).setCellValue(registros.getAccionrealizada());
			filadatos.createCell(8).setCellValue(formatofecha.format(registros.getFechaaccion()));
			filadatos.createCell(9).setCellValue(registros.getObservaciones());
			numfila3 ++;	
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiequipos= (List<RegistrodelSpi>) model.get("listaregistrodelspiequipos");
		for (RegistrodelSpi registros : listaregistrodelspiequipos) {
			filadatos =hoja.createRow(numfila3);
			
			filadatos.createCell(0).setCellValue(registros.getIdregistro());
			filadatos.createCell(1).setCellValue(registros.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registros.getCantidad());
			filadatos.createCell(3).setCellValue(registros.getEstado());
			filadatos.createCell(4).setCellValue(registros.getPrioridad());
			filadatos.createCell(5).setCellValue(registros.getCantidadrequerida());
			filadatos.createCell(6).setCellValue(registros.getHolguradecantidad());
			filadatos.createCell(7).setCellValue(registros.getAccionrealizada());
			filadatos.createCell(8).setCellValue(formatofecha.format(registros.getFechaaccion()));
			filadatos.createCell(9).setCellValue(registros.getObservaciones());
			numfila3 ++;	
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiotros= (List<RegistrodelSpi>) model.get("listaregistrodelspiotros");
		for (RegistrodelSpi registros : listaregistrodelspiotros) {
			filadatos =hoja.createRow(numfila3);
			
			filadatos.createCell(0).setCellValue(registros.getIdregistro());
			filadatos.createCell(1).setCellValue(registros.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registros.getCantidad());
			filadatos.createCell(3).setCellValue(registros.getEstado());
			filadatos.createCell(4).setCellValue(registros.getPrioridad());
			filadatos.createCell(5).setCellValue(registros.getCantidadrequerida());
			filadatos.createCell(6).setCellValue(registros.getHolguradecantidad());
			filadatos.createCell(7).setCellValue(registros.getAccionrealizada());
			filadatos.createCell(8).setCellValue(formatofecha.format(registros.getFechaaccion()));
			filadatos.createCell(9).setCellValue(registros.getObservaciones());
			numfila3 ++;	
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspimovilidad= (List<RegistrodelSpi>) model.get("listaregistrodelspimovilidad");
		for (RegistrodelSpi registros : listaregistrodelspimovilidad) {
			filadatos =hoja.createRow(numfila3);
			
			filadatos.createCell(0).setCellValue(registros.getIdregistro());
			filadatos.createCell(1).setCellValue(registros.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registros.getCantidad());
			filadatos.createCell(3).setCellValue(registros.getEstado());
			filadatos.createCell(4).setCellValue(registros.getPrioridad());
			filadatos.createCell(5).setCellValue(registros.getCantidadrequerida());
			filadatos.createCell(6).setCellValue(registros.getHolguradecantidad());
			filadatos.createCell(7).setCellValue(registros.getAccionrealizada());
			filadatos.createCell(8).setCellValue(formatofecha.format(registros.getFechaaccion()));
			filadatos.createCell(9).setCellValue(registros.getObservaciones());
			numfila3 ++;	
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspiconectividad= (List<RegistrodelSpi>) model.get("listaregistrodelspiconectividad");
		for (RegistrodelSpi registros : listaregistrodelspiconectividad) {
			filadatos =hoja.createRow(numfila3);
			
			filadatos.createCell(0).setCellValue(registros.getIdregistro());
			filadatos.createCell(1).setCellValue(registros.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registros.getCantidad());
			filadatos.createCell(3).setCellValue(registros.getEstado());
			filadatos.createCell(4).setCellValue(registros.getPrioridad());
			filadatos.createCell(5).setCellValue(registros.getCantidadrequerida());
			filadatos.createCell(6).setCellValue(registros.getHolguradecantidad());
			filadatos.createCell(7).setCellValue(registros.getAccionrealizada());
			filadatos.createCell(8).setCellValue(formatofecha.format(registros.getFechaaccion()));
			filadatos.createCell(9).setCellValue(registros.getObservaciones());
			numfila3 ++;	
		}
	}


}
