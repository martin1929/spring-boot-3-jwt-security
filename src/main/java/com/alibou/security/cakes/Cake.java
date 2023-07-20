package com.alibou.security.cakes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cakes")
public class Cake {

    @Id
    @GeneratedValue
    private Integer id;
    private String cakeName;
    private String cakeImgName;
    private String description;
    private Integer price;
}
