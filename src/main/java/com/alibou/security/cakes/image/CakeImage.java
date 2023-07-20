package com.alibou.security.cakes.image;

import com.alibou.security.cakes.Cake;
import com.alibou.security.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CakeImage {
    @Id
    @GeneratedValue
    private Integer id;
    private String imageName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cake_id")
    public Cake cake;
}
