package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (item.name.equals("Aged Brie")) {
                augmenterQualite(item);
            } 
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                augmenterQualite(item);

                if (item.sellIn < 11) {
                    augmenterQualite(item);
                }

                if (item.sellIn < 6) {
                    augmenterQualite(item);
                }
            }
            else {
                diminuerQualite(item);
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    augmenterQualite(item);
                }
                else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } 
                else {
                    diminuerQualite(item);
                }
            }
        }
    }

    private void diminuerQualite(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void augmenterQualite(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
