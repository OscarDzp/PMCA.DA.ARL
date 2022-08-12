package Operaciones;

import Clases.clsAutos;
import DB.clsListar;
import java.util.ArrayList;

/**
 *
 * @author Karii
 */
public class OpAutos {

    private clsAutos auto;

    public boolean Guardar(clsAutos obAutos) {
        try {
            clsAutos obConsulta = this.Consultar(obAutos.getCodigo());
            if (obConsulta != null && obConsulta.getIdAutos() == 0) {

                obAutos.setIdAutos(clsListar.cntAutos.size() + 1);

                return clsListar.cntAutos.add(obAutos);
            } else {

                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public boolean Actualizar(clsAutos obAutos) {
        try {

            clsAutos obConsulta = this.Consultar(obAutos.getIdAutos());
            boolean Actualizado = false;
            if (obConsulta != null && obConsulta.getIdAutos() > 0) {
                for (clsAutos Fila : clsListar.cntAutos) {
                    if (Fila.getIdAutos() == obAutos.getIdAutos()) {

                        Fila.setAno(obAutos.getAno());
                        Fila.setAnotaciones(obAutos.getAnotaciones());
                        Fila.setChasis(obAutos.getChasis());
                        Fila.setCilindrada(obAutos.getCilindrada());
                        Fila.setCodigo(obAutos.getCodigo());
                        Fila.setCombustible(obAutos.getCombustible());
                        Fila.setEstado(obAutos.getEstado());
                        Fila.setEstilo(obAutos.getEstilo());
                        Fila.setIdAutos(obAutos.getIdAutos());
                        Fila.setKilometraje(obAutos.getKilometraje());
                        Fila.setMarca(obAutos.getMarca());
                        Fila.setModelo(obAutos.getModelo());
                        Fila.setMotor(obAutos.getMotor());
                        Fila.setPasajeros(obAutos.getPasajeros());
                        Fila.setTransmision(obAutos.getTransmision());
                        Fila.setValor(obAutos.getValor());

                        Actualizado = true;
                        break;
                    }
                }

                return Actualizado;
            } else {

                return Actualizado;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public boolean Eliminar(int idAutos) {
         try {

            clsAutos obConsulta = this.Consultar(idAutos);
            boolean Eliminado = false;
            if (obConsulta != null && obConsulta.getIdAutos() > 0) {
                for (clsAutos Fila : clsListar.cntAutos) {
                    if (Fila.getIdAutos() == idAutos){
                        Eliminado = clsListar.cntAutos.remove(Fila);
                        break;
                    }
                }

                return Eliminado;
            } else {

                return Eliminado;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public clsAutos Consultar(int idAutos) {
        clsAutos obRespuesta = new clsAutos();
        try {
            for (clsAutos autos : clsListar.cntAutos) {
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

    public clsAutos Consultar(String codigo) {
        clsAutos obRespuesta = new clsAutos();
        try {
            for (clsAutos autos : clsListar.cntAutos) {

                if (autos.getCodigo().toLowerCase().equals(codigo)) {
                    obRespuesta = autos;
                    break;
                }
            }
        } catch (Exception e) {
            obRespuesta = null;
        }
        return obRespuesta;
    }

    ArrayList<clsAutos> ArrayAutos = new ArrayList<clsAutos>();

    public ArrayList<clsAutos> Listar() {
        return clsListar.cntAutos;
    }

}
