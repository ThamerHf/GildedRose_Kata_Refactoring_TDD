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
        if (produit.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (produit.sellIn < 11) {
                incrimentQuality(produit);
            }
            if (produit.sellIn < 6) {
                incrimentQuality(produit);
            }
        }
    }

    public void updateQuality() {
        for (int i = 0; i < produits.length; i++) {
            if (produits[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            switch(produits[i].name){
                case "Aged Brie":
                    incrimentQuality(produits[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    incrimentQuality(produits[i]);
                    updateQualityBackstage(produits[i]);
                    break;
                default:
                    decrimentQuality(produits[i]);
                    break;
            }
           

            produits[i].sellIn = produits[i].sellIn - 1;

            if (produits[i].sellIn < 0) {
                if (!produits[i].name.equals("Aged Brie")) {
                    if (!produits[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        decrimentQuality(produits[i]);
                    } else {
                        produits[i].quality = 0;
                    }
                } else {
                    incrimentQuality(produits[i]);
                }
            }
        }
    }
}