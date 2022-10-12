package com.gildedrose;

class GildedRose {
    Item[] produits;

    public GildedRose(Item[] produits) {
        this.produits = produits;
    }


/************************************************************************/
/* incrementQuality: incrementer la qualité d'un produit passé en       */
/*                  en testant que la qualité est inférieur à 50        */
/*                                                                      */
/* Entrée: produit de type Item                                         */
/*                                                                      */
/* Sortie: void                                                         */
/************************************************************************/

    private void incrimentQuality(Item produit){
        if (produit.quality < 50) {
            produit.quality++;
        }
    }

    private void decrimentQuality(Item produit){
        if (produit.quality > 0) {
            produit.quality = produit.quality - 1;
        }
    }

/************************************************************************/
/* updateQuality: incrementer la qualité d'un produit passé en       */
/*                  en testant que la qualité est inférieur à 50        */
/*                                                                      */
/* Entrée: produit de type Item                                         */
/*                                                                      */
/* Sortie: void                                                         */
/************************************************************************/
    private void updateQualityBackstage(Item produit){
        if (produit.sellIn < 11) {
            incrimentQuality(produit);
        }
        if (produit.sellIn < 6) {
            incrimentQuality(produit);
        }
    }

/************************************************************************/
/* updateQualitySwitch: incrementer ou decrémenter la qualité d'un      */
/*                      produit passé en  paramétre, la modification    */
/*                      de la qualité se fait en fonction du nom de     */
/*                      produit                                         */
/*                                                                      */
/*                                                                      */
/* Entrée: produit de type Item                                         */
/*                                                                      */
/* Sortie: void                                                         */
/************************************************************************/
    private void updateQualitySwitch(Item produit){
        switch(produit.name){
            case "Aged Brie":
                this.incrimentQuality(produit);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if(produit.sellIn < 0){
                    produit.quality = 0;
                    break;
                }
                this.incrimentQuality(produit);
                this.updateQualityBackstage(produit);
                break;
            case "Conjured":
                this.decrimentQuality(produit);
                this.decrimentQuality(produit);
                break;
            default:
                this.decrimentQuality(produit);
                break;
        }
    }

/************************************************************************/
/* updateQuality: itérer sur l'ensemble de produit, mettre à jour la    */
/*                qualité de tous les produits                          */
/*                                                                      */
/*                                                                      */
/* Entrée: produit de type Item                                         */
/*                                                                      */
/* Sortie: void                                                         */
/************************************************************************/
    public void updateQuality() {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            this.updateQualitySwitch(produits[i]);
            produits[i].sellIn = produits[i].sellIn - 1;

            if (produits[i].sellIn < 0) {
                this.updateQualitySwitch(produits[i]);
            }
        }
    }
}