package com.gildedrose;

class GildedRose {
    Item[] produits;

    public GildedRose(Item[] produits) {
        this.produits = produits;
    }

    public void incrimentQuality(Item produit){
        if (produit.quality < 50) {
            produit.quality++;
        }
    }

    public void decrimentQuality(Item produit){
        if (produit.quality > 0) {
            produit.quality = produit.quality - 1;
        }
    }

    public void updateQualityBackstage(Item produit){
        if (produit.sellIn < 11) {
            incrimentQuality(produit);
        }
        if (produit.sellIn < 6) {
            incrimentQuality(produit);
        }
    }

    public void updateQualitySwitch(Item produit){
        switch(produit.name){
            case "Aged Brie":
                incrimentQuality(produit);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if(produit.sellIn < 0){
                    produit.quality = 0;
                    break;
                }
                incrimentQuality(produit);
                updateQualityBackstage(produit);
                break;
            default:
                decrimentQuality(produit);
                break;
        }

    }

    public void updateQuality() {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            updateQualitySwitch(produits[i]);
           
            produits[i].sellIn = produits[i].sellIn - 1;

            if (produits[i].sellIn < 0) {
                updateQualitySwitch(produits[i]);
            }
        }
    }
}