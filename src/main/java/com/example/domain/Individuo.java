
package com.example.domain;

import lombok.Data;
import jakarta.persistence.*; 
import java.io.Serializable;

@Entity
@Data
@Table(name ="individuo")
public class Individuo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_individuo;

    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Correo;
    private String Edad;

    // Constructor, getters, and setters
}
