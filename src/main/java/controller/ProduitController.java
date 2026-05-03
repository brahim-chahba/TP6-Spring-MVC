package controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Produit;
import services.ProduitMetier;

@Controller
public class ProduitController {

    @Autowired
    private ProduitMetier services;

    @RequestMapping(value = "/index")
    public String pageIndex(Model model) {
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    @RequestMapping(value = "/searchProduct")
    public String searchProduct(Model model, @RequestParam Long idProduit) {
        List<Produit> liste = new ArrayList<>();
        Produit p = services.getProduitById(idProduit);
        if (p != null)
            liste.add(p);
        model.addAttribute("listeProduit", liste);
        model.addAttribute("idProduit", idProduit);
        return "produits";
    }

    @RequestMapping(value = "/addProduct")
    public String addProduct(Model model, Produit p) {
        services.addProduit(p);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    @RequestMapping(value = "/deleteProduit")
    public String deleteProduit(Model model, @RequestParam Long id) {
        services.deleteProduit(id);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    @RequestMapping(value = "/editProduit", method = RequestMethod.GET)
    public String editProduit(Model model, @RequestParam Long id) {
        model.addAttribute("produitEdit", services.getProduitById(id));
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }

    @RequestMapping(value = "/updateProduit", method = RequestMethod.POST)
    public String updateProduit(Model model,
            @RequestParam Long idProduit,
            @RequestParam String nom,
            @RequestParam String description,
            @RequestParam Double prix) {
        Produit p = new Produit();
        p.setIdProduit(idProduit);
        p.setNom(nom);
        p.setDescription(description);
        p.setPrix(prix);
        services.updateProduit(p);
        model.addAttribute("listeProduit", services.getAllProduits());
        return "produits";
    }
}