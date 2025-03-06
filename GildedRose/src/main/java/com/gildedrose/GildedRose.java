package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        String ab = "Aged Brie";
        String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
        String sulfuras = "Sulfuras, Hand of Ragnaros";

        for (Item item : items) {
            item.updateQuality();
        }
    }
}
