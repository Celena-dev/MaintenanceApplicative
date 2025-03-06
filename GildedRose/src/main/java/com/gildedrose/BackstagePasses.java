package com.gildedrose;

public class BackstagePasses extends Item {

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality++;

            if (sellIn < 11) {
                quality++;

                if (sellIn < 6) {
                    quality++;
                }
            }
        }

        sellIn--;

        if (sellIn < 0) {
            quality = 0;
        }
    }
}
