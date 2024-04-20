package com.cb.dckpst.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_tables")
public class Menumkn {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String namaMakanan;

    private String namaMinuman;

    private String jumlah;

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the namaMakanan
     */
    public String getNamaMakanan() {
        return namaMakanan;
    }

    /**
     * @param namaMakanan the namaMakanan to set
     */
    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    /**
     * @return String return the namaMinuman
     */
    public String getNamaMinuman() {
        return namaMinuman;
    }

    /**
     * @param namaMinuman the namaMinuman to set
     */
    public void setNamaMinuman(String namaMinuman) {
        this.namaMinuman = namaMinuman;
    }

    /**
     * @return String return the jumlah
     */
    public String getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

}
