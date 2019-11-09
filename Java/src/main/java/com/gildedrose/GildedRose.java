package com.gildedrose;

class GildedRose {
    private static final String CONJURED = "Conjured Mana Cake";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.name.equals(SULFURAS)) {
                continue;
            }

            item.sellIn = item.sellIn - 1;

            if (item.name.equals(BRIE)) {
                augmenterQualite(item);
                if (item.sellIn < 0) {
                    augmenterQualite(item);
                }
                
            } 
            else if (item.name.equals(BACKSTAGE)){
                augmenterQualite(item);

                if (item.sellIn < 10) {
                    augmenterQualite(item);
                }
                if (item.sellIn < 5) {
                    augmenterQualite(item);
                }
                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            }
            else{
                diminuerQualite(item);
            }

            if(item.name.equals(CONJURED)){
                diminuerQualite(item);
            }
        }
    }

    private void diminuerQualite(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
            if (item.sellIn < 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void augmenterQualite(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
