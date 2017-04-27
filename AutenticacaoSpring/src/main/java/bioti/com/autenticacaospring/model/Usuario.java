package bioti.com.autenticacaospring.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Column(name = "ID_USUARIO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "USUARIO", unique = true, nullable = false)
    private String usuario;

    @NotEmpty
    @Column(name = "SENHA", nullable = false)
    private String senha;

    @NotEmpty
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotEmpty
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotEmpty
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "USUARIO_PERFIL", 
//             joinColumns = { @JoinColumn(name = "ID_USUARIO") }, 
//             inverseJoinColumns = { @JoinColumn(name = "ID_USUARIO") })
    @JoinTable(name = "USUARIO_PERFIL", joinColumns = {
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")})
    @ManyToMany
    private Collection<Perfil> usuarioPerfils;
    //private Set<Perfil> usuarioPerfils = new HashSet<Perfil>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Perfil> getUsuarioPerfils() {
        return usuarioPerfils;
    }

    public void setUsuarioPerfils(Collection<Perfil> usuarioPerfils) {
        this.usuarioPerfils = usuarioPerfils;
    }

    

//    public Set<Perfil> getUserProfiles() {
//        return usuarioPerfils;
//    }
//
//    public void setUserProfiles(Set<Perfil> userProfiles) {
//        this.usuarioPerfils = userProfiles;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (usuario == null) {
            if (other.usuario != null) {
                return false;
            }
        } else if (!usuario.equals(other.usuario)) {
            return false;
        }
        return true;
    }

}
