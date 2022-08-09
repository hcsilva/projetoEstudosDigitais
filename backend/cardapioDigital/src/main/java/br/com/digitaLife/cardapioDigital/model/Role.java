package br.com.digitaLife.cardapioDigital.model;


import br.com.digitaLife.cardapioDigital.enums.RoleNameEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "TB_ROLE")
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME", nullable = false, unique = true)
    private RoleNameEnum roleName;

    @Override
    public String getAuthority() {
        return this.roleName.getRoleFormat(this.roleName.toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleNameEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleNameEnum roleName) {
        this.roleName = roleName;
    }
}