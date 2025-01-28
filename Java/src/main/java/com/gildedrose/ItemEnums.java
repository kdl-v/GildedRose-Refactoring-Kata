package com.gildedrose;

public enum ItemEnums {
    BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    private final String item;

    ItemEnums(String item) {
        this.item = item;
    }

    public String getItem(){
        return item;
    }
}
