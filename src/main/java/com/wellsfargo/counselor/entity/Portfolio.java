package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="portfolios")
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    @ManyToOne
    @JoinColumn(name="clients_id", nullable=false)
    private Client client;

    @OneToMany(mappedBy="portfolios")
    private ArrayList<Security> securities = new ArrayList<Security>();

    @Column(nullable = false)
    private Date creationDate;

    protected Portfolio() {

    }

    public Portfolio(Date cd, ArrayList<Security> s) {
        this.creationDate = cd;
        this.securities = s;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setSecurities(ArrayList<Security> sc){
        this.securities = sc;
    }
    public ArrayList<Security> getSecurities(String email) {
        return securities;
    }
}
