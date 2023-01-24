/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Conexion;
import Models.DetalleVentas;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Yirlany H
 */
@Named(value = "reportedetalleventasController")
@SessionScoped
public class ReporteDetalleVentasController implements Serializable {

  
    public ReporteDetalleVentasController() {
    }
    
      public void verPdf() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        
        try {
            File jasper= new File (FacesContext.getCurrentInstance()
                    .getExternalContext().getRealPath("/detalleventas/detalleventasreportes.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),null,Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type","application/pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (JRException ex) {
            Logger.getLogger(ReporteDetalleVentasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteDetalleVentasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
      public void descargarPdf() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        
        try {
            File jasper= new File (FacesContext.getCurrentInstance()
                    .getExternalContext().getRealPath("/detalleventas/detalleventasreportes.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),null,Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
         
            respuesta.addHeader("Content-disposition","attachement; filename=detalleventasreportes.pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (JRException ex) {
            Logger.getLogger(ReporteDetalleVentasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteDetalleVentasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
      
       public void certificaDetalleVentas(DetalleVentas detalleventas) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id", detalleventas.getIdDetalleVentas());
        parametros.put("producto", detalleventas.getIdProducto());
                   
        try {
            File jasper= new File (FacesContext.getCurrentInstance()
                    .getExternalContext().getRealPath("/detalleventas/detalleventasreportes.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),parametros,Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type","application/pdf");
            ServletOutputStream flujo = respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper, flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        } catch (JRException ex) {
            Logger.getLogger(ReporteDetalleVentasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteDetalleVentasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
}