package Operaciones;

import Clases.clsActivo;
import DB.clsListas;
import java.util.ArrayList;

/**
 *
 * @author Candy Maria Ramirez Castillo
 */
public class OpActivos {

    public boolean Guardar(clsActivo obActivo) {
        try {
            clsActivo obConsulta = this.Consultar(obActivo.getCodigo());
            if (obConsulta != null && obConsulta.getIdActivo() == 0) {

                obActivo.setIdActivo(clsListas.cntActivos.size() + 1);

                return clsListas.cntActivos.add(obActivo);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Actualizar(clsActivo obActivo) {
        try {

            clsActivo obConsulta = this.Consultar(obActivo.getIdActivo());
            if (obConsulta != null && obConsulta.getIdActivo() > 0) {

                this.Eliminar(obActivo.getIdActivo());

                return clsListas.cntActivos.add(obActivo);
            } else {

                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public boolean Eliminar(int idActivo) {
        return clsListas.cntActivos.remove(this.Consultar(idActivo));
    }

    public clsActivo Consultar(int idActivo) {
        clsActivo obRespuesta = new clsActivo();
        try {
            for (clsActivo activo : clsListas.cntActivos) {
                if (activo.getIdActivo() == idActivo) {
                    obRespuesta = activo;
                    break;
                }
            }
        } catch (Exception e) {
            obRespuesta = null;
        }
        return obRespuesta;
    }

    public clsActivo Consultar(String codigo) {
        clsActivo obRespuesta = new clsActivo();
        try {
            for (clsActivo activo : clsListas.cntActivos) {

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

    public ArrayList<clsActivo> Listar() {
        return clsListas.cntActivos;
    }
}
