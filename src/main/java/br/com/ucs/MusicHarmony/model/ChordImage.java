package br.com.ucs.MusicHarmony.model;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ChordImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="chord_name", nullable=false, unique=true)
    private String chordName;
    @Column(name="image", nullable=false)
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChordName() {
        return chordName;
    }

    public void setChordName(String chordName) {
        this.chordName = chordName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
