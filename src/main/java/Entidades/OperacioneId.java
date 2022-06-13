package Entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OperacioneId implements Serializable {
    private static final long serialVersionUID = -7639905490520347935L;
    @Column(name = "idOperaciones", nullable = false)
    private Integer idOperaciones;

    @Column(name = "clientes_idclientes", nullable = false)
    private Integer clientesIdclientes;

    public Integer getIdOperaciones() {
        return idOperaciones;
    }

    public void setIdOperaciones(Integer idOperaciones) {
        this.idOperaciones = idOperaciones;
    }

    public Integer getClientesIdclientes() {
        return clientesIdclientes;
    }

    public void setClientesIdclientes(Integer clientesIdclientes) {
        this.clientesIdclientes = clientesIdclientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperacioneId entity = (OperacioneId) o;
        return Objects.equals(this.clientesIdclientes, entity.clientesIdclientes) &&
                Objects.equals(this.idOperaciones, entity.idOperaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientesIdclientes, idOperaciones);
    }

}