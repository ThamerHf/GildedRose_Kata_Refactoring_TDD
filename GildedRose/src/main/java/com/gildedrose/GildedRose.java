package com.gildedrose;

class GildedRose {
    Item[] produits;

    public GildedRose(Item[] produits) {
        this.produits = produits;
    }

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

    private void updateQualityBackstage(Item produit){
        if (produit.sellIn < 11) {
            incrimentQuality(produit);
        }
        if (produit.sellIn < 6) {
            incrimentQuality(produit);
        }
    }

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
            default:
                this.decrimentQuality(produit);
                break;
        }

    }

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