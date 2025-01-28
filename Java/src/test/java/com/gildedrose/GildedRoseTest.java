package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemEnums.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] items;
    private GildedRose app;

    @BeforeEach
    void setUp() {
        items = new Item[] { new Item("Test Item", 5, 10)};
        app = new GildedRose(items);
    }
    @Test
    void foo() {
        app.updateQuality();
        assertEquals("Test Item", app.items[0].name);
    }

    @Test
    void testQualityDecrease() {
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void testSellInDecrease() {
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void testQualityAfterSellInDate() {
        Item[] items = new Item[] { new Item("Test Item2", 0, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void testNonNegative() {
        Item[] items = new Item[] { new Item("Test Item2", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
//        assertNotEquals(-1, app.items[0].quality);
    }

    @Test
    void testBrieQuality() {
        Item[] items = new Item[] { new Item(BRIE.getItem(), 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testBackstageQualityLimitFifty() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getItem(), 5, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackstageQualityAfterConcert() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getItem(), 0, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstageQualityInFive() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getItem(), 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void testBackstageQualityInTen() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES.getItem(), 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void testSulfurasItem() {
        Item[] items = new Item[] { new Item(SULFURAS.getItem(), -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testConjuredItem() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

}
