package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void ShouldQualityRemainPositiveWhenNormal() {
        Item[] items = new Item[] { new Item("quelconque", 3, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void ShouldQualityDecreaseBy1WhenNormalItem() {
        Item[] items = new Item[] { new Item("quelconque", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }

    @Test
    public void ShouldSellInDecreaseBy1WhenNormalItem() {
        Item[] items = new Item[] { new Item("quelconque", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void ShouldQualityDecreaseBy2WhenNormalItemAndSellIn0() {
        Item[] items = new Item[] { new Item("quelconque", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    public void ShouldQualityStaySameWhenNormalItemAndNegative() {
        Item[] items = new Item[] { new Item("quelconque", 0, -1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].quality);
    }

    @Test
    public void ShouldQualityStayUnder50WhenAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void ShouldQualityIncreaseWhenAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }

    @Test
    public void ShouldQualityIncreaseTwiceWhenAgedBrieSellInNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, app.items[0].quality);
    }

    @Test
    public void ShouldQualityStayUnder50WhenAgedBrieSellInNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void ShouldQualityStaySameWhenSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void ShouldSellInStaySameWhenSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 3, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    public void ShouldQualityIncreaseBy1WhenBackstageAndSellInOver10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(36, app.items[0].quality);
    }

    @Test
    public void ShouldQualityStayUnder50WhenBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void ShouldQualityIncreaseBy2WhenBackstageAndSellInBetween10And5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(37, app.items[0].quality);
    }

    @Test
    public void ShouldQualityStayUnder50WhenBackstageAndSellInBetween10And5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void ShouldQualityIncreaseBy3WhenBackstageAndSellInUnder5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(38, app.items[0].quality);
    }

    @Test
    public void ShouldQualityStayUnder50WhenBackstageAndSellInUnder5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void ShouldSellInStayPositiveWhenBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 35) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
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

    @Test
    public void toStringTest() {
        Item[] items = new Item[] { new Item("quelconque", 20, 20) };
        assertEquals("quelconque, 20, 20", items[0].toString());
    }
}
