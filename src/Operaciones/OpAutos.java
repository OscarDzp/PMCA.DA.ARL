
package Operaciones;

import Clases.clsAutos;
import DB.clsListas;
import java.util.ArrayList;

/**
 *
 * @author Candy Maria Ramirez Castillo
 */
public class OpAutos {
    public boolean Guardar(clsAutos obAutos){
        try {
            clsAutos obConsulta = this.Consultar(obAutos.getCodigo());
            if (obConsulta != null && obConsulta.getIdAutos() == 0) {
                
                obAutos.setIdAutos(clsListas.cntAutos.size() + 1);
                
                return clsListas.cntActivos.add(obAutos);
            } else {
                
                return false;
            }
        } catch (Exception e) {
            
            return false;
        }
    }
    
    public boolean Actualizar(clsAutos obAutos){
        try {
            
            clsAutos obConsulta = this.Consultar(obAutos.getIdAutos());
            if (obConsulta != null && obConsulta.getIdAutos() > 0) {
                
                this.Eliminar(obAutos.getIdAutos());
            
                return clsListas.cntAutos.add(obAutos);
            } else {
                
                return false;
            }
        } catch (Exception e) {
            
            return false;
        }
    }
    
    public boolean Eliminar(int idAutos){
        return clsListas.cntActivos.remove(this.Consultar(idAutos));
    }
    
    public clsAutos Consultar(int idAutos){
        clsAutos obRespuesta = new clsAutos();
        try {
            for (clsAutos autos: clsListas.cntAutos) {
                if (autos.getIdAutos() == idAutos) {
                    obRespuesta = autos;
                    break;
                }
            }
        } catch (Exception e) {
            obRespuesta = null;
        }
        return obRespuesta;
    }
    
    public clsAutos Consultar(String codigo){
        clsAutos obRespuesta = new clsAutos();
        try {
            for (clsAutos activo : clsListas.cntAutos) {
                
                if (activo.getCodigo().toLowerCase().equals(codigo)) {
                    obRespuesta = activo;
                    break;
                }
            }
        } catch (Exception e) {
            obRespuesta = null;
        }
        return obRespuesta;
    }
    
    public ArrayList<clsAutos> Listar(){
        return clsListas.cntAutos;
    }
    
}
