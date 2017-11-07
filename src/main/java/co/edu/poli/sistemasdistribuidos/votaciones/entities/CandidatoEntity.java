package co.edu.poli.sistemasdistribuidos.votaciones.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CANDIDATO")
public class CandidatoEntity extends BaseEntity implements Serializable {
    @OneToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "ID_PARTIDO")
    private PartidoEntity partido;

    @OneToMany(mappedBy = "candidato", fetch = FetchType.LAZY)
    private Set<VotoEntity> votos;

    @ManyToMany(mappedBy = "candidatos")
    private Set<EleccionEntity> elecciones;

    @Column(name = "BIOGRAFIA")
    private String biografia;

    @Lob
    @Column(name = "FOTO")
    private byte[] foto;

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public PartidoEntity getPartido() {
        return partido;
    }

    public void setPartido(PartidoEntity partido) {
        this.partido = partido;
    }

    public Set<VotoEntity> getVotos() {
        return votos;
    }

    public void setVotos(Set<VotoEntity> votos) {
        this.votos = votos;
    }

    public Set<EleccionEntity> getElecciones() {
        return elecciones;
    }

    public void setElecciones(Set<EleccionEntity> elecciones) {
        this.elecciones = elecciones;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}