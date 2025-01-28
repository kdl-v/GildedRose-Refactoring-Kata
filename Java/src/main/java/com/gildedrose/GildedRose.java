package com.gildedrose;

import static com.gildedrose.ItemEnums.*;

class GildedRose {
    Item[] items;

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "conjured";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    updateBrie(item);
                    break;
                case BACKSTAGE_PASSES:
                    updateBackstagePasses(item);
                    break;
                case SULFURAS:
                    break;
                default:
                    updateItem(item);
                    break;
            }
        }
    }
    private void updateItem(Item item) {
        if (item.name.toLowerCase().contains(CONJURED) || item.sellIn <= 0) { //added conjured feature
            decreaseQuality(item, 2);
        } else {
            decreaseQuality(item, 1);
        }
        decreaseSellIn(item, 1);
    }

    private void updateBrie(Item item) {
        increaseQuality(item, 1);
        decreaseSellIn(item, 1);
    }

    private void updateBackstagePasses(Item item) {
        if(item.sellIn == 0 ) {
            item.quality = 0;
        }
        if (item.sellIn > 5 && item.sellIn <= 10 ) {
            increaseQuality(item, 2);
        }
        if (item.sellIn <= 5 && item.sellIn > 0) {
            increaseQuality(item, 3);
        }
        decreaseSellIn(item, 1);
    }

    private void increaseQuality(Item item, int num) {
        if(item.quality < 50) {
            item.quality = item.quality + num;
            if(item.quality > 50) {
                item.quality = 50;
            }
        }
    }

    private void decreaseQuality(Item item, int num) {
        if(item.quality > 0 ) {
            item.quality = item.quality - num;

        }
    }

    private void decreaseSellIn(Item item, int num) {
        item.sellIn = item.sellIn - num;
    }
}
