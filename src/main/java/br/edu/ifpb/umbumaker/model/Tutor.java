package br.edu.ifpb.umbumaker.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TUTOR")
public class Tutor extends ContaAcesso {
    
}