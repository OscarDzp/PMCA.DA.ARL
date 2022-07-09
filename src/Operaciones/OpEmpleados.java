/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;

import Clases.clsEmpleado;
import DB.clsListas;
import java.util.ArrayList;

/**
 *
 * @author Candy Maria Ramirez Castillo 
 */
public class OpEmpleados {

    private Object obEmpleado;
    // CRUD de Activos
    public boolean Guarda(clsEmpleado obEmpleado){
        try {
            clsEmpleado obCobsulta = this.Consultar(obEmpleado.getCodigo());
            if (obConsulta != null && obConsulta.getEmpleado() == 0){
               obEmpleado.setIdEmpleado(clsListas.cntEmpleados.size() + 1);
               return clsListas.cntEmpleados.add(obEmpleado);
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean Actualizar(clsEmpleado obEmplado){
        try {
            clsEmpleado obCobsulta = this.Consulta(obEmpleado.getIdEmpleado());
            if (obConsulta != null && obConsulta.getEmpleado() > 0){ 
                this.Eliminar(obEmpleado.getIdEmpleado());
                return clsListas.cntEmpleados.add(obEmplado);
            }else{
                return false;
            }
        } catch (Exception e){
            return false;    
        }        
    }
    
    public boolean Eliminar(int idEmpleado){
        return clsListas.cntEmpleados.remove(this.Consultar(idEmpleado));
    }  
    
  
   public clsEmpleado Consultar(int idEmpleado){
       clsEmpleado obRespuesta = new clsEmpleado();
       try {
           for (clsEmpleado empleado : clsListas.cntEmpleados) {
               if (empleado.getIdEmpleado() == idEmpleado) {
                   obRespuesta = empleado;
                   break;
               }
           }
       }catch (Exception e){
           obRespuesta = null;
       }    
       return obRespuesta;
   } 
  
   public clsEmpleado Consultar(String codigo){
       clsEmpleado obRespuesta = new clsEmpleado();
       try {
           for (clsEmpleado empleado : clsListas.cntEmpleados) {
               if (empleado.getCodigo().toLowerCase().equals(codigo)) {
                   obRespuesta = empleado;
                   break;
               }
           }
       }catch (Exception e){
           obRespuesta = null;
       }    
       return obRespuesta;
    
    public ArrayList<clsEmpleado> Listar(){
        return clsListas.cntEmpleados;
    }
        
}

