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
            if (!item.name.equals(ab)
                    && !item.name.equals(TAFKAL80ETC)) {
                if (item.quality > 0) {
                    if (!item.name.equals(sulfuras)) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (item.name.equals(TAFKAL80ETC )) {
                        if (item.sellIn < 11) {
                            item.quality++;

                            if (item.sellIn < 6) {
                                item.quality++;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(sulfuras)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(ab)) {
                    if (!item.name.equals(TAFKAL80ETC)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(sulfuras)) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }
}
