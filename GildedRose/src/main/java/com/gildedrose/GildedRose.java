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
            if (!produits[i].name.equals("Aged Brie")
                    && !produits[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (produits[i].quality > 0) {
                    if (!produits[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        produits[i].quality = produits[i].quality - 1;
                    }
                }
            } else {
                if (produits[i].quality < 50) {
                    incrimentQuality(produits[i]);
                    updateQualityBackstage(produits[i]);
                }
            }

            if (!produits[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                produits[i].sellIn = produits[i].sellIn - 1;
            }

            if (produits[i].sellIn < 0) {
                if (!produits[i].name.equals("Aged Brie")) {
                    if (!produits[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (produits[i].quality > 0) {
                            if (!produits[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                produits[i].quality = produits[i].quality - 1;
                            }
                        }
                    } else {
                        produits[i].quality = 0;
                    }
                } else {
                    if (produits[i].quality < 50) {
                        incrimentQuality(produits[i]);
                    }
                }
            }
        }
    }
}