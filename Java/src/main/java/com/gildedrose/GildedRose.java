package com.gildedrose;

import static com.gildedrose.ItemEnums.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(BRIE.getItem()) &&
                !item.name.equals(BACKSTAGE_PASSES.getItem())) {
                if (item.quality > 0 &&
                    !item.name.equals(SULFURAS.getItem())) {
                    if(item.name.toLowerCase().contains("conjured")) { //added conjured feature
                        item.quality = item.quality - 2;
                    } else {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES.getItem())) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality = item.quality + 1;
                            }

                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS.getItem())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(BRIE.getItem())) {
                    if (!item.name.equals(BACKSTAGE_PASSES.getItem())) {
                        if (item.quality > 0 && !item.name.equals(SULFURAS.getItem())) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = 0; //was item.quality - item.quality
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
