package com.sdhdata.service;


//import java.io.File;
//import java.io.FileOutputStream;
import java.util.List;

//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
// com.itextpdf.text.FontFactory;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;

//import spi.mvc.com.data.model.Activo;
//import spi.mvc.com.data.model.Institucion;
import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.repository.RegistroDelSpiRepository;

@Service
@Transactional
public class RegistroDelSpiServiceImp implements IRegistroDelSpiService {
	
	@Autowired
	private RegistroDelSpiRepository  RegistroDelSpiRepository;

	@Override
	public List<RegistrodelSpi> listarregistro() {
		
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.findAll();
	}

	@Override
	public void guardar(RegistrodelSpi RegistrodelSpi) {
		
		RegistroDelSpiRepository.save(RegistrodelSpi);

	}
	@Override
	public void guardartodos(List<RegistrodelSpi> RegistrodelSpi) {
		// TODO Auto-generated method stub
		RegistroDelSpiRepository.saveAll(RegistrodelSpi);
	}

	@Override
	public RegistrodelSpi buscarPorId(Long idregistro) {
		
		return RegistroDelSpiRepository.findById(idregistro).orElse(null);
	}
	
	
	@Override
	public void eliminar(Long idregistro) {
		
		RegistroDelSpiRepository.deleteById(idregistro);

	}
	
	@Override
	public List<RegistrodelSpi> Listaregistrodelspiinstalaciones(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiinstalaciones(idspi);
	}
	
	@Override
	public List<RegistrodelSpi> Listaregistrodelspibienes(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspibienes(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspiequipos(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiequipos(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspiotros(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiotros(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspimovilidad(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspimovilidad(idspi);
	}

	@Override
	public List<RegistrodelSpi> Listaregistrodelspiconectividad(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return (List<RegistrodelSpi>) RegistroDelSpiRepository.Listaregistrodelspiconectividad(idspi);
	}	
	

}
