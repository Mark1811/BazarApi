package com.bazar.bazar.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter

public class Productos implements Comparable<Productos> {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String nomproduct;

    @NotNull
    private int precio;

    @NotNull
    private int stock;

    @Override
    public int compareTo(Productos pr) {
        if(this.getPrecio() < pr.getPrecio()){
            return -1;
        }else{
            if(this.getPrecio()>pr.getPrecio()){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
