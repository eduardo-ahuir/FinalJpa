package Entidades;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@NamedQueries({
        //query to select all the clientes
        @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
        //query to select all the clientes with a given name
        @NamedQuery(name = "Clientes.findByName", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
        @NamedQuery(name = "Clientes.findByoperaciones", query = "SELECT Nombre,Apellidos,cantidad,Fecha FROM clientes p LEFT JOIN operaciones pcc ON p.idclientes = pcc.clientes_idclientes"),




})



public class Clientes {
    @Id
    @Column(name = "idclientes", nullable = false)
    private Integer id;

    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "Apellidos", nullable = false, length = 45)
    private String apellidos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //metodo tostring
    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}