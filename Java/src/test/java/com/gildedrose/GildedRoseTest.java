package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void positiveQuality() {
        Item[] items = new Item[] { new Item("quelconque", 3, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void qualityUnder50() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void normalItemQualtity() {
        Item[] items = new Item[] { new Item("quelconque", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }

    @Test
    public void normalItemSellIn() {
        Item[] items = new Item[] { new Item("quelconque", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void normalItemQualityZeroSellIn() {
        Item[] items = new Item[] { new Item("quelconque", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    public void normalItemNegativeQualityZeroSellIn() {
        Item[] items = new Item[] { new Item("quelconque", 0, -1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].quality);
    }

    @Test
    public void agedBrieQualtity() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }

    @Test
    public void agedBrieQualtityNegativeSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    @Test
    public void agedBrieQualtity50NegativeSellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfurasQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void sulfurasSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    public void SulfurasQualityNegativeSellIn() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);
    }

    @Test
    public void backstageQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(36, app.items[0].quality);
    }

    @Test
    public void backstageQuality50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstageQualitySellIn10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(37, app.items[0].quality);
    }

    @Test
    public void backstageQuality50SellIn10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstageQualitySellIn5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(38, app.items[0].quality);
    }

    @Test
    public void backstageQuality50SellIn5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstageQualitySellIn0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void toStringTest() {
        Item[] items = new Item[] { new Item("quelconque", 20, 20) };
        assertEquals("quelconque, 20, 20", items[0].toString());
    }

    @Test
    public void shouldDecreaseTwiceFasterWhenConjured() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 20, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseTwiceFasterWhenConjuredSellIn0() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
    }
}
