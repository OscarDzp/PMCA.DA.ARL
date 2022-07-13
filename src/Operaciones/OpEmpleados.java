package Operaciones;

import Clases.clsEmpleado;
import DB.clsListar;
import java.util.ArrayList;

/**
 *
 * @author Candy Maria Ramirez Castillo
 */
public class OpEmpleados {

    public boolean Guardar(clsEmpleado obEmpleado) {
        try {
            clsEmpleado obConsulta = this.Consultar(obEmpleado.getCodigo());
            if (obConsulta != null && obConsulta.getIdEmpleado() == 0) {
                obEmpleado.setIdEmpleado(clsListar.cntEmpleados.size() + 1);
                return clsListar.cntEmpleados.add(obEmpleado);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Actualizar(clsEmpleado obEmpleado) {
        try {
            clsEmpleado obConsulta = this.Consultar(obEmpleado.getIdEmpleado());
            if (obConsulta != null && obConsulta.getIdEmpleado() > 0) {
                this.Eliminar(obEmpleado.getIdEmpleado());
                return clsListar.cntEmpleados.add(obEmpleado);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Eliminar(int idEmpleado) {
        return clsListar.cntEmpleados.remove(this.Consultar(idEmpleado));
    }

    public clsEmpleado Consultar(int idEmpleado) {
        clsEmpleado obRespuesta = new clsEmpleado();
        try {
            for (clsEmpleado empleado : clsListar.cntEmpleados) {
                if (empleado.getIdEmpleado() == idEmpleado) {
                    obRespuesta = empleado;
                    break;
                }
            }
        } catch (Exception e) {
            obRespuesta = null;
        }
        return obRespuesta;
    }

    public clsEmpleado Consultar(String codigo) {
        clsEmpleado obRespuesta = new clsEmpleado();
        try {
            for (clsEmpleado empleado : clsListar.cntEmpleados) {
                if (empleado.getCodigo().toLowerCase().equals(codigo)) {
                    obRespuesta = empleado;
                    break;
                }
            }
        } catch (Exception e) {
            obRespuesta = null;
        }
        return obRespuesta;
    }
    
    public ArrayList<clsEmpleado> Listar(){
        return clsListar.cntEmpleados;
    }

}
