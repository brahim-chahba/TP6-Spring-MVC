package dao;

import javax.persistence.*;


@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produit")
	private Long idProduit;

	@Column(name = "nom", nullable = false, length = 100)
	private String nom;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "prix", nullable = false)
	private Double prix;

	
	public Produit() {
	}

	public Produit(String nom, String description, Double prix) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}

	// Getters & Setters
	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
}