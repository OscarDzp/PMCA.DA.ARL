package Operaciones;

import Clases.clsActivo;
import DB.clsListar;
import java.util.ArrayList;

/**
 *
 * @author Karii
 */
public class OpActivos {

    public boolean Guardar(clsActivo obActivo) {
        try {
            clsActivo obConsulta = this.Consultar(obActivo.getCodigo());
            if (obConsulta != null && obConsulta.getIdActivo() == 0) {

                obActivo.setIdActivo(clsListar.cntActivos.size() + 1);

                return clsListar.cntActivos.add(obActivo);
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

                return clsListar.cntActivos.add(obActivo);
            } else {

                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public boolean Eliminar(int idActivo) {
        return clsListar.cntActivos.remove(this.Consultar(idActivo));
    }

    public clsActivo Consultar(int idActivo) {
        clsActivo obRespuesta = new clsActivo();
        try {
            for (clsActivo activo : clsListar.cntActivos) {
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
            for (clsActivo activo : clsListar.cntActivos) {

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
        return clsListar.cntActivos;
    }
}
