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

@Component("/views/Consulta/RRHH/rrhhporspi.xlsx")
public class RRHHPorSpiConsultaExcel extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistroDelRRHHPorSPI.xlsx\"");
		Sheet hoja = workbook.createSheet("Registro del RRHH del SPI");
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
		box4.setCellValue("LISTA DEL RECURSO HUMANO");
		
		Row filadatos=hoja.createRow(6);
		String[] columnasdatosspi = {"SPI","ZONA","DIRECCIÓN","INMUEBLE PROPIEDAD DE","N° TELÉFONO", "N° OFICINA", "CONVENIO","LÍMITE DE CONVENIO","DA SERVICIO A","OBSERVACIONES"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
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
		
		int numfila=7;
		for (int i = 0; i < 1; i++) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(array[0]);
			filadatos.createCell(1).setCellValue(array[1]);
			filadatos.createCell(2).setCellValue(array[2]);
			filadatos.createCell(3).setCellValue(array[3]);
			filadatos.createCell(4).setCellValue(array[4]);
			filadatos.createCell(5).setCellValue(array[5]);
			filadatos.createCell(6).setCellValue(array[6]);
			filadatos.createCell(7).setCellValue(array[7]);
			filadatos.createCell(8).setCellValue(array[8]);
			filadatos.createCell(9).setCellValue(array[9]);
			numfila ++;
			
		}
		
		Row filadatosrrhh=hoja.createRow(11);
		String[] columnasdatosrrhh = {"NOMBRES","APELLIDOS","CÉDULA","CARGO","ESTADO","MODALIDAD DE TRABAJO","UNIDAD","TELÉFONOS", "EMAIL","DIRECCIÓN DOMICILIO"};
		
		for (int i = 0; i < columnasdatosrrhh.length; i++) {
			box =filadatosrrhh.createCell(i);
			box.setCellValue(columnasdatosrrhh[i]);
			
		}
		
		
		int numfila1=12;
		for (RRHH rrhh : listaspirrhh) {
			filadatos =hoja.createRow(numfila1);
			
			filadatos.createCell(0).setCellValue(rrhh.getNombres());
			filadatos.createCell(1).setCellValue(rrhh.getApellidos());
			filadatos.createCell(2).setCellValue(rrhh.getCedula());
			filadatos.createCell(3).setCellValue(rrhh.getCargo());
			filadatos.createCell(4).setCellValue(rrhh.getEstado());
			filadatos.createCell(5).setCellValue(rrhh.getIdmodalidad().getNombre());
			filadatos.createCell(6).setCellValue(rrhh.getIdunidad().getNombre());
			filadatos.createCell(7).setCellValue(rrhh.getTelefono());
			filadatos.createCell(8).setCellValue(rrhh.getEmail());
			filadatos.createCell(9).setCellValue(rrhh.getDireccion());
			
			numfila1 ++;	
		}
		
		
	}

}
