/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;
import Clases.clsActivo;
import DB.clsListas;
import java.util.ArrayList;
/**
 *
 * @author Candy Maria Ramirez Castillo
 */

public class OpActivos {
    //CRUD de Activos
    public boolean Guardar(clsActivo obActivo){
        try {
            //Realizar la consulta 
            clsActivo obConsulta = this.Consultar(obActivo.getIdActivo());
            if (obConsultar != null || obConsulta.getIdActivo() == 0){
                //Cuando no existe se guarda.
                return clsListas.cntActivos.add(obActivo);
            }else{
                return false;
                
            }
        }catch (Exception e){
            //Cuando existe o generar error falso. 
            return false;
        }
    }
    
    public boolean Actualizar(clsActivo obActivo){
        try {
             //Realizar la consulta 
            clsActivo obConsulta = this.Consultar(obActivo.getIdActivo());
             if (obConsultar != null || obConsulta.getIdActivo() > 0){
                 //Eliminamos el objeto.
                 this.Eliminar(obActivo.getIdActivo());
                 
                //Cuando no existe se guarda.
                return clsListas.cntActivos.add(obActivo);
            }else{
                return false;     
            }
        }catch (Exception e){
            //Cuando no existe o generar error falso.
            return false;
        }
    }
    
    public boolean Eliminar(int idActivo){
        return clsListas.cntActivos.remove(this.Consultar(idActivo));
    }
    
    public clsActivo Consultar(int idActivo){
        clsActivo obRespuesta = new clsActivo();
        try {
            for (clsActivo activo: clsListas.cntActivos){
                if (activo.getIdActivo()== idActivo){
                    obRespuesta = activo;
                    break;
                }
            }
        }catch (Exception e){
            obRespuesta = null;
        }
        return obRespuesta;

}
    

}
