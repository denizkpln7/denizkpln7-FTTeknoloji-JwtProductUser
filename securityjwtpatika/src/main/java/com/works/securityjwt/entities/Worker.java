package com.works.securityjwt.entities;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @NotBlank(message = "isim giriniz")
    private String name;
    @Length(message = "5 ila 15 karekter", min = 5, max = 15)
    @NotNull
    private String surname;
    @Min(message = "18 yaşından küçükler giremez", value = 18)
    @Column(nullable = false)
    private int age ;

    private  Long jid;

}
